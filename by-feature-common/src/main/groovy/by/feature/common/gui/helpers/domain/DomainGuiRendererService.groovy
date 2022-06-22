package by.feature.common.gui.helpers.domain

import by.feature.common.artefacts.ByFeatureService
import org.grails.datastore.mapping.model.MappingContext
import org.grails.datastore.mapping.model.PersistentEntity
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.scaffolding.model.DomainModelService
import org.grails.scaffolding.model.property.DomainPropertyFactory
import org.springframework.beans.factory.annotation.Autowired

@ByFeatureService
class DomainGuiRendererService {

    protected BeanAndPrefixStack beanStack = new BeanAndPrefixStack()

    void renderDomainAsForm ( entityBean , beanPrefixStr = "" ){
        BeanAndPrefix beanPrefix = resolveBeanAndPrefix(entityBean, beanPrefixStr, [:])
        try {
            beanStack.push(beanPrefix)
            def bean = resolveBean(entityBean)
            def prefix = resolvePrefix(beanPrefixStr)
            def domainClass = resolveDomainClass(bean)
            if (domainClass) {
                for (property in resolvePersistentProperties(domainClass, [:])) {
                    //out << field([bean: bean, property: property.name, prefix: prefix])
                    log.debug " ....,.Found property : ${property}"
                }
            } else {
                //throwTagError('Tag [all] currently only supports domain types')
                throw new RuntimeException("Tag [all] currently only supports domain types")
            }
        } finally {
            beanStack.pop()
        }
    }



    private BeanAndPrefix resolveBeanAndPrefix(beanAttribute, prefixAttribute, attributes) {
//        def bean = resolvePageScopeVariable(beanAttribute) ?: beanAttribute
//        def prefix = resolvePageScopeVariable(prefixAttribute) ?: prefixAttribute
        def bean = beanAttribute
        def prefix = prefixAttribute
        def innerAttributes = attributes.clone()
        innerAttributes.remove('bean')
        innerAttributes.remove('prefix')
        //'except' is a reserved word for the 'all' tag: https://github.com/grails-fields-plugin/grails-fields/issues/12
        innerAttributes.remove('except')
        new BeanAndPrefix(bean: bean, prefix: prefix, innerAttributes: innerAttributes)
    }

    protected Object resolveBean(beanAttribute) {
        return beanAttribute
    }

    protected String resolvePrefix(prefixAttribute) {
        def prefix = prefixAttribute
        if (prefix && !prefix.endsWith('.'))
            prefix = prefix + '.'
        prefix ?: ''
    }

    protected PersistentEntity resolveDomainClass(bean) {
        resolveDomainClass(bean.getClass())
    }

    protected PersistentEntity resolveDomainClass(Class beanClass) {
        resolveDomainClass(beanClass.name)
    }


    @Autowired(required = false)
    Collection<MappingContext> mappingContexts

    protected PersistentEntity resolveDomainClass(String beanClassName) {
        mappingContexts.findResult { MappingContext mappingContext ->
            mappingContext.getPersistentEntity(beanClassName)
        }
    }


    DomainModelService domainModelService
    DomainPropertyFactory fieldsDomainPropertyFactory


    protected static List<String> getList(def except, List<String> defaultList = []) {
        if (!except) {
            return defaultList
        } else if (except instanceof String) {
            except?.tokenize(',')*.trim()
        } else if (except instanceof Collection) {
            return except as List<String>
        } else {
            throw new IllegalArgumentException("Must either be null, comma separated string or java.util.Collection")
        }
    }

    protected List<PersistentProperty> resolvePersistentProperties(PersistentEntity domainClass, Map attrs, boolean list = false) {
        List<PersistentProperty> properties

        if (attrs.order) {
            if (attrs.except) {
                throw new RuntimeException('The [except] and [order] attributes may not be used together.')
            }
            def orderBy = getList(attrs.order)
            properties = orderBy.collect { propertyName ->
                fieldsDomainPropertyFactory.build(domainClass.getPropertyByName(propertyName))
            }
        } else {
            properties = list ? domainModelService.getListOutputProperties(domainClass) : domainModelService.getInputProperties(domainClass)
            // If 'except' is not set, but 'list' is, exclude 'id', 'dateCreated' and 'lastUpdated' by default
            List<String> blacklist = attrs.containsKey('except') ? getList(attrs.except) : (list ? ['id', 'dateCreated', 'lastUpdated'] : [])

            properties.removeAll { it.name in blacklist }
        }

        return properties
    }
}

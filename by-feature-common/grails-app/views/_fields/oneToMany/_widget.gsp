<%@ page import="org.grails.datastore.mapping.model.PersistentEntity; org.grails.datastore.mapping.model.types.Association" %>


<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- template source: _fields/default/oneToMany/_widget.gsp - BEGIN !-->
</g:if>

<select name="cars" id="cars" multiple>
    <g:each in="${value}">
        <option value="${it.id}">${it.toString().encodeAsHTML()}</option>
    </g:each>
</select>

<ul class="oneToMany">
    <g:each in="${value}">
        <li>
            <g:link controller="${controllerName}" action="show" id="${it.id}">
                ${it.toString().encodeAsHTML()}
            </g:link>
        </li>
    </g:each>
</ul>
<%
    //def persistentProperty = persistentProperty
    def assocControllerName
    def shortName
    if (persistentProperty instanceof org.grails.datastore.mapping.model.types.Association) {
        org.grails.datastore.mapping.model.types.Association prop = ((org.grails.datastore.mapping.model.types.Association) persistentProperty)
        assocControllerName = prop.associatedEntity.decapitalizedName
        shortName = prop.associatedEntity.javaClass.simpleName
    }

    def referencedTypeLabel = message(code: "${controllerName}.label", default: shortName)
	def addLabel = message(code: 'default.add.label', args: [referencedTypeLabel])
	org.grails.datastore.mapping.model.PersistentEntity beanClass = (org.grails.datastore.mapping.model.PersistentEntity) beanClass

    def delegatedParams = new HashMap()
    String beanId = bean.id
    delegatedParams.put("'${persistentProperty.owner.decapitalizedName}.id'", "'2'")
    //${}.id' : '1'
    def myBuffer = g.link( controller: assocControllerName, action: "create", params: [("${persistentProperty.owner.decapitalizedName}.id".toString()): bean.id], addLabel)
%>
<p>default id: ${bean.id} - ${beanId}</p>
${raw(myBuffer)}

<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- layout source: /_fields/default/oneToMany/_widget.gsp - END !-->
</g:if>


<!--
%{--        buffer << '<ul>'--}%
%{--		def persistentProperty = model.persistentProperty--}%
%{--		def controllerName--}%
%{--		def shortName--}%
%{--		if (persistentProperty instanceof Association) {--}%
%{--			Association prop = ((Association) persistentProperty)--}%
%{--			controllerName = prop.associatedEntity.decapitalizedName--}%
%{--			shortName = prop.associatedEntity.javaClass.simpleName--}%
%{--		}--}%

%{--		attrs.value.each {--}%
%{--			buffer << '<li>'--}%
%{--			buffer << g.link(controller: controllerName, action: "show", id: it.id, it.toString().encodeAsHTML())--}%
%{--			buffer << '</li>'--}%
%{--		}--}%
%{--		buffer << '</ul>'--}%
%{--		def referencedTypeLabel = message(code: "${controllerName}.label", default: shortName)--}%
%{--		def addLabel = g.message(code: 'default.add.label', args: [referencedTypeLabel])--}%
%{--		PersistentEntity beanClass = (PersistentEntity) model.beanClass--}%
%{--		buffer << g.link(controller: controllerName, action: "create", params: [("${beanClass.decapitalizedName}.id".toString()): model.bean.id], addLabel)--}%
%{--		buffer.buffer--}%
-->
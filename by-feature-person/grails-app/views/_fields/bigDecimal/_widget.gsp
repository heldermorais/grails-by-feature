<%@ page import="org.grails.datastore.mapping.model.PersistentEntity; org.grails.datastore.mapping.model.types.Association" %>


<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- template source: _fields/default/oneToMany/_widget.gsp - BEGIN !-->
</g:if>

<input type="number" step="any" name="${property}" id="${property}" value="${value}" >


<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- layout source: /_fields/default/oneToMany/_widget.gsp - END !-->
</g:if>


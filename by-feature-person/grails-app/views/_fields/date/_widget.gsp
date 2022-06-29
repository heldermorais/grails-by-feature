<%@ page import="org.grails.datastore.mapping.model.PersistentEntity; org.grails.datastore.mapping.model.types.Association" %>


<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- template source: _fields/default/oneToMany/_widget.gsp - BEGIN !-->
</g:if>

<%
    String formattedDate = formatDate(format:"yyyy-MM-dd", date: value)
%>
<input type="date" name="${property}" id="${property}" value="${formattedDate}" >


<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- layout source: /_fields/default/oneToMany/_widget.gsp - END !-->
</g:if>


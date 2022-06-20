<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- source: /templates/common/navigation/_navigation-menu-item.gsp - BEGIN !-->
</g:if>
<li>
   <a class="${cssClasses}" href="${href}">${raw(label)}</a>
</li>
<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- source: /templates/common/navigation/_navigation-menu-item.gsp - END !-->
</g:if>
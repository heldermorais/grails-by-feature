<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- source: /templates/common/navigation/_navigation-menu.gsp - BEGIN !-->
</g:if>
<div class="nav" role="navigation">
    <ul>
       ${raw(innerBody)}
    </ul>
</div>
<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- source: /templates/common/navigation/_navigation-menu.gsp - END !-->
</g:if>
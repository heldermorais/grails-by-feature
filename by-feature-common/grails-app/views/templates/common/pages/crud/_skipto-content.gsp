<g:if test="${grails.util.Environment.isDevelopmentMode()}">
<!-- source: /templates/common/_skipto-content.gsp !-->
</g:if>
<a href="#${skipTo}" class="skip" tabindex="-1">
    <g:message code="default.link.skip.label"
               default="Skip to content&hellip;"/>
</a>
<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- template source: _fields/default/_wrapper.gsp - BEGIN !-->
</g:if>

<div class="fieldcontain ${invalid ? 'has-error' : ''} ${required ? 'required' : ''}">

    <label for="${property}" class="property-label">${label} <span class="required-indicator"><g:if test="${required}">*</g:if><g:else>&nbsp;</g:else></span> </label>

    <div class="property-value">
        ${raw(widget)}
    </div>

</div>

<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- layout source: /_fields/default/_wrapper.gsp - END !-->
</g:if>
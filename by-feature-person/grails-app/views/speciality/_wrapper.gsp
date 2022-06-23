<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- template source: _fields/default/_wrapper.gsp - BEGIN !-->
</g:if>
<hook:renderWithHook hookName="gui.render.field.wrapper" controllerName="${controllerName}"
                     actionName="${actionName}"
                     entityTypeName="${entityTypeName}" domainList="${domainList}" domainCount="${domainCount}" flash="${flash}">
<div class="form-group row ${invalid ? 'has-error' : ''}">
    <label for="${field}" class="col-sm-2 col-form-label" >${label} <g:if test="${required}"> (<span style="font-size: x-small; color: red;"><i class="fa fa-regular fa-asterisk"></i></span>) </g:if></label>

    <div class="col-sm-10">
        ${widget}
        <g:if test="${errors}">
            <g:each in="${errors}" var="error">
                <span class="help-block"><g:message error="${error}"/></span>
            </g:each>
        </g:if>
        <small id="${field}Help" class="form-text text-muted"><g:message code="${persistentProperty?.owner?.getDecapitalizedName()}.${property}.help" default="${persistentProperty?.owner?.getDecapitalizedName()}.${property}"/></small>
    </div>
</div>
</hook:renderWithHook>
<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- layout source: /_fields/default/_wrapper.gsp - END !-->
</g:if>
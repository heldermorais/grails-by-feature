<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- source: /templates/common/pages/crud/_navMenu.gsp - BEGIN !-->
</g:if>
<gui:navigationMenu menuState="${menuState}">

    <hook:renderWithHook hookName="gui.render.crud.navMenuItem.home" controllerName="${controllerName}" actionName="${actionName}"
                         entityTypeName="${entityTypeName}" menuState="${menuState}">
        <gui:navMenuItem href="${createLink(uri: '/')}"
                         cssClasses="home"
                         label="${message (code:'default.home.label')}" />
    </hook:renderWithHook>

    <hook:renderWithHook hookName="gui.render.crud.navMenuItem.list" controllerName="${controllerName}" actionName="${actionName}"
                         entityTypeName="${entityTypeName}" menuState="${menuState}">
        <gui:navMenuItem menuStates="[2,3,4,5]"
                         href="${createLink(action: 'index')}"
                         cssClasses="list">
            <g:message code="default.list.label" args="[entityName]" />
        </gui:navMenuItem>
    </hook:renderWithHook>

    <hook:renderWithHook hookName="gui.render.crud.navMenuItem.create" controllerName="${controllerName}" actionName="${actionName}"
                         entityTypeName="${entityTypeName}" menuState="${menuState}">
        <gui:navMenuItem menuStates="[1,2,3,4]"
                         href="${createLink(action: 'create')}"
                         cssClasses="create">
            <g:message code="default.new.label" args="[entityName]" />
        </gui:navMenuItem>
    </hook:renderWithHook>


    <hook:renderWithHook hookName="gui.render.crud.navMenuItem.additional" controllerName="${controllerName}" actionName="${actionName}"
                         entityTypeName="${entityTypeName}" menuState="${menuState}">
    </hook:renderWithHook>

</gui:navigationMenu>
<g:if test="${grails.util.Environment.isDevelopmentMode()}">
    <!-- source: /templates/common/pages/crud/_navMenu.gsp - END !-->
</g:if>
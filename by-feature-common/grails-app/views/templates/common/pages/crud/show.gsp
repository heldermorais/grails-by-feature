<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="common"/>

    <g:set var="entityTypeName" value="${entityTypeName}"/>
    <g:set var="entityName" value="${message(code: entityTypeName + '.label', default: defaultEntityName)}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>

<hook:renderWithHook hookName="gui.render.crud.show" controllerName="${controllerName}" actionName="${actionName}"
                     entityTypeName="${entityTypeName}" domain="${domain}" flash="$flash}">
    <div id="content" role="main">
        <div class="container">

            <section class="row">

                <g:set var="skipTo" value="#show-${entityTypeName}"/>
                <g:render template="/templates/common/pages/crud/skipto-content" model="[skipTo = skipTo]"/>


                <hook:renderWithHook hookName="gui.render.crud.show.navMenu" controllerName="${controllerName}"
                                     actionName="${actionName}"
                                     entityTypeName="${entityTypeName}" domain="${domain}" flash="$flash}">

                    <g:render template="/templates/common/pages/crud/navMenu"
                              model="[menuState: 2, entityName: entityName, controllerName: controllerName, actionName: actionName, entityTypeName: entityTypeName]"/>

                </hook:renderWithHook>
            </section>

            <section class="row">
                <div id="show-${entityTypeName}" class="col-12 content scaffold-show" role="main">

                    <hook:renderWithHook hookName="gui.render.crud.show.content" controllerName="${controllerName}"
                                         actionName="${actionName}"
                                         entityTypeName="${entityTypeName}" domain="${domain}" flash="$flash}">

                        <h1><g:message code="default.show.label" args="[entityName]"/></h1>
                        <g:if test="${flash.message}">
                            <div class="message" role="status">${flash.message}</div>
                        </g:if>

                        <f:display bean="domain"/>
                        <g:form method="DELETE">
                            <g:hiddenField name="id" value="${domain.id}"/>
                            <fieldset class="buttons">
                                <g:link class="edit" action="edit" id="${domain.id}"><g:message
                                        code="default.button.edit.label" default="Edit"/></g:link>
                                <input class="delete" type="submit"
                                       value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                                       onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
                            </fieldset>
                        </g:form>
                    </hook:renderWithHook>
                </div>
            </section>

        </div>
    </div>
</hook:renderWithHook>
</body>
</html>

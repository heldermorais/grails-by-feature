<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="common"/>

    <g:set var="entityTypeName" value="${entityTypeName}"/>
    <g:set var="entityName" value="${message(code: entityTypeName + '.label', default: defaultEntityName)}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>

<hook:renderWithHook hookName="gui.render.crud.create" controllerName="${controllerName}" actionName="${actionName}"
                     entityTypeName="${entityTypeName}" domain="${domain}" flash="$flash}">
    <div id="content" role="main">
        <div class="container">

            <section class="row">
                <g:set var="skipTo" value="#create-${entityTypeName}"/>
                <g:render template="/templates/common/pages/crud/skipto-content" model="[skipTo = skipTo]"/>

                <hook:renderWithHook hookName="gui.render.crud.create.navMenu" controllerName="${controllerName}"
                                     actionName="${actionName}"
                                     entityTypeName="${entityTypeName}" domain="${domain}" flash="$flash}">
                    <g:render template="/templates/common/pages/crud/navMenu"
                              model="[menuState: 5, entityName: entityName]"/>
                </hook:renderWithHook>
            </section>


            <section class="row">
                <div id="create-${entityTypeName}" class="col-12 content scaffold-create" role="main">
                    <hook:renderWithHook hookName="gui.render.crud.create.content" controllerName="${controllerName}"
                                         actionName="${actionName}"
                                         entityTypeName="${entityTypeName}" domain="${domain}" flash="$flash}">
                        <h1><g:message code="default.create.label" args="[entityName]"/></h1>
                        <g:if test="${flash.message}">
                            <div class="message" role="status">${flash.message}</div>
                        </g:if>
                        <g:hasErrors bean="${domain}">
                            <ul class="errors" role="alert">
                                <g:eachError bean="${domain}" var="error">
                                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                                            error="${error}"/></li>
                                </g:eachError>
                            </ul>
                        </g:hasErrors>
                        <g:form action="save" method="POST">
                            <fieldset class="form">
                                <f:all bean="${domain}"/>
                            </fieldset>
                            <fieldset class="buttons">
                                <g:submitButton name="create" class="save"
                                                value="${message(code: 'default.button.create.label', default: 'Create')}"/>
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

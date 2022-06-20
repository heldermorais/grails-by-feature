<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="common"/>

    <g:set var="entityTypeName" value="${entityTypeName}"/>
    <g:set var="entityName" value="${message(code: entityTypeName + '.label', default: defaultEntityName)}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>

<hook:renderWithHook hookName="gui.render.crud.edit" controllerName="${controllerName}" actionName="${actionName}"
                     entityTypeName="${entityTypeName}" domain="${domain}" flash="$flash}">

    <div id="content" role="main">
        <div class="container">

            <section class="row">

                <g:set var="skipTo" value="#create-${entityTypeName}"/>
                <g:render template="/templates/common/pages/crud/skipto-content" model="[skipTo = skipTo]"/>

                <hook:renderWithHook hookName="gui.render.crud.edit.navMenu" controllerName="${controllerName}"
                                     actionName="${actionName}"
                                     entityTypeName="${entityTypeName}" domain="${domain}" flash="$flash}">
                    <g:render template="/templates/common/pages/crud/navMenu"
                              model="[menuState: 3, entityName: entityName]"/>
                </hook:renderWithHook>

            </section>

            <section class="row">
                <div id="create-${entityTypeName}" class="col-12 content scaffold-create" role="main">
                    <hook:renderWithHook hookName="gui.render.crud.edit.content" controllerName="${controllerName}"
                                         actionName="${actionName}"
                                         entityTypeName="${entityTypeName}" domain="${domain}" flash="${flash}">

                        <h1><g:message code="default.edit.label" args="[entityName]"/></h1>

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

                        <g:form action="update" method="POST">
                            <g:hiddenField name="id" value="${domain.id}"/>
                            <g:hiddenField name="version" value="${domain?.version}"/>
                            <fieldset class="form">
                                <f:all bean="domain"/>
                            </fieldset>
                            <fieldset class="buttons">
                                <input class="save" type="submit"
                                       value="${message(code: 'default.button.update.label', default: 'Update')}"/>
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

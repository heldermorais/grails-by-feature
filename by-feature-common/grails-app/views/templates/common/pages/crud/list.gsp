<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="common"/>

    <g:set var="entityTypeName" value="${entityTypeName}"/>
    <g:set var="entityName" value="${message(code: entityTypeName + '.label', default: defaultEntityName)}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>

    <g:set var="domainList" value="list"/>

</head>

<body>
<!-- Default CRUD - INDEX.GSP  BEGIN -->
<hook:renderWithHook hookName="gui.render.crud.list" controllerName="${controllerName}" actionName="${actionName}"
                     entityTypeName="${entityTypeName}" domainList="${domainList}" domainCount="${domainCount}" flash="${flash}">

    <div id="content" role="main">
        <div class="container">

            <section class="row">

                <g:set var="skipTo" value="list-${entityTypeName}"/>
                <g:render template="/templates/common/pages/crud/skipto-content" model="[skipTo = skipTo]"/>


                <hook:renderWithHook hookName="gui.render.crud.list.navMenu" controllerName="${controllerName}"
                                     actionName="${actionName}"
                                     entityTypeName="${entityTypeName}"
                                     domainClass="${domainClass}"
                >

                    <g:render template="/templates/common/pages/crud/navMenu"
                              model="[menuState: 1, entityName: entityName]"/>

                </hook:renderWithHook>

            </section>

            <section class="row">
                <div id="list-${entityTypeName}" class="col-12 content scaffold-list" role="main">

                    <hook:renderWithHook hookName="gui.render.crud.list.content" controllerName="${controllerName}"
                                         actionName="${actionName}"
                                         entityTypeName="${entityTypeName}"
                                         domainList="${domainList}"
                                         domainCount="${domainCount}"
                                         flash="${flash}"
                                         domainClass="${domainClass}">

                        <h1><g:message code="default.list.label" args="[entityName]"/></h1>

                        <g:if test="${flash.message}">
                            <div class="message" role="status">${flash.message}</div>
                        </g:if>


                        <hook:renderWithHook hookName="gui.render.crud.list.content.table"
                                             controllerName="${controllerName}"
                                             actionName="${actionName}"
                                             entityTypeName="${entityTypeName}"
                                             domainList="${domainList}"
                                             domainCount="${domainCount}"
                                             flash="${flash}"
                                             domainClass="${domainClass}">

                            <f:table
                                     collection="${domainList}"
                            />

                        </hook:renderWithHook>

                        <g:if test="${domainCount > params.int('max')}">
                            <div class="pagination">
                                <g:paginate total="${domainCount ?: 0}"/>
                            </div>
                        </g:if>

                    </hook:renderWithHook>

                </div>
            </section>

        </div>
    </div>
</hook:renderWithHook>


<!-- Default CRUD - INDEX.GSP  END   -->
</body>
</html>
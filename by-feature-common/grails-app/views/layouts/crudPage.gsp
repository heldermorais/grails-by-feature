<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="common"/>

    <g:set var="entityTypeName" value="${entityTypeName}"/>
    <g:set var="entityName" value="${message(code: entityTypeName + '.label')}"/>
    <title><g:layoutTitle default="Crud Page"/></title>

    <g:set var="domainList" value="list"/>

    <g:layoutHead/>
</head>

<body>
<!-- Layout crudPage - /layouts/crudPage.gsp  BEGIN -->
<div id="content" role="main">
    <div class="container">

        <section class="row">

            <g:set var="skipTo" value="list-${entityTypeName}"/>
            <g:render template="/templates/common/pages/crud/skipto-content" model="[skipTo = skipTo]"/>

            <div class="nav" role="navigation">
                <g:pageProperty name="page.navigationMenu"/>
            </div>

        </section>

        <section class="row">

            <div id="list-${entityTypeName}" class="col-12 content scaffold-list" role="main">

                <h1><g:layoutTitle/></h1>

                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>

                <g:pageProperty name="page.crudPanel"/>

            </div>

        </section>

    </div>
</div>
<!-- Layout crudPage - /layouts/crudPage.gsp  END -->

</body>
</html>

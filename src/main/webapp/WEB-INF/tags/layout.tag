<%@ attribute name="pageTitle" required="true" description="Set dynamic page title" %>

<%@tag description="Include style css and nav-bar" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>${pageTitle}</title>
        <meta charset="UTF-8">
        <jsp:include page="/stylesheetLinks.jsp"/>
    </head>
    <body>
        <header>
            <jsp:include page="/logoutHeader.jsp"/>
        </header>
        <main>
            <div class="container">
                <jsp:doBody/>
            </div>
        </main>
    </body>
</html>

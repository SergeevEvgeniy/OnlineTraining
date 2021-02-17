<!DOCTYPE html>
<html>
    <head>
        <title>Logout page</title>
        <meta charset="UTF-8">
        <jsp:include page="/stylesheetLinks.jsp"/>
    </head>
    <body>
        <div class="container text-center">
            <header>
                <h2> Logout</h2>
            </header>
            <div class="control-group">
                <div class="controls text">
                    You currently logged as '<span>${userName.value}</span>'.
                </div>
                <div class="controls text">
                    Are you sure you want to logout?
                </div>
            </div>

            <form action="${pageContext.request.contextPath}/logout" method="post">
                <button class="btn btn-danger">Logout</button>                        
                <a class="btn btn-default" href="${pageContext.request.contextPath}/courses">Cancel</a>
            </form>
        </div>
    </body>
</html>

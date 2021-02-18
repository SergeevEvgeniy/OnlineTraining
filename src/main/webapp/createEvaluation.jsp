<%@ taglib prefix="tag" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tag:layout pageTitle="Описание задания">
    <form action="create" method="post">
        <p> Choose student:
            <select name = "students">
                <c:forEach var ="student" items="${students}">
                    <option value="${student.id}">${student.nickname}</option>
                </c:forEach>
            </select>
        </p>
        <p> 
            Insert grade : 
            <input name="grade_value" type="text" min="0" max="10" required />
        </p>
        <p> 
            Insert comment : 
            <input name="comment" type="text" required/>
        </p>
        <div>
            <a class="btn btn-danger" href="/OnlineTraining/courses">Back</a>
            <button id="createButton" class="btn btn-success" type="submit">Save</button>
        </div>
    </form>
</tag:layout>
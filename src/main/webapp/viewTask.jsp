<%@ taglib prefix="tag" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tag:layout pageTitle="Описание задания">
    <p> Name : ${task.name} </p>
    <p> Description : ${task.description} </p>
    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th> Id </th>
                <th> Grade </th>
                <th> Comment </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="grade" items="${grades}">
                <tr>
                    <td>${grade.id}</td>
                    <td>${grade.grade}</td>
                    <td>${grade.comment}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table> 
    <div>
        <a class="btn btn-default" href="/OnlineTraining/courses">Back</a>
    </div>
</tag:layout>

<%@ taglib prefix="tag" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tag:layout pageTitle="Описание курса">
    <p> Name : ${course.name} </p>
    <p> Description : ${course.description} </p>
    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th> Id </th>
                <th> Course </th>
                <th> Description </th>
                <th> Action </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="task" items="${course.tasks}">
                <tr>
                    <td>${task.id}</td>
                    <td>
                        <a href="tasks/view?id=${task.id}">${task.name}</a>
                    </td>
                    <td>
                        <div>${task.description}</div>
                    </td>
                    <td>
                        <a class="btn btn-mini" 
                           href="tasks/view?id=${task.id}">View</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table> 
    <div>
        <a class="btn btn-default" href="/OnlineTraining/courses">Back</a>
    </div>
</tag:layout>

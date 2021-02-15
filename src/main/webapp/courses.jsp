<%@ taglib prefix="tag" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tag:layout pageTitle="Cтраница курсов">
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
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.getId()}</td>
                    <td>
                        <a href="courses/view?id=${course.id}">${course.name}</a>
                    </td>
                    <td>
                        <div>${course.description}</div>
                    </td>
                    <td>
                        <a class="btn btn-mini" 
                           href="courses/view?id=${course.id}">View</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table> 
</tag:layout>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tag:layout pageTitle="Описание задания">
    <p> Name : ${task.name} </p>
    <p> Description : ${task.description} </p>
    <c:if test="${user.isLector()}">
        <a class="btn btn-mini btn-success" 
           href="evaluation/create?taskid=${task.id}">Create Evaluation</a>
    </c:if>
    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th> Id </th>
                <th> Student </th>
                <th> Grade </th>
                <th> Comment </th>
                    <c:if test="${user.isLector()}">
                    <th> Action </th>
                    </c:if>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="grade" items="${grades}">
                <tr>
                    <td>${grade.id}</td>
                    <td>${grade.student.nickname}</td>
                    <td>${grade.grade}</td>
                    <td>${grade.comment}</td>
                    <c:if test="${user.isLector()}">
                        <td>        
                            <form action="evaluation/delete?gradeid=${grade.id}&taskid=${task.id}" 
                                  method="post">
                                <button class="btn btn-mini"> Delete </button>
                            </form>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table> 
    <div>
        <a class="btn btn-default" href="/OnlineTraining/courses">Back</a>
    </div>
</tag:layout>

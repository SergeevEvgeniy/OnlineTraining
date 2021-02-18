<%@ taglib prefix="tag" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tag:layout pageTitle="Описание курса">
    <p> Name : ${course.name} </p>
    <p> Description : ${course.description} </p>
    <c:if test="${isEditable}">
        <a class="btn btn-mini btn-success" 
           href="tasks/create?courseid=${course.id}">Create Task</a>
    </c:if>
    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th> Id </th>
                <th> Task </th>
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
                        <form action="tasks/delete?courseid=${course.id}&taskid=${task.id}" 
                              method="post">
                            <a class="btn btn-mini" 
                               href="tasks/view?id=${task.id}">View</a>
                            <c:if test="${isEditable}">
                                <button class="btn btn-mini"> Delete </button>
                            </c:if>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table> 
    <div>
        <a class="btn btn-default" href="/OnlineTraining/courses">Back</a>
    </div>
</tag:layout>

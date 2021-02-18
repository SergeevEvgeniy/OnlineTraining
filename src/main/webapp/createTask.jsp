<%@ taglib prefix="tag" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tag:layout pageTitle="Описание задания">
    <form action="create" method="post">
        <p> 
            Insert task name : 
            <input name="Task_name" type="text" required/>
        </p>
        <p> 
            Insert task description : 
            <input name="Task_description" type="text" required/>
        </p>
        <div>
            <a class="btn btn-danger" href="/OnlineTraining/courses">Back</a>
            <button id="createButton" class="btn btn-success" type="submit">Save</button>
        </div>
    </form>
</tag:layout>
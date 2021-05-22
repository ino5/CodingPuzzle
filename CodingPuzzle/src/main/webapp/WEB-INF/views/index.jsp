<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="Error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
input[readonly="true"] {
	background-color : #F6F6F6;
}

</style>
<script type="text/javascript">
	function functionEdit(classNo){
		/* Convert to false about readOnly */
		var className = "class_"+classNo
		var myList = document.getElementsByClassName(className);
		for(var i =0; i < myList.length; i++){
			var obj = myList.item(i);
			if(obj.name == "no" || obj.name == "date") continue;
			obj.readOnly = false;
		}
		
		/* Convert to the edit button */
		var myButton = document.getElementById("button_"+classNo);
		if (myButton.innerHTML == "Submit"){
			console.log("ok");
			var myForm = document.getElementById("form_"+classNo);
			myForm.action= "/edit";
			myButton.type = "submit";
		} else {
			myButton.innerHTML = "Submit";	
		}
		
		/* Hide the original submit button  */
		var myFinalSubmit = document.getElementById("submit_final");
		myFinalSubmit.style.visibility = "hidden";
		
		/* Convert to true about readOnly */
		var myListForAdd = document.getElementsByClassName("add");
		for(var i =0; i < myListForAdd.length; i++){
			var obj = myListForAdd.item(i);
			obj.readOnly = true;
			obj.style.backgroundColor = "#F6F6F6";
		}

	}

</script>
</head>
<body>
	<h3>In the Database</h3>
	<table border="0">
		<tr>
			<th>NO</th>
			<th>NAME</th>
			<th>CONTENT</th>
			<th>DATE</th>
		</tr>
		<c:set var="max_no" value="${0}" />
		<c:forEach items="${test}" var="test">
			<form action="/delete" method="post" id="form_${test.no }">
				<tr>
					<td><input type="number" class="class_${test.no }" name="no" readOnly="true" value="${test.no }"></td>
					<td><input type="text" class="class_${test.no }" name="name" readOnly="true" value="${test.name }"></td>
					<td><input type="text" class="class_${test.no }" name="content" readOnly="true" value="${test.content }"></td>
					<td><input type="text" class="class_${test.no }" name="date" readOnly="true" value="${test.date }"></td>
					<td><input type="submit" value="Delete"></td>
					<c:set var="max_no" value="${test.no }" />
					<td><button id="button_${test.no }" onclick="functionEdit(${test.no})" type="button">Edit</button></td>
				</tr>
			</form>

		</c:forEach>
		<form action="/add" method="post">
			<tr>
				<td><input type="number" class="add" name="no" readonly="true" value="${max_no+1 }"></td>
				<td><input type="text" class="add" name="name"></td>
				<td><input type="text" class="add" name="content"></td>
			</tr>
	</table>
	<table>
		<tr>
			<td></td>
			<td></td>
			<td><input id="submit_final" type="submit" value="Submit"></td>
		</tr>
		</form>
	</table>
</body>
</html>
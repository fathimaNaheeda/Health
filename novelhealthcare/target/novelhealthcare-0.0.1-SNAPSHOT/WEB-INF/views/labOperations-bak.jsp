<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <form action="${pageContext.request.contextPath}/search/searchpatient?searchValue">
<input type="text" name="searchValue"></input><span id="sid"></span><input type="submit" value="search"/>
</form>
 --%>
 <table border="2">
 <tr>
 <td>
 <jsp:include page="menu.jsp">
<jsp:param value="This page having menu" name="DesCription"/>
</jsp:include>
 
 </td>
<td>
 <table border="2">
<tr>
<th style="color: blue">Lab_Id</th>
<th style="color: blue">Lab_Name</th>
<th style="color: blue">Email</th>
<th style="color: blue">Mobileno</th>
<th style="color: blue">Action</th>
</tr >


<core:choose>
<core:when test="${not empty LabList}">
<core:forEach items="${LabList}" var="labBean">
<tr>
<td>${labBean.getLabId()}</td>
<td>${labBean.getLabName()}</td>
<td>${labBean.getEmail()}</td>
<td>${labBean.getMobileno()}</td>
<td>
<a href="${pageContext.request.contextPath}/getAllLabsById?labId=${labBean.getLabId()}">edit/</a>
<a href="deleteLabById?labId=${labBean.getLabId()}">delete</a>
</td>
</tr>
</core:forEach>
</core:when>
</core:choose> 
<%-- <core:set value="${docBean}" var="docbean">
<tr>
<td>${docbean.getDocId()}</td>
<td>${docbean.getName()}</td>
<td>${docbean.getEmail()}</td>
<td>${docbean.getGender()}</td>
<td>${pbean.docbean.getMobileno()}</td>
<td>
<a href="${pageContext.request.contextPath}/getAllDoctorsById?docId=${docbean.getDocId()}">edit/</a>
<a href="">delete</a>
</td>
</tr>
</core:set>
 --%>
 </table>
<a href="addLab">addLab</a>
<form action="${pageContext.request.contextPath}/searchLab?searchValue">
<input type="text" name="searchValue"></input><span id="sid"></span><input type="submit" value="search"/>
</form>
</td>
</tr>
</table>
</body>
</html>
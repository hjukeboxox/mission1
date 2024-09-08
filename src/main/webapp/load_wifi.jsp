<%@ page import="com.OpenAPI" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%
 
 	OpenAPI api=new OpenAPI();
 	/* 와이파이 정보 구하고 info_count 업데이트해준다.  */
   double info_count = 0;
 	
   info_count=api.getApiResult();
 %>
<html>
<head>
<meta charset="EUC-KR">
<title>와이파이 정보 구하기</title>
</head>
<body>
   <h1 style="text-align: center;"><%= info_count %>개의 WIFI 정보를 정상적으로 저장하였습니다.</h1>
   <div style="text-align: center;"> <a href="index.jsp">홈 으로 가기</a> </span>
</body>
</html>

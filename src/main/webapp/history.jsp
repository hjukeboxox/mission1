<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>와이파이 정보 구하기</title>
<style>


#history_info {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  font-size:10px;
  width: 100%;
}

#history_info td, #history_info th {
  border: 1px solid #ddd;
  padding: 8px;
}

#history_info tr:nth-child(even){background-color: #f2f2f2;}

#history_info tr:hover {background-color: #ddd;}

#history_info th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}

#empty th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}

</style>
<script>
</script>
</head>
<body>
<h1>위치 히스토리 목록</h1>

<!-- 링크 영역 -->
<div>
	<a href="index.jsp">홈</a>| <a href="history.jsp">위치 히스토리 목록</a> | <a href="load_wifi.jsp">Open API 와이파이 정보 가져오기</a>
</div>

</br>


</br>
<table id="history_info">
  <tr>
  	<th>ID</th>
    <th>X좌표</th>
    <th>Y좌표</th>
    <th>조회일자</th>
  </tr>
   	<%
 	 /* 비어있을때 */
      if(true){
	%>
	  <tr>
	  	<td colspan="16" id="empty" style="text-align: center;height:100px;">조회 기록이 없습니다.</td>
	  </tr>
	<% }else{%>	
	 <!-- 검색했을때 -->
	 	 <!-- c태그로 for문예정 -->
	<% }%>
  
  
</table>




</body>
</html>
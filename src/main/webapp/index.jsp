<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
<style>
#location_info {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  font-size:10px;
  width: 100%;
}
#location_info td, #location_info th {
  border: 1px solid #ddd;
  padding: 8px;
}
#location_info tr:nth-child(even){background-color: #f2f2f2;}
#location_info tr:hover {background-color: #ddd;}
#location_info th {
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
</head>
<body>
<h1>와이파이 정보 구하기</h1>

<!-- 링크 영역 -->
<div>
	<a href="index.jsp">홈</a>| <a href="history.jsp">위치 히스토리 목록</a> | <a href="load_wifi.jsp">Open API 와이파이 정보 가져오기</a>
</div>

</br>

<!-- 폼과 버튼 영역 --> 
<form action="processData" method="post" accept-charset="UTF-8">
    LAT: <input name="lat" type="text" value="<%= request.getAttribute("lat") != null ? request.getAttribute("lat") : "" %>"> , 
    LNT: <input name="lnt" type="text" value="<%= request.getAttribute("lnt") != null ? request.getAttribute("lnt") : "" %>"/>  
    <button type="submit" name="action" value="my_location">내 위치 가져오기</button> 
    <button type="submit" name="action" value="near_wipi_info">근처 WIPI 가져오기</button>
</form>

</br>
<table id="location_info">
  <tr>
    <th>거리(km)</th>
    <th>관리번호</th>
    <th>자치구</th>
    <th>와이파이명</th>
    <th>도로명주소</th>
    <th>상세주소</th>
    <th>설치위치(층)</th>
    <th>설치유형</th>
    <th>설치기관</th>
    <th>서비스구분</th>
    <th>설치년도</th>
    <th>실내외구분</th>
    <th>WIFI접속환경</th>
    <th>X좌표</th>
    <th>Y좌표</th>
    <th>작업일자</th>
  </tr>
  <% 
    List<Map<String, Object>> result = (List<Map<String, Object>>) request.getAttribute("result");
    if (result == null || result.isEmpty()) {
  %>
  <tr>
    <td colspan="16" id="empty" style="text-align: center;height:100px;">위치 정보를 입력한 후에 조회해 주세요.</td>
  </tr>
  <% } else { %>
    <% for (Map<String, Object> r : result) { %>
    <tr>
      <% for (Map.Entry<String, Object> entry : r.entrySet()) { %>
        <td><%= entry.getValue() %></td>
      <% } %>
    </tr>
    <% } %>
  <% } %>
</table>
</body>
</html>

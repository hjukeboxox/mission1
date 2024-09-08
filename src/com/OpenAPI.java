package com;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;


public class OpenAPI {

	
	 public double getApiResult() throws IOException {
	      StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088/456b6e426667686439304151505457/json/TbPublicWifiInfo/1/30/"); /*URL*/
	      URL url = new URL(urlBuilder.toString());
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      conn.setRequestProperty("Content-type", "application/json");
	      System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
	      BufferedReader rd;

	      // 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
	      if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            System.out.println("정상호출");
	            
	      } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	            System.out.println("호출제대로안됌");
	      }
	      StringBuilder sb = new StringBuilder();
	      String line;
	      while ((line = rd.readLine()) != null) {
	            sb.append(line);
	      }
	      rd.close();
	      conn.disconnect();
	   //   System.out.println(sb.toString());
	      
	      return resultSaveDb(sb);
	       
	   }
	 


//	public static double resultTotalCount(StringBuilder sb) {
//		
//		//API받아온 전체 조회한 갯수 뱉기.
//		
//		Gson gson= new Gson();		
//		Gson gson2= new GsonBuilder().create();
//		
//		Map<String, Object> map= gson.fromJson(sb.toString(), Map.class);
//		
//		//데이터 구조 
//		//TbPublicWifiInfo(전체카운트정보)>RESULT(요청성공여부)=List<row>(디비연계정보빼와야하는저장)
//		
//		
//		 Map<String,Object> maps = (Map<String, Object>) map.get("TbPublicWifiInfo");
//	
//		 
//		maps.get("list_total_count");
//
//		//Map출력
//	//	Object d=map.get("TbPublicWifiInfo");
//	//	System.out.println("--"+d.toString());
//		
//	
//	//	gson2.toJson(d);
//		
////		for(:gson2.toJson(d)) {
////			
////		}
//		
//		
//		return (double) maps.get("list_total_count");
//	}
	
	
	public static double resultSaveDb(StringBuilder sb) {
		
		//리스트맵으로 결과 뱉도록하기
		//json결과를 데이터를 -> List Map으로 받아라.
		Gson gson= new Gson();
	    Map<String, Object> map= gson.fromJson(sb.toString(), Map.class);
		
		//데이터 구조 
		//TbPublicWifiInfo(전체카운트정보)>RESULT(요청성공여부)=List<row>(디비연계정보빼와야하는저장)

		 Map<String,Object> maps = (Map<String, Object>) map.get("TbPublicWifiInfo");
		
		 
		 //  카운트
//		 Object s = maps.get("list_total_count");
//		 System.out.println("list_total_count"+s);
		 List<Map<String,Object>> resultList = new ArrayList();
		 
		 Object obj = maps.get("row");
		 String objStr = gson.toJson(obj);
		 
		 objStr = objStr.toLowerCase();
        Type LocationType = new TypeToken<List<LocationVo>>() {}.getType();
        List<LocationVo> locations = gson.fromJson(objStr, LocationType);
        
        DBUtils.locationRun("locationInsert", locations);
        
        //데이터갯수 보여주기
        maps.get("list_total_count");
        
        
        return (double) maps.get("list_total_count");
		
	}
	
}

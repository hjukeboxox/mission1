package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/processData")
public class ProcessDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 응답 인코딩 설정
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // 클라이언트로부터 전송된 데이터 받기
        String lat = request.getParameter("lat");
        String lnt = request.getParameter("lnt");
        String action = request.getParameter("action");

        System.out.println("lat"+lat);
        System.out.println("int"+lnt);
        
        
        List<LocationVo> list = new ArrayList<>();
        LocationVo req = new LocationVo();
        req.setLat_str(lat);
        req.setLnt_str(lnt);
        list.add(req);
        List<Map<String, Object>> result = DBUtils.locationRun("locationSelect", list);
        
        
        
        System.out.println("카운트 : " + result.size());
        for (Map<String, Object> r : result) {
            System.out.print(r);
            System.out.println("");
        }
        
        
        // 결과를 request에 저장
        request.setAttribute("lat", lat);
        request.setAttribute("lnt", lnt);
        request.setAttribute("result", result);
        
        
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

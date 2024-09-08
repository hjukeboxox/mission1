package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.var;

public class DBUtils {

    private static String mysql_path = "C:\\dev\\sqlite-tools-win-x64-3460100\\wifinderDB.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<LocationVo> list = new ArrayList<>();
        LocationVo req = new LocationVo();
        req.setLat_str("37.561924");
        req.setLnt_str("126.96675");
        list.add(req);
        List<Map<String, Object>> result = locationRun("locationSelect", list);

        System.out.println("카운트 : " + result.size());
        for (Map<String, Object> r : result) {
            System.out.print(r);
            System.out.println("");
        }
    }

    public static List<Map<String, Object>> locationHistRun(final String flag, final List<LocationVo> voList) {
        List<Map<String, Object>> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s", mysql_path))) {
            if (connection != null) {
                // Implement your SQL query execution here if needed
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public static List<Map<String, Object>> locationRun(final String flag, final List<LocationVo> voList) {
        List<Map<String, Object>> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s", mysql_path))) {
            if (connection != null) {
                if ("locationInsert".equals(flag)) {
                    for (LocationVo list : voList) {
                        makeInsertLocationSqlQuery(connection, list);
                    }
                } else if ("locationSelect".equals(flag)) {
                    try (Statement statement = connection.createStatement()) {
                        String reqLat = String.valueOf(voList.get(0).getLat_str());
                        String reqLnt = String.valueOf(voList.get(0).getLnt_str());
                        String selectQuery = makeSelectLocationSqlQuery(flag, reqLat, reqLnt);
                        try (ResultSet rs = statement.executeQuery(selectQuery)) {
                            ResultSetMetaData metaData = rs.getMetaData();
                            int columnCount = metaData.getColumnCount();
                            while (rs.next()) {
                                Map<String, Object> rowMap = new HashMap<>();
                                for (int i = 1; i <= columnCount; i++) {
                                    String columnName = metaData.getColumnName(i);
                                    Object columnValue = rs.getObject(i);
                                    rowMap.put(columnName, columnValue);
                                }
                                result.add(rowMap);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public static void makeInsertLocationSqlQuery(final Connection connection, LocationVo vo) {
        StringBuilder sringbuilder = new StringBuilder();
        sringbuilder.append("INSERT INTO LOCATION_INFO ");
        sringbuilder.append(" ( ");
        sringbuilder.append("x_swifi_mgr_no,x_swifi_wrdofc,x_swifi_main_nm,x_swifi_adres1,x_swifi_adres2,x_swifi_instl_floor,");
        sringbuilder.append("x_swifi_instl_ty,x_swifi_instl_mby,x_swifi_svc_se,x_swifi_cmcwr,x_swifi_cnstc_year,");
        sringbuilder.append("x_swifi_inout_door,x_swifi_remars3,lat,lnt,work_dttm");
        sringbuilder.append(" ) ");
        sringbuilder.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        try (PreparedStatement pstmt = connection.prepareStatement(sringbuilder.toString())) {
            pstmt.setString(1, vo.getX_swifi_mgr_no());
            pstmt.setString(2, vo.getX_swifi_wrdofc());
            pstmt.setString(3, vo.getX_swifi_main_nm());
            pstmt.setString(4, vo.getX_swifi_adres1());
            pstmt.setString(5, vo.getX_swifi_adres2());
            pstmt.setString(6, vo.getX_swifi_instl_floor());
            pstmt.setString(7, vo.getX_swifi_instl_ty());
            pstmt.setString(8, vo.getX_swifi_instl_mby());
            pstmt.setString(9, vo.getX_swifi_svc_se());
            pstmt.setString(10, vo.getX_swifi_cmcwr());
            pstmt.setInt(11, vo.getX_swifi_cnstc_year());
            pstmt.setString(12, vo.getX_swifi_inout_door());
            pstmt.setString(13, vo.getX_swifi_remars3());
            pstmt.setDouble(14, vo.getLat());
            pstmt.setDouble(15, vo.getLnt());
            pstmt.setString(16, vo.getWork_dttm());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String makeSelectLocationSqlQuery(final String flag, final String reqLat, final String reqLnt) {
        String sqlQuery = "SELECT * FROM LOCATION_INFO ";
        sqlQuery += " where lat = " + reqLat;
        sqlQuery += " and lnt = " + reqLnt;
        sqlQuery += " LIMIT 20 ";
        return sqlQuery;
    }

    public static String makeSelectLocationHistSqlQuery(final String flag, final String reqLat, final String reqLnt) {
        String sqlQuery = "SELECT * FROM LOCATION_HIST ";
        sqlQuery += " LIMIT 20 ";
        return sqlQuery;
    }
}

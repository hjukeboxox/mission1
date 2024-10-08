package com;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class LocationVo {
	private String x_swifi_mgr_no;
	private String x_swifi_wrdofc;
	private String x_swifi_main_nm;
	private String x_swifi_adres1;
	private String x_swifi_adres2;
	private String x_swifi_instl_floor;
	private String x_swifi_instl_ty;
	private String x_swifi_instl_mby;
	private String x_swifi_svc_se;
	private String x_swifi_cmcwr;
	private int x_swifi_cnstc_year;
	private String x_swifi_inout_door;
	private String x_swifi_remars3;
	private double lat;
	private double lnt;
	private String work_dttm;
	
	

	
	
	/***
	 *  셀렉트 쿼리용
	 * @return
	 */
	
	private String lat_str;
	private String lnt_str;
	
	public String getLat_str() {
		return lat_str;
	}
	public void setLat_str(String lat_str) {
		this.lat_str = lat_str;
	}
	public String getLnt_str() {
		return lnt_str;
	}
	public void setLnt_str(String lnt_str) {
		this.lnt_str = lnt_str;
	}
	
	
	
	public String getX_swifi_remars3() {
		return x_swifi_remars3;
	}
	public void setX_swifi_remars3(String x_swifi_remars3) {
		this.x_swifi_remars3 = x_swifi_remars3;
	}
	public String getX_swifi_mgr_no() {
		return x_swifi_mgr_no;
	}
	public void setX_swifi_mgr_no(String x_swifi_mgr_no) {
		this.x_swifi_mgr_no = x_swifi_mgr_no;
	}
	public String getX_swifi_wrdofc() {
		return x_swifi_wrdofc;
	}
	public void setX_swifi_wrdofc(String x_swifi_wrdofc) {
		this.x_swifi_wrdofc = x_swifi_wrdofc;
	}
	public String getX_swifi_main_nm() {
		return x_swifi_main_nm;
	}
	public void setX_swifi_main_nm(String x_swifi_main_nm) {
		this.x_swifi_main_nm = x_swifi_main_nm;
	}
	public String getX_swifi_adres1() {
		return x_swifi_adres1;
	}
	public void setX_swifi_adres1(String x_swifi_adres1) {
		this.x_swifi_adres1 = x_swifi_adres1;
	}
	public String getX_swifi_adres2() {
		return x_swifi_adres2;
	}
	public void setX_swifi_adres2(String x_swifi_adres2) {
		this.x_swifi_adres2 = x_swifi_adres2;
	}
	public String getX_swifi_instl_floor() {
		return x_swifi_instl_floor;
	}
	public void setX_swifi_instl_floor(String x_swifi_instl_floor) {
		this.x_swifi_instl_floor = x_swifi_instl_floor;
	}
	public String getX_swifi_instl_ty() {
		return x_swifi_instl_ty;
	}
	public void setX_swifi_instl_ty(String x_swifi_instl_ty) {
		this.x_swifi_instl_ty = x_swifi_instl_ty;
	}
	public String getX_swifi_instl_mby() {
		return x_swifi_instl_mby;
	}
	public void setX_swifi_instl_mby(String x_swifi_instl_mby) {
		this.x_swifi_instl_mby = x_swifi_instl_mby;
	}
	public String getX_swifi_svc_se() {
		return x_swifi_svc_se;
	}
	public void setX_swifi_svc_se(String x_swifi_svc_se) {
		this.x_swifi_svc_se = x_swifi_svc_se;
	}
	public String getX_swifi_cmcwr() {
		return x_swifi_cmcwr;
	}
	public void setX_swifi_cmcwr(String x_swifi_cmcwr) {
		this.x_swifi_cmcwr = x_swifi_cmcwr;
	}
	public int getX_swifi_cnstc_year() {
		return x_swifi_cnstc_year;
	}
	public void setX_swifi_cnstc_year(int x_swifi_cnstc_year) {
		this.x_swifi_cnstc_year = x_swifi_cnstc_year;
	}
	public String getX_swifi_inout_door() {
		return x_swifi_inout_door;
	}
	public void setX_swifi_inout_door(String x_swifi_inout_door) {
		this.x_swifi_inout_door = x_swifi_inout_door;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLnt() {
		return lnt;
	}
	public void setLnt(double lnt) {
		this.lnt = lnt;
	}
	public String getWork_dttm() {
		return work_dttm;
	}
	public void setWork_dttm(String work_dttm) {
		this.work_dttm = work_dttm;
	}

}

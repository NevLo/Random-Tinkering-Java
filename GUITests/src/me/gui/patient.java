package me.gui;

public class patient {
	private int roomNum;
	private int bedNum;
	private boolean iso;
	private boolean tele;
	private String nurse;
	private String CNA;
	
	public patient(int roomNum, int bedNum, boolean iso, boolean tele, String nurse, String CNA){
		this.roomNum = roomNum;
		this.bedNum = bedNum;
		this.iso = iso;
		this.tele = tele;
		this.nurse = nurse;
		this.CNA = CNA;
	}
	

	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public int getBedNum() {
		return bedNum;
	}
	public void setBedNum(int bedNum) {
		this.bedNum = bedNum;
	}
	public boolean isIso() {
		return iso;
	}
	public void setIso(boolean iso) {
		this.iso = iso;
	}
	public boolean isTele() {
		return tele;
	}
	public void setTele(boolean tele) {
		this.tele = tele;
	}
	public String getNurse() {
		return nurse;
	}
	public void setNurse(String nurse) {
		this.nurse = nurse;
	}
	public String getCNA() {
		return CNA;
	}
	public void setCNA(String cNA) {
		CNA = cNA;
	}
}

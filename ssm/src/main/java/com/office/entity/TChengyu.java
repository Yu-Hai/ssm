package com.office.entity;

public class TChengyu {
	private String idChengyu;

	private String chengyu;

	private String pinyin;

	private String diangu;

	private String chuchu;

	private String lizi;

	private String spinyin;

	public String getIdChengyu() {
		return idChengyu;
	}

	public void setIdChengyu(String idChengyu) {
		this.idChengyu = idChengyu;
	}

	public String getChengyu() {
		return chengyu;
	}

	public void setChengyu(String chengyu) {
		this.chengyu = chengyu;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getDiangu() {
		return diangu;
	}

	public void setDiangu(String diangu) {
		this.diangu = diangu;
	}

	public String getChuchu() {
		return chuchu;
	}

	public void setChuchu(String chuchu) {
		this.chuchu = chuchu;
	}

	public String getLizi() {
		return lizi;
	}

	public void setLizi(String lizi) {
		this.lizi = lizi;
	}

	public String getSpinyin() {
		return spinyin;
	}

	public void setSpinyin(String spinyin) {
		this.spinyin = spinyin;
	}

	@Override
	public String toString() {
		return "TChengyu [idChengyu=" + idChengyu + ", chengyu=" + chengyu
				+ ", pinyin=" + pinyin + ", diangu=" + diangu + ", chuchu="
				+ chuchu + ", lizi=" + lizi + ", spinyin=" + spinyin + "]";
	}

}

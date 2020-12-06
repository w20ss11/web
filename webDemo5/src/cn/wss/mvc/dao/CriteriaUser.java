package cn.wss.mvc.dao;

public class CriteriaUser {
	private String name;
	private String psd;
	private Integer balance;
	public String getName() {
		if(name == null)
			return name = "%%";
		else
			name = "%"+name+"%";
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsd() {
		if(psd == null)
			return psd = "%%";
		else
			psd = "%"+psd+"%";
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public CriteriaUser(String name, String psd, Integer balance) {
		super();
		this.name = name;
		this.psd = psd;
		this.balance = balance;
	}
	public CriteriaUser() {
		super();
	}
	
	
}

package kss_mvc_rental.model.user;

public class UserDTO {
	
	private int u_num;
	private String u_name;
	private String u_id;
	private String u_pw;
	private String u_mail;
	private String u_phone;
	private String u_rrn;
	private String u_class;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(int u_num, String u_name, String u_id, String u_pw, String u_mail, String u_phone, String u_rrn,
			String u_class) {
		super();
		this.u_num = u_num;
		this.u_name = u_name;
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_mail = u_mail;
		this.u_phone = u_phone;
		this.u_rrn = u_rrn;
		this.u_class = u_class;
	}

	public int getU_num() {
		return u_num;
	}

	public void setU_num(int u_num) {
		this.u_num = u_num;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_mail() {
		return u_mail;
	}

	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_rrn() {
		return u_rrn;
	}

	public void setU_rrn(String u_rrn) {
		this.u_rrn = u_rrn;
	}

	public String getU_class() {
		return u_class;
	}

	public void setU_class(String u_class) {
		this.u_class = u_class;
	}


}

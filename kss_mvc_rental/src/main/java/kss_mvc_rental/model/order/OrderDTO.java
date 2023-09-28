package kss_mvc_rental.model.order;

public class OrderDTO {
	
	private int o_id;
	private String o_name;
	private String o_phone;
	private String o_address;
	private String o_memo;
	private String o_payment;
	
	
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderDTO(int o_id, String o_name, String o_phone, String o_address, String o_memo, String o_payment) {
		super();
		this.o_id = o_id;
		this.o_name = o_name;
		this.o_phone = o_phone;
		this.o_address = o_address;
		this.o_memo = o_memo;
		this.o_payment = o_payment;
	}


	public int getO_id() {
		return o_id;
	}


	public void setO_id(int o_id) {
		this.o_id = o_id;
	}


	public String getO_name() {
		return o_name;
	}


	public void setO_name(String o_name) {
		this.o_name = o_name;
	}


	public String getO_phone() {
		return o_phone;
	}


	public void setO_phone(String o_phone) {
		this.o_phone = o_phone;
	}


	public String getO_address() {
		return o_address;
	}


	public void setO_address(String o_address) {
		this.o_address = o_address;
	}


	public String getO_memo() {
		return o_memo;
	}


	public void setO_memo(String o_memo) {
		this.o_memo = o_memo;
	}


	public String getO_payment() {
		return o_payment;
	}


	public void setO_payment(String o_payment) {
		this.o_payment = o_payment;
	}
	
	

}

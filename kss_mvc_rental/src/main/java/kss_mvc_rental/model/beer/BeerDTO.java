package kss_mvc_rental.model.beer;

public class BeerDTO {

	private int p_id;
	private String p_category;
	private String p_store;
	private String p_name;
	private int p_price;
	private String p_state;
	private int p_like;
	private String p_image;
	private String p_time;
	private String p_endtime;
	
	public BeerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BeerDTO(int p_id, String p_category, String p_store, String p_name,
			int p_price, String p_state, int p_like, String p_image, String p_time, String p_endtime) {
		super();
		this.p_id = p_id;
		this.p_category = p_category;
		this.p_store = p_store;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_state = p_state;
		this.p_like = p_like;
		this.p_image = p_image;
		this.p_time = p_time;
		this.p_endtime = p_endtime;
		
		
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_category() {
		return p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
	}

	public String getP_store() {
		return p_store;
	}

	public void setP_store(String p_store) {
		this.p_store = p_store;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_state() {
		return p_state;
	}

	public void setP_state(String p_state) {
		this.p_state = p_state;
	}

	public int getP_like() {
		return p_like;
	}

	public void setP_like(int p_like) {
		this.p_like = p_like;
	}

	public String getP_image() {
		return p_image;
	}

	public void setP_image(String p_image) {
		this.p_image = p_image;
	}
	
	public String getP_time() {
		return p_time;
	}

	public void setP_time(String p_time) {
		this.p_time = p_time;
	}
	
	public String getP_endtime() {
		return p_endtime;
	}

	public void setP_endtime(String p_endtime) {
		this.p_endtime = p_endtime;
	}
	
}

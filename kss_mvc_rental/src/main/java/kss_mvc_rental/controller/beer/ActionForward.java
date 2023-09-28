package kss_mvc_rental.controller.beer;

public class ActionForward {
	
	private boolean isRedirect = false;
	private String path = null;
	
	public boolean isRedirect() {
		return this.isRedirect;
	}
	
	public String getPath() {
		return this.path;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
}

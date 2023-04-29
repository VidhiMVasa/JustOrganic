package in.jo.pojo;

public class Cart {
	private int cartid;
	private String custemail;
	private int quantity;
	private Product product;	//has a relationship
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(String custemail, Product product) {
		super();
		this.custemail = custemail;
		this.product = product;
	}
	public Cart(int cartid, String custemail, int quantity, Product product) {
		super();
		this.cartid = cartid;
		this.custemail = custemail;
		this.quantity = quantity;
		this.product = product;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public String getCustemail() {
		return custemail;
	}
	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", custemail=" + custemail + ", quantity=" + quantity + ", product=" + product
				+ "]";
	}
	
	
}

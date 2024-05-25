package in.co.rays.project_3.dto;

public class PaymentDTO  extends BaseDTO{
	private String name;
	private String type;
	private int amount;
	private  String address;
	private  String mob;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id +"";
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return  name +"";
	}
	
	
	
}

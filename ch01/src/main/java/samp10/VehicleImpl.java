package samp10;

public class VehicleImpl implements Vehicle {
	private String name;
	private String rider;
	private Output out;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setRider(String rider) {
		this.rider = rider;
	}

	public void setOut1(Output out) {
		this.out = out;
	}

	public void ride() {
		String msg = name + "��(��) " + rider + "��(��) ź��.";
		System.out.println(msg);
		out.output(msg);
	}
}

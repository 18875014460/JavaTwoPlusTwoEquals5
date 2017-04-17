package proxy;

public class Developer implements IDeveloper{
	private String name;
	public Developer(String name){
		this.name = name;
	}
	@Override
	public void writeCode() {
		System.out.println("Developer " + name + " writes code");
	}
}

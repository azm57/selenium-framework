package programs;

public class AccessModifiers {

	public static void main(String[] args) {		
		ChildClass cc = new ChildClass();
		cc.print();
	}
	protected void print() {
		System.out.println("Hello");
	}
}

class ChildClass extends AccessModifiers{
	
}

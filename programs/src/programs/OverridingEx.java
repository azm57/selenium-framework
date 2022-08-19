package programs;

class Parent{
	void print()
	{
		System.out.println("from parent");
	}
}

class Child extends Parent{
	void print()
	{
		System.out.println("from child");
	}
}


public class OverridingEx extends Parent{

	public static void main(String[] args) {
		Parent p = new Child();
		p.print();

	}
}

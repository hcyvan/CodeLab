public class Dog{
	String name;
	int age;
	Dog(String name, int age){
		super();
		this.name=name;
		this.age=age;
		System.out.println("Hi master, I'm "+this.name);
	}
	void bark(){
		System.out.println("wang, wang");
	}
	void hungry(){
		System.out.println("I'm hungry");
	}
	public void eat(Food f){
		System.out.println("I'm a Dog and I'm eating "+f.getFood());
	}
}

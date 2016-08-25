class Animal{
	public void eat(Food f){
		System.out.println("I'm animal and I'm eating "+f.getFood());
	}
}
class Cat extends Animal{
	public void eat(Food f){
		System.out.println("I'm a Cat and I'm eating "+f.getFood());
	}
}
public class Dog extends Animal{
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


class Food{
	public String getFood(){
		return "something";
	}
}
class Fish extends Food{
	public String getFood(){
		return "fish";
	}
}
class Bone extends Food{
	public String getFood(){
		return "bone";
	}
}

class Master{
	public void feed(Animal an, Food f){
		an.eat(f);
	}
}	

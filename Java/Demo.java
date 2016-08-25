import java.util.*;
public class Demo{
	public static void main(String[] args){
		char name1='c';
		char name2='y';
		char name3='h';
		System.out.println("You name: "+name1+name2+name3);
	
		int x=022;
		System.out.println("x="+x);
		
		float m=22.45f;
		System.out.println("m="+m);
		
		boolean a=true;
		System.out.println("a="+a);
		
		String name="cheng yi hang";
		System.out.println("You name: "+name);
		
		int intArray[]={5,4,3,2,1};
		System.out.print("The Array: ");
		for(int i=0,len=intArray.length;i<len;i++){
			System.out.print(intArray[i]+" ");
		}
		System.out.println("");	
		
		String str="wei_xue_yuan";
		String strArr[]=str.split("_");
		System.out.println(Arrays.toString(strArr));
		
		Dog dudu=new Dog("dudu", 1);
		dudu.bark();
		System.out.println("Dog.name="+dudu.name);

		Teacher t=new Teacher();
		t.name="sun yong";
		t.age=65;
		t.subject="java";
		t.say();
		t.lecturing();
	}
}		
class People{
	String name;
	int age;
	int height;
	void say(){
		System.out.println("My name is "+this.name);
	}
}
class Teacher extends People{
	String school;
	String subject;
	int seniority;
	// override
	void say(){
		System.out.println("I'M Teacher "+this.name);
	}
	void lecturing(){
		System.out.println("I'm "+this.age+" and I'm still work");
	} 
}

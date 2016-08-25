public class Feed2{
	public static void main(String[] args){
		Master ma= new Master();
		//ma.feed(new Animal(), new Food());
		ma.feed(new Cat(), new Fish());
		ma.feed(new Dog("dudu",1), new Bone());
	}
}

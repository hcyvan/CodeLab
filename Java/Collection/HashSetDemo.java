import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class HashSetDemo{
	public static void main(String[] args){
		Set<String> set =new HashSet<String>();
		
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("c");
		set.add("d");
		
		Iterator<String> iter=set.iterator();
		while(iter.hasNext())
			System.out.print(iter.next()+" ");
		System.out.println();
		
		for(String e:set)
			System.out.print(e+" ");
		System.out.println();	
		
		System.out.println(set);
	}
}

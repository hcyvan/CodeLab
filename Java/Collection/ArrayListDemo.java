import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
public class ArrayListDemo{
	public static void main(String[] args){
		List<String> list =new ArrayList<String>();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("d");
		
		Iterator<String> iter=list.iterator();
		while(iter.hasNext())
			System.out.print(iter.next()+" ");
		System.out.println();
		
		for(String e:list)
			System.out.print(e+" ");
		System.out.println();	
		
		System.out.println(list);
		System.out.println("---------------------------");
		List<String> a =new ArrayList<String>();
		a.add("a");
		a.add("b");
		a.add("c");
		System.out.println(a);

		List<String> b =new ArrayList<String>();
		b.add("d");
		b.add("e");
		b.add("f");
		b.add("g");
		System.out.println(b);

		ListIterator<String> ai=a.listIterator();
		Iterator<String> bi=b.iterator();
		while(bi.hasNext()){
			if(ai.hasNext())
				ai.next();
			ai.add(bi.next());
		}
		System.out.println(a);
		
		bi=b.iterator();
		while(bi.hasNext()){
			bi.next();
			if(bi.hasNext()){
				bi.next();
				bi.remove();
			}
		}
		System.out.println(b);
		
		a.removeAll(b);
		System.out.println(a);
	}
}

class ListIteratorTest{
	
}

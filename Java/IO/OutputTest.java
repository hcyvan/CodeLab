import java.io.*;     
  
public class OutputTest {     
	public static void main(String[] args) {
		int count=10000000;        // Line number u want to write
		long begin, end;

		FileOutputStream out = null;     
		BufferedOutputStream Buff=null;     
		FileWriter fw = null;     

		try {
			//-----------------
			out = new FileOutputStream(new File("./add0.txt"));     
			begin = System.currentTimeMillis();     
			for (int i = 0; i < count; i++)  
				out.write("Test Java Output\n".getBytes());     
			out.close();     
			end = System.currentTimeMillis();     
			System.out.println("FileOutputStream Time: " + (end - begin) + " ms");     

			//----------------- BufferedOutputStream
			Buff=new BufferedOutputStream(new FileOutputStream(new File("./add1.txt")));     
			begin = System.currentTimeMillis();     
			for (int i = 0; i < count; i++) 
				Buff.write("Test Java Output\n".getBytes());     
			Buff.flush();     
			Buff.close();     
			end = System.currentTimeMillis();     
			System.out.println("BufferedOutputStream Time: " + (end - begin) + " ms");     

			//----------------- 
			fw = new FileWriter("./add2.txt");     
			begin = System.currentTimeMillis();     
			for (int i = 0; i < count; i++)
				fw.write("Test Java Output\n");     
			fw.close();     
			end=System.currentTimeMillis();     
			System.out.println("FileWriter Time: " + (end - begin) + " ms");     
		} catch (Exception e){
			e.printStackTrace();     
		}finally{     
			try{     
				fw.close();     
				Buff.close();     
				out.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}     
	}     
} 

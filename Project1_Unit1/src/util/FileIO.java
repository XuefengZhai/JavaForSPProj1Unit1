/*
 * Xuefeng Zhai
 * xzhai@cmu.edu
 */
package util;
import model.Automobile;
import java.io.*;

/*
 * Class for File IO
 */
public class FileIO {

	/*
	 * Read in a file and build object of automobile
	 */
	public Automobile buildAutoObject(String filename){
		
		/*
		 * Create new auto object for building
		 */
		Automobile model = new Automobile();
		
		/*
		 * Variables for save data
		 */
		String autoName = null;
		float autoPrice = 0;
		int optSetSize = 0;
		String optSetName = null;
		int optSize = 0;
		String optName = null;
		float optPrice= 0;
		
		System.out.println("Readin data from a file...");
		
		/*
		 * Read and parse the data in the file
		 */
		try{
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);

			buff.readLine();
			autoName = buff.readLine();
			buff.readLine();	
			autoPrice = Float.parseFloat(buff.readLine());
			buff.readLine();
			optSetSize = Integer.parseInt(buff.readLine());
			model = new Automobile(autoName,autoPrice,optSetSize);
			
			/*
			 * Read in option sets in the loop
			 */
			for(int i=0;i<optSetSize;i++){
				buff.readLine();
				buff.readLine();
				optSetName = buff.readLine();
				buff.readLine();
				optSize = Integer.parseInt(buff.readLine());
				model.setOptset(optSetName,i,optSize);
				buff.readLine();
				/*
				 * Read in options in the loop
				 */
				for(int j=0;j<optSize;j++)
				{
					buff.readLine();
					optName = buff.readLine();
					buff.readLine();
					optPrice = Float.parseFloat(buff.readLine());
					model.setOpt(optName, optPrice, i, j);
				}	
			}
					
			buff.close();
			
		}catch (IOException e) {
			System.out.println("Error " + e.toString()); }
		
		return model;
	}
	
	/*
	 * Serialize
	 */
	public void serializeAuto(Automobile model){
		try
		{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/serializeAuto.dat")); 
		out.writeObject(model);
		out.close();
		}
		catch(Exception e)
		{ 
			System.out.print("Error:"+e);
			System.exit(1); 
		}
	}
	
	/*
	 * Deserialize
	 */
	public Automobile deserializeAuto(String filename){
		Automobile model = new Automobile();
		try{
			ObjectInputStream in= new ObjectInputStream(new FileInputStream(filename));
			model = (Automobile) in.readObject();
			in.close();
		}
		catch(Exception e)
		{ 
			System.out.print("Error:"+e);
			System.exit(1); 
		}

		return model;
	}

	
	
}

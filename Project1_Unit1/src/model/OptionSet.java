/*
 * Xuefeng Zhai
 * xzhai@cmu.edu
 */
package model;

/*
 * OptionSet serializable class
 */
public class OptionSet implements
java.io.Serializable
 {
	
	private static final long serialVersionUID = 3024128351917169821L;
	private String name;
	private Option opt[];
	
	/*
	 * Constructors
	 */
	protected OptionSet(){
		
	}

	protected OptionSet(String name, int size) {
		
		this.name = name;
		opt = new Option[size];
		
		for(int i=0;i<opt.length;i++){
			opt[i] = new Option();
		}

	}
	/*
	 * Getters
	 */
	protected String getName() {
		return name;
	}

	protected Option getOpt(int index) {
		return opt[index];
	}
	
	protected Option[] getOpt(){
		return opt;
	}
	
	/*
	 * Setters
	 */
	protected void setName(String name) {
		this.name = name;
	}

	protected void setOpt(String name, float price, int index) {
		
		this.opt[index] = new Option(name, price);
	}
	
	/*
	 * Inner Class Option
	 */
	public class Option implements
	java.io.Serializable
{
		private static final long serialVersionUID = -3149609984354841462L;
		private String name;
		private float price;
		
		/*
		 * Constructors
		 */
		protected Option(){
			
		}
		
		protected Option(String name, float price){
			this.name = name;
			this.price = price; 
		}
		
		/*
		 * Getters
		 */
		protected String getName() {
			return name;
		}

		protected float getPrice() {
			return price;
		}
		/*
		 * Setters
		 */
		protected void setName(String name) {
			this.name = name;
		}

		protected void setPrice(float price) {
			this.price = price;
		}
	}


	
	
}

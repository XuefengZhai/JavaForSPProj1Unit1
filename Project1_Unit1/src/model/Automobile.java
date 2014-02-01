/*
 * Xuefeng Zhai
 * xzhai@cmu.edu
 */
package model;

public class Automobile implements
java.io.Serializable
{

	private static final long serialVersionUID = 6867974146880162446L;
	private String name;
	private float baseprice;
	private OptionSet optset[];
	
	public Automobile(){
	
	}

	public Automobile(String name, float baseprice, int size) {
		this.name = name;
		this.baseprice = baseprice;
		optset = new OptionSet[size];
		for(int i=0;i<optset.length;i++){
			optset[i] = new OptionSet();
		}
	}


	public String getName() {
		return name;
	}

	public float getBaseprice() {
		return baseprice;
	}

	public OptionSet getOpset(int index) {
		return optset[index];
	}
	
	public OptionSet[] getOpset(){
		return optset;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBaseprice(float baseprice) {
		this.baseprice = baseprice;
	}


	public void setOptset(String name, int optIndex, int size) {
		
		optset[optIndex] = new OptionSet(name, size);		
	}
	
	public void setOpt(String name, float price, int setIndex, int optIndex) {
		
		this.optset[setIndex].setOpt(name, price, optIndex);
	}

	public OptionSet findOptSet(String optionSetName){
	
		int i;
		for(i=0;i<optset.length;i++){
			if(optionSetName.equals(optset[i].getName())){
				break;
			}
		}
		return optset[i];	
	}
	
	public OptionSet.Option findOpt(String optionSetName,String optionName){
		
		int i,j;
		for(i=0;i<optset.length;i++){
			
			if(optionSetName.equals(optset[i].getName())){
				break;
			}
		}

		for(j=0;j<optset[i].getOpt().length;j++){
				if(optionName.equals(optset[i].getOpt(j).getName())){
					break;
			}
			
		}
		return optset[i].getOpt(j);
		
	}
	
	public void deleteOption(String optionSetName, String optionName){
		findOpt(optionSetName, optionName).setPrice(0);
		findOpt(optionSetName, optionName).setName(null);
	}
	
	public void deleteOptionSet(String name){
		
		findOptSet(name).setName(null);
		
	}
		
	public void updateOptionSet (String oldName, String newName){
		findOptSet(oldName).setName(newName);
	}
	
	
	public void updateOption (String optionSetName, String oldOptionName, String newName, float newPrice){
		findOpt(optionSetName, oldOptionName).setPrice(newPrice);
		findOpt(optionSetName, oldOptionName).setName(newName);

		
		
	}
	
	public void print(){
		System.out.println("Name of the automobile: " + this.name);
		System.out.println("Base price of the automobile: "+ this.baseprice);
		System.out.println("-----------------------------------------------");
		for(int i=0;i<optset.length;i++){
			
			if(optset[i].getName() == null){
				continue;
			}
			else{
				System.out.println("  Option Set Name: "+optset[i].getName());
				System.out.println("  Options:");
				for(int j=0;j<optset[i].getOpt().length;j++){
					if(optset[i].getOpt(j).getName() == null){
						continue;
					}
					else{
						System.out.println();
						System.out.println("    Name: "+optset[i].getOpt(j).getName());
						System.out.println("    Price: "+optset[i].getOpt(j).getPrice());
					}
				}
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			}
		}
	}

}


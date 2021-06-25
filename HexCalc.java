
public class HexCalc extends CalcEngine {

	protected String hexString;
	
	public HexCalc()
	    {
	        super();
	        hexString = "";
	    }
	 
	public void hexNumberPressed(String hexNumber) {
		if(!buildingDisplayValue) {
			hexString = "";
		}
		hexString = hexString + hexNumber;
		hexToDec(hexString);
		buildingDisplayValue = true;
	}
	
	public void hexToDec(String hexNumber) {
		displayValue = Integer.parseInt(hexNumber, 16);
	}
	
	public void setDisplayValue(int newValue) {
		displayValue = newValue;
	}
	
	public void clear() {
		hexString = "";
		super.clear();
	}
}

/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Calculator
{
    //private CalcEngine engine;
    //private UserInterface gui;
	private HexCalc hexCalc;
    private HexUserInterface gui2;

    /**
     * Create a new calculator and show it.
     */
    public Calculator()
    {
    	hexCalc = new HexCalc();
        //engine = new CalcEngine();
        //gui = new UserInterface(engine);
        gui2 = new HexUserInterface(hexCalc, hexCalc);
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show()
    {
        //gui.setVisible(true);
        //gui2.setVisible(true);
    }
    
    public static void main(String[] args) {
    	Calculator c = new Calculator();
    }
}

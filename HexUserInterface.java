import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class HexUserInterface extends UserInterface{
	
	//protected JFrame frame2;
	protected JPanel hexButtons;
	protected Checkbox dec;
	protected Checkbox hex;
	protected HexCalc converter;
	
	public HexUserInterface(CalcEngine engine, HexCalc converter)
    {
        super(engine);
        makeFrame();
        frame.setSize(400, 300);
        this.converter = converter;
        //frame2.setVisible(true);
    }
	
    /**
    * Set the visibility of the Hex interface.
    * @param visible true if the Hex interface is to be made visible, false otherwise.
    */
   public void setVisible(boolean visible)
   {
       //frame2.setVisible(visible);
   }
	
    /**
     * Make the frame for the Hex user interface.
     */
    private void makeFrame()
    {
    	/*
        frame2 = new JFrame(calc.getTitle());
        
        JPanel contentPane = (JPanel)frame2.getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

        //display = new JTextField();
        //contentPane.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 2));
            addButton(buttonPanel, "A");
            addButton(buttonPanel, "B");
            addButton(buttonPanel, "C");
            
            addButton(buttonPanel, "D");
            addButton(buttonPanel, "E");
            addButton(buttonPanel, "F");
            
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        status = new JLabel(calc.getAuthor());
        contentPane.add(status, BorderLayout.SOUTH);

        frame2.pack();*/
        
        
    	JPanel contentPane = (JPanel)frame.getContentPane();
    	//contentPane.setPreferredSize(new Dimension(1000, 1000));
    	//contentPane.setSize(1000, 2000);
    	hexButtons = new JPanel(new GridLayout(4, 2));
    	
    	addButton(hexButtons, "a");
        addButton(hexButtons, "b");
        
        addButton(hexButtons, "c");
        addButton(hexButtons, "d");
        
        addButton(hexButtons, "e");
        addButton(hexButtons, "f");
        
        hexButtons.add(new JLabel(" "));
        hexButtons.add(new JLabel(" "));
        
        contentPane.add(hexButtons, BorderLayout.EAST);
        hexButtons.setVisible(false);
        
        JPanel hexOnOff = new JPanel(new GridLayout(4, 1));
        /*
        addButton(hexOnOff, "hex");
        addButton(hexOnOff, "dec");
        hexOnOff.add(new JLabel(" "));
        hexOnOff.add(new JLabel(" "));

        
        contentPane.add(hexOnOff, BorderLayout.WEST);
        */
        
        CheckboxGroup cbg = new CheckboxGroup();
        dec = new Checkbox("dec", cbg, true);
        hex = new Checkbox("hex", cbg, false);
        
        dec.addItemListener(new ItemListener() {        	 
			@Override
			public void itemStateChanged(ItemEvent e) {
				hexButtons.setVisible(!dec.getState());
				frame.setSize(400, 300);				
				redisplay();
			}        	 
        });
        hex.addItemListener(new ItemListener() {        	 
			@Override
			public void itemStateChanged(ItemEvent e) {
				hexButtons.setVisible(hex.getState());
				frame.setSize(490, 300);
				redisplay();
			}        	 
        });
        
        hexOnOff.add(dec);
        hexOnOff.add(hex);
        contentPane.add(hexOnOff, BorderLayout.WEST);
        
    }

    public void actionPerformed(ActionEvent event)
    {
    	String command = event.getActionCommand();
    	
    	if(dec.getState()) {
    		if(command.equals("C")) {
    			converter.clear();
    		} else {
    	        super.actionPerformed(event);
    		}
    	} else {
    		
        if(command.equals("+")) {
            converter.plus();
        }
        else if(command.equals("-")) {
        	converter.minus();
        }
        else if(command.equals("=")) {
        	converter.equals();
        }
        else if(command.equals("C")) {
        	converter.clear();
        }
        else if(command.equals("*")) {
        	converter.multiply();
        }    
        else if(command.equals("?")) {
            super.showInfo();
        } else {
        	converter.hexNumberPressed(command);
        }
        /*
        switch(command) {
        case "a": calc.numberPressed(10); break;
        case "b": calc.numberPressed(11); break;
        case "c": calc.numberPressed(12); break;
        case "d": calc.numberPressed(13); break;
        case "e": calc.numberPressed(14); break;
        case "f": calc.numberPressed(15); break;
         }
         */
    	}
        /*
        if(dec.getState()) {
        	hexButtons.setVisible(false);
        } else {
        	hexButtons.setVisible(true);
        }
        */
        redisplay();
    }

    protected void redisplay()
    {
    	if(dec.getState()) {
    		super.redisplay();
    	} else {
    		display.setText("" + Integer.toHexString(converter.getDisplayValue()));
    	}
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame implements ActionListener{
    private JButton FtoC, CtoF;
    private JTextField t;
    private Container pane;

    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	if(s.equals("Convert F to C")){
	    try{
	    t.setText("" +( ((Double.parseDouble(t.getText()) - 32)* 5)/9));
	    }
	    catch(NumberFormatException f){
		t.setText("Illegal imput: Enter a number");
	    }
	}
	if(s.equals("Convert C to F")){
	    try{
		t.setText(""+ (Double.parseDouble(t.getText())*9 / 5 + 32));
	    }
	    catch(NumberFormatException f){
		t.setText("Illegal imput: Enter a number");
	    }
	}
    }
	


    public TemperatureWindow(){
        this.setTitle("Temperature Window");
        this.setSize(600,200);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = this.getContentPane();
        pane.setLayout(new FlowLayout());

        FtoC = new JButton("Convert F to C");
        CtoF = new JButton("Convert C to F");

        t = new JTextField(12);

	FtoC.addActionListener(this);
	CtoF.addActionListener(this);

        pane.add(FtoC);
        pane.add(CtoF);
        pane.add(t);
    }




    public static void main(String[] args) {
	TemperatureWindow g = new TemperatureWindow();
	g.setVisible(true);
    }
}
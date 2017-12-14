import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame implements ActionListener{
    private JButton FtoC, CtoF;
    private JTextField t;
    private Container pane;

    public TemperatureWindow(){
	this.setTitle("Temperature Window");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	FtoC = new JButton("Convert F to C");
	CtoF = new JButton("Convert C to F");

	t = new JTextField(5);

	pane.add(FtoC);
	pane.add(CtoF);
	pane.add(t);
    }


    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("Convert F to C")){
	    t.setText("" +( ((Integer.parseInt(t.getText()) - 32)* 5)/9));
	}
	if(event.equals("Convert C to F")){
	    t.setText(""+ (Integer.parseInt(t.getText())*9 / 5 + 32));
	}
    }

    public static void main(String[] args) {
	TemperatureWindow g = new TemperatureWindow();
	g.setVisible(true);
    }
}
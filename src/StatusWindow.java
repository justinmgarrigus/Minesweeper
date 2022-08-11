import javax.swing.*; 
import java.awt.Dimension; 

public class StatusWindow {
	private JLabel label; 
	
	public StatusWindow() {
		JFrame frame = new JFrame("Minesweeper"); 
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		frame.setAlwaysOnTop(true); 
		
		label = new JLabel("Type something to continue", SwingConstants.CENTER); 
		frame.getContentPane().add(label); 
		
		frame.setPreferredSize(new Dimension(300, 120)); 
		frame.pack(); 
		frame.setVisible(true); 
	}
	
	public void setText(String text) {
		label.setText("Text: " + text); 
	}
}
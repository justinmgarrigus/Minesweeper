import java.util.Map.Entry;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

class Minesweeper {
	private static volatile StatusWindow statusWindow; 
	private static GlobalKeyboardHook keyboardHook; 
	
	public static void main(String[] args) {
		keyboardHook = new GlobalKeyboardHook(true); 
		keyboardHook.addKeyListener(new GlobalKeyAdapter() {
			@Override
			public void keyPressed(GlobalKeyEvent event) {
				Minesweeper.keyPressed(event); 
			}
			
			@Override 
			public void keyReleased(GlobalKeyEvent event) {
				Minesweeper.keyReleased(event); 
			}
		});

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				statusWindow = new StatusWindow(); 
			}
		});
	}
	
	private static void keyPressed(GlobalKeyEvent event) {
		if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE) {
			keyboardHook.shutdownHook(); 
			System.exit(0); 
		}
		
		System.out.println("Key pressed: " + event.getVirtualKeyCode()); 
		statusWindow.setText(event.getKeyChar() + ""); 
	}
	
	private static void keyReleased(GlobalKeyEvent event) {
		System.out.println("Key released: " + event.getVirtualKeyCode()); 
		statusWindow.setText(event.getKeyChar() + ""); 
	}
}
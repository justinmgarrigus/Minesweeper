import java.util.Map.Entry;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

class Minesweeper {
	public static void main(String[] args) {
		GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true); 
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
		
		try {
			while(true) {
				Thread.sleep(128); 
			}
		}
		catch (InterruptedException ex) {
			
		}
		finally {
			keyboardHook.shutdownHook(); 
		}
	}
	
	private static void keyPressed(GlobalKeyEvent event) {
		System.out.println("Key pressed: " + event.getVirtualKeyCode()); 
	}
	
	private static void keyReleased(GlobalKeyEvent event) {
		System.out.println("Key released: " + event.getVirtualKeyCode()); 
	}
}
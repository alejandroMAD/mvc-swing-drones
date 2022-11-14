package controller;

import view.Frame;

/**
 * @author Alejandro M. González
 *
 */

public class App {

	public static void main(String[] args) {

		Frame frame = new Frame();
		
		new MainController(frame);

	}

}

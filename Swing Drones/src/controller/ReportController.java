package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Frame;

public class ReportController implements ActionListener {
	
	private Frame frame;
	
	public ReportController(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getDronA().printConsoleLog();
		frame.getDronB().printConsoleLog();	
	}
}

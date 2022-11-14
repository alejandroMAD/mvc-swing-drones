package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Frame;

public class DronController implements ActionListener {
	
	private Frame frame;
	
	public DronController(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(frame.getBtnStart())) {
			frame.getDronA().startDron();
			frame.getDronB().startDron();
			frame.getBtnStart().setEnabled(false);
			frame.getBtnPauseDronA().setEnabled(true);
			frame.getBtnPauseDronB().setEnabled(true);
			frame.getBtnStopDronA().setEnabled(true);
			frame.getBtnStopDronB().setEnabled(true);
		} else if (e.getSource().equals(frame.getBtnStopDronA())) {
			frame.getDronA().stopDron();
			frame.getBtnPauseDronA().setEnabled(false);
			frame.getBtnResumeDronA().setEnabled(false);
			frame.getBtnStopDronA().setEnabled(false);
		} else if (e.getSource().equals(frame.getBtnStopDronB())) {
			frame.getDronB().stopDron();
			frame.getBtnPauseDronB().setEnabled(false);
			frame.getBtnResumeDronB().setEnabled(false);
			frame.getBtnStopDronB().setEnabled(false);
		} else if (e.getSource().equals(frame.getBtnExit())) {
			System.exit(0);
		} else if (e.getSource().equals(frame.getBtnPauseDronA())) {
			frame.getDronA().pauseDron();
			frame.getBtnResumeDronA().setEnabled(true);
			frame.getBtnPauseDronA().setEnabled(false);
		} else if (e.getSource().equals(frame.getBtnResumeDronA())) {
			frame.getDronA().startDron();;
			frame.getBtnPauseDronA().setEnabled(true);
			frame.getBtnResumeDronA().setEnabled(false);
		} else if (e.getSource().equals(frame.getBtnPauseDronB())) {
			frame.getDronB().pauseDron();
			frame.getBtnResumeDronB().setEnabled(true);
			frame.getBtnPauseDronB().setEnabled(false);
		} else if (e.getSource().equals(frame.getBtnResumeDronB())) {
			frame.getDronB().startDron();
			frame.getBtnPauseDronB().setEnabled(true);
			frame.getBtnResumeDronB().setEnabled(false);
		}
			
	}

}

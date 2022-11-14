package controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.Frame;

public class SpeedController implements ChangeListener {
	
	private Frame frame;
	
	public SpeedController(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		if (e.getSource().equals(frame.getSliderSpeedDronA())) {
			frame.getDronA().setxVelocity(frame.getSliderSpeedDronA().getValue());
		} else if (e.getSource().equals(frame.getSliderSpeedDronB())) {		
			frame.getDronB().setxVelocity(frame.getSliderSpeedDronB().getValue());
		}
		
	}

}

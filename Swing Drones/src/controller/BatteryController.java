package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import view.Frame;

public class BatteryController implements ActionListener {

	private Frame frame;
	private Timer batteryReading;

	public BatteryController(Frame frame) {
		this.frame = frame;
		batteryReading = new Timer(200, this);
		batteryReading.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getProgressBatteryDronA().setValue(frame.getDronA().getBattery());
		frame.getProgressBatteryDronB().setValue(frame.getDronB().getBattery());
		
		if (frame.getProgressBatteryDronA().getValue() == 0) {
			frame.getBtnPauseDronA().setEnabled(false);
			frame.getBtnResumeDronA().setEnabled(false);
			frame.getBtnStopDronA().setEnabled(false);
		}
		
		if (frame.getProgressBatteryDronB().getValue() == 0) {
			frame.getBtnPauseDronB().setEnabled(false);
			frame.getBtnResumeDronB().setEnabled(false);
			frame.getBtnStopDronB().setEnabled(false);
		}

	}

}

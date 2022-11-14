package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import view.Frame;

public class DistanceController implements ActionListener {

	private Frame frame;
	private Timer distanceReading;

	public DistanceController(Frame frame) {
		this.frame = frame;
		distanceReading = new Timer(100, this);
		distanceReading.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getLblDistanceDronA()
				.setText("Distancia recorrida: " + frame.getDronA().getDistance() + " px");
		frame.getLblDistanceDronB()
				.setText("Distancia recorrida: " + frame.getDronB().getDistance() + " px");
	}

}

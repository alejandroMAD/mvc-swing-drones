package model;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Alejandro M. González
 *
 */
public class DronPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private final int PANEL_WIDTH = 500;
	private final int PANEL_HEIGHT = 75;
	private Image bgImage, dronOn, dronOff;
	private boolean stoppedDron, pausedDron;
	private int distance, xVelocity;
	private int x, y; // coordinates
	private double battery, batteryConsumption, efficiencyRatio;
	
	private Timer timer;

	public DronPanel(String name, Image bgImage, Image dronOn, Image dronOff, double efficiencyRatio) {
		this.name = name;
		this.stoppedDron = false;
		this.pausedDron = true;
		this.bgImage = bgImage;
		this.dronOn = dronOn;
		this.dronOff = dronOff;
		this.distance = 0;
		this.xVelocity = 1;
		this.x = 0;
		this.y = 0;
		this.battery = 100;
		this.batteryConsumption = ((double) this.xVelocity / 100) * (1 - efficiencyRatio);
		this.efficiencyRatio = efficiencyRatio;
		
		this.timer = new Timer(10, this);
		
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(bgImage, 0, 0, null);
		g2D.drawImage(dronOn, x, y, null);
		
		if (stoppedDron) {
			g2D.drawImage(dronOff, x, y, null);
		}
	}
	
	public void startDron() {
		this.pausedDron = false;
		this.timer.start();
	}

	public void pauseDron() {
		pausedDron = true;
		this.timer.stop();
	}

	public void stopDron() {
		stoppedDron = true;
		timer.stop();
		repaint();
	}
	
	@Override
	public String toString() {
		String dronStatus = (stoppedDron) ? "STOPPED" : (pausedDron) ? "PAUSED" : "RUNNING";
		return "\nDron name: " + name +
				"\n Dron status: " + dronStatus + 
				"\n Distance travelled: " + distance + " píxels" + 
				"\n Horizontal speed: " + Math.abs(xVelocity) + " px/" + this.timer.getDelay() + " ms" +
				"\n Direction: " + ((xVelocity > 0) ? "right" : "left") +
				"\n Current coordinates: (" + x + ", " + y + ")" +
				"\n Battery left: " + battery + "%" +
				"\n Battery consumption: " + batteryConsumption + "% per " + this.timer.getDelay() + " ms" +
				"\n Efficiency ratio: " + EfficiencyRatio.getRatioName(efficiencyRatio);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.battery <= 0) {
			stopDron();
		}
		
		if (x > PANEL_WIDTH - dronOn.getWidth(null) || x < 0) {
			xVelocity = xVelocity * -1;
		}
		
		x = x + xVelocity;
		distance += Math.abs(xVelocity);
		battery -= batteryConsumption;
		repaint();

	}
	
	public String getName() {
		return name;
	}

	public int getDistance() {
		return distance;
	}

	public void setxVelocity(int xVelocity) {
		this.xVelocity = (this.xVelocity > 0) ? xVelocity : -xVelocity;
		setBatteryConsumption();
	}
	
	public void setBatteryConsumption() {
		this.batteryConsumption = ((double) Math.abs(this.xVelocity) / 100) * (1 - efficiencyRatio);
	}

	public int getBattery() {
		return (int) battery;
	}
	
	public void printConsoleLog() {
		System.out.println(this);
	}
}



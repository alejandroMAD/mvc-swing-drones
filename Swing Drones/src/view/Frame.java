package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import model.*;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int screenWidth, screenHeight, windowWidth, windowHeight;
	private JPanel railsPanel, controlPanel, controlPanelDronA, controlPanelDronB;
	private Image bgImageA, bgImageB, dronAOn, dronAOff, dronBOn, dronBOff;
	private DronPanel dronA, dronB;
	private JButton btnStart, btnPauseDronA, btnResumeDronA, btnStopDronA,
					btnExit, btnPauseDronB, btnResumeDronB, btnStopDronB,
					btnConsoleLog;
	private JLabel lblDistanceDronA, lblDistanceDronB, lblBatteryDronA, lblBatteryDronB,
					lblSpeedDronA, lblSpeedDronB;
	private JSlider sliderSpeedDronA, sliderSpeedDronB;
	private JProgressBar progressBatteryDronA, progressBatteryDronB;

	public Frame() {
		bgImageA = new ImageIcon(getClass().getClassLoader().getResource("clouds_bg.png")).getImage();
		dronAOn = new ImageIcon(getClass().getClassLoader().getResource("comm_dron_on.png")).getImage();
		dronAOff = new ImageIcon(getClass().getClassLoader().getResource("comm_dron_off.png")).getImage();
		bgImageB = new ImageIcon(getClass().getClassLoader().getResource("dock_bg.png")).getImage();
		dronBOn = new ImageIcon(getClass().getClassLoader().getResource("cargo_dron_on.png")).getImage();
		dronBOff = new ImageIcon(getClass().getClassLoader().getResource("cargo_dron_off.png")).getImage();
		
		this.railsPanel = new RailsPanel();
		this.controlPanel = new ControlPanel();
		this.dronA = new DronPanel("COMMS DRON (A)", bgImageA, dronAOn, dronAOff, EfficiencyRatio.MEDIUM.getRatio());
		this.dronB = new DronPanel("CARGO DRON (B)", bgImageB, dronBOn, dronBOff, EfficiencyRatio.LOW.getRatio());
		this.screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		this.screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.windowWidth = 500;
		this.windowHeight = 675;
		
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Swing Drones");
		getContentPane().setLayout(new BorderLayout());
		
		add(railsPanel, BorderLayout.NORTH);
		add(controlPanel, BorderLayout.CENTER);
		railsPanel.add(dronA, BorderLayout.NORTH);
		railsPanel.add(dronB, BorderLayout.SOUTH);
		
		btnStart = new JButton("Comenzar operación");
		btnStart.setBounds(170, 25, 160, 25);
		controlPanel.add(btnStart);
		
		// DRON-A CONTROL PANEL
		
		controlPanelDronA = new JPanel();
		controlPanelDronA.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), 
				"Panel de control del DRON-A"
			)
		);
		controlPanelDronA.setBounds(20, 75, 220, 375);
		controlPanel.add(controlPanelDronA);
		controlPanelDronA.setLayout(null );
		
		btnPauseDronA = new JButton("Interrumpir vuelo");
		btnPauseDronA.setBounds(35, 50, 150, 25);
		controlPanelDronA.add(btnPauseDronA);
		
		btnResumeDronA = new JButton("Reanudar vuelo");
		btnResumeDronA.setBounds(35, 100, 150, 25);
		controlPanelDronA.add(btnResumeDronA);
		
		btnStopDronA = new JButton("Terminar vuelo");
		btnStopDronA.setBounds(35, 150, 150, 25);
		controlPanelDronA.add(btnStopDronA);
		
		lblDistanceDronA = new JLabel("Distancia recorrida: ");
		lblDistanceDronA.setBounds(20, 200, 180, 25);
		controlPanelDronA.add(lblDistanceDronA);
		
		lblSpeedDronA = new JLabel("Velocidad");
		lblSpeedDronA.setBounds(20, 250, 60, 25);
		controlPanelDronA.add(lblSpeedDronA);
		
		sliderSpeedDronA = new JSlider(1, 5, 1);
		sliderSpeedDronA.setBounds(100, 250, 100, 50);
		sliderSpeedDronA.setSnapToTicks(true);
		sliderSpeedDronA.setPaintLabels(true);
		sliderSpeedDronA.setPaintTicks(true);
		sliderSpeedDronA.setMajorTickSpacing(1);
		controlPanelDronA.add(sliderSpeedDronA);
		
		lblBatteryDronA = new JLabel("Batería");
		lblBatteryDronA.setBounds(20, 325, 60, 25);
		controlPanelDronA.add(lblBatteryDronA);
		
		progressBatteryDronA = new JProgressBar();
		progressBatteryDronA.setForeground(new Color(51, 102, 153));
		progressBatteryDronA.setBounds(100, 325, 100, 25);
		progressBatteryDronA.setStringPainted(true);
		controlPanelDronA.add(progressBatteryDronA);
		
		// DRON-B CONTROL PANEL
		
		controlPanelDronB = new JPanel();
		controlPanelDronB.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), 
				"Panel de control del DRON-B"
			)
		);
		controlPanelDronB.setBounds(260, 75, 220, 375);
		controlPanel.add(controlPanelDronB);
		controlPanelDronB.setLayout(null);
		
		btnPauseDronB = new JButton("Interrumpir vuelo");
		btnPauseDronB.setBounds(35, 50, 150, 25);
		controlPanelDronB.add(btnPauseDronB);
		
		btnResumeDronB = new JButton("Reanudar vuelo");
		btnResumeDronB.setBounds(35, 100, 150, 25);
		controlPanelDronB.add(btnResumeDronB);
		
		btnStopDronB = new JButton("Terminar vuelo");
		btnStopDronB.setBounds(35, 150, 150, 25);
		controlPanelDronB.add(btnStopDronB);
		
		lblDistanceDronB = new JLabel("Distancia recorrida: ");
		lblDistanceDronB.setBounds(20, 200, 180, 25);
		controlPanelDronB.add(lblDistanceDronB);
		
		lblSpeedDronB = new JLabel("Velocidad");
		lblSpeedDronB.setBounds(20, 250, 60, 25);
		controlPanelDronB.add(lblSpeedDronB);
		
		sliderSpeedDronB = new JSlider(1, 5, 1);
		sliderSpeedDronB.setBounds(100, 250, 100, 50);
		sliderSpeedDronB.setSnapToTicks(true);
		sliderSpeedDronB.setPaintLabels(true);
		sliderSpeedDronB.setPaintTicks(true);
		sliderSpeedDronB.setMajorTickSpacing(1);
		controlPanelDronB.add(sliderSpeedDronB);
		
		lblBatteryDronB = new JLabel("Batería");
		lblBatteryDronB.setBounds(20, 325, 50, 25);
		controlPanelDronB.add(lblBatteryDronB);
		
		progressBatteryDronB = new JProgressBar();
		progressBatteryDronB.setForeground(new Color(51, 102, 153));
		progressBatteryDronB.setBounds(100, 325, 100, 25);
		progressBatteryDronB.setStringPainted(true);
		controlPanelDronB.add(progressBatteryDronB);
		
		btnConsoleLog = new JButton("Console Log");
		btnConsoleLog.setBounds(70, 475, 120, 25);
		controlPanel.add(btnConsoleLog);
		
		btnExit = new JButton("Salir");
		btnExit.setBounds(310, 475, 120, 25);
		controlPanel.add(btnExit);
		
		this.pack();
	}
	
	// Private components getters to be retrieved by controllers

	public DronPanel getDronA() {
		return dronA;
	}

	public DronPanel getDronB() {
		return dronB;
	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public JButton getBtnPauseDronA() {
		return btnPauseDronA;
	}

	public JButton getBtnResumeDronA() {
		return btnResumeDronA;
	}

	public JButton getBtnStopDronA() {
		return btnStopDronA;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public JButton getBtnPauseDronB() {
		return btnPauseDronB;
	}

	public JButton getBtnResumeDronB() {
		return btnResumeDronB;
	}

	public JButton getBtnStopDronB() {
		return btnStopDronB;
	}

	public JButton getBtnConsoleLog() {
		return btnConsoleLog;
	}

	public JLabel getLblDistanceDronA() {
		return lblDistanceDronA;
	}

	public JLabel getLblDistanceDronB() {
		return lblDistanceDronB;
	}

	public JLabel getLblBatteryDronA() {
		return lblBatteryDronA;
	}

	public JLabel getLblBatteryDronB() {
		return lblBatteryDronB;
	}

	public JSlider getSliderSpeedDronA() {
		return sliderSpeedDronA;
	}

	public JSlider getSliderSpeedDronB() {
		return sliderSpeedDronB;
	}

	public JProgressBar getProgressBatteryDronA() {
		return progressBatteryDronA;
	}

	public JProgressBar getProgressBatteryDronB() {
		return progressBatteryDronB;
	}
	
}
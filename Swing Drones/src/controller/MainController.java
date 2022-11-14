package controller;

import view.Frame;

public class MainController {
	
	private Frame frame;
	private DronController dronController;
	@SuppressWarnings("unused")
	private DistanceController distanceController;
	private SpeedController speedController;
	private ReportController reportController;
	
	public MainController(Frame frame) {
		this.frame = frame;
		dronController = new DronController(frame);
		distanceController = new DistanceController(frame);
		speedController = new SpeedController(frame);
		reportController = new ReportController(frame);
		
		initView();
		initControllers();
	}
	
	public void initView() {
		this.frame.getBtnPauseDronA().setEnabled(false);
		this.frame.getBtnResumeDronA().setEnabled(false);
		this.frame.getBtnStopDronA().setEnabled(false);
		
		this.frame.getBtnPauseDronB().setEnabled(false);
		this.frame.getBtnResumeDronB().setEnabled(false);
		this.frame.getBtnStopDronB().setEnabled(false);
	}
	
	public void initControllers() {
		this.frame.getBtnStart().addActionListener(dronController);
		
		this.frame.getBtnPauseDronA().addActionListener(dronController);
		this.frame.getBtnResumeDronA().addActionListener(dronController);
		this.frame.getBtnStopDronA().addActionListener(dronController);
		this.frame.getBtnPauseDronB().addActionListener(dronController);
		this.frame.getBtnResumeDronB().addActionListener(dronController);
		this.frame.getBtnStopDronB().addActionListener(dronController);
		
		this.frame.getSliderSpeedDronA().addChangeListener(speedController);
		this.frame.getSliderSpeedDronB().addChangeListener(speedController);
		
		this.frame.getBtnConsoleLog().addActionListener(reportController);
		this.frame.getBtnExit().addActionListener(dronController);
	}
		
}

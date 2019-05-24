package sensorApplication;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JProgressBar;

import sensorAdapter.*;
import sensor.*;

public class SensorApplication extends JFrame {
	
	public class SensorPanel extends JPanel {
		public SensorPanel(SensorAdapter sa)
		{
			setLayout(new GridLayout(2,1));
			setBorder(new TitledBorder(sa.getSensorName()));
			String value = Double.toString(sa.getSensorValue());
			String status = sa.getSensorStatus();

			JProgressBar bar = new JProgressBar();
			bar.setForeground(sa.getBarColor());
			bar.setBackground(Color.GRAY);
			bar.setValue(sa.getBarProgress());
			add(bar);
			JLabel readout = new JLabel(status+" ==> "+value);
			readout.setHorizontalAlignment(JLabel.CENTER);
			add(readout);
		}
	}
	
	public SensorApplication() {
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3,1));
		
		JPanel  pressurePnl = new SensorPanel(new PressureSensorAdapter(new PressureSensor()));
		add(pressurePnl);
		
		JPanel  radiationPnl = new SensorPanel(new RadiationSensorAdapter(new RadiationSensor()));
		add(radiationPnl);
	
		JPanel  temperaturePnl = new SensorPanel(new TemperatureSensorAdapter(new TemperatureSensor()));
		add(temperaturePnl);
		
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
	}

}

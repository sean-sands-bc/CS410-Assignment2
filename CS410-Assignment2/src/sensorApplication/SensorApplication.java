package sensorApplication;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import sensorAdapter.*;
import sensor.*;

public class SensorApplication extends JFrame {
	
	public class SensorPanel extends JPanel {
		public SensorPanel(SensorAdapter sa)
		{
			setBorder(new TitledBorder(sa.getSensorName()));
			add(new JLabel("Value: "+Double.toString(sa.getSensorValue())));
			add(new JLabel("Status: "+sa.getSensorStatus()));
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

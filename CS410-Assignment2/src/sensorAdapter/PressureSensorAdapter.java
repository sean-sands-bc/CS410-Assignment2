package sensorAdapter;

import java.awt.Color;

import sensor.PressureSensor;

public class PressureSensorAdapter implements SensorAdapter {
	
	PressureSensor sensor;
	int barProgress = 0;
	
	public PressureSensorAdapter(PressureSensor ps)
	{
		sensor = ps;
	}

	@Override
	public double getSensorValue() {
		double value = sensor.readValue();
		barProgress = (int) (100*value/10);
		return value;
	}

	@Override
	public String getSensorStatus() {
		// TODO Auto-generated method stub
		return sensor.getReport();
	}

	@Override
	public String getSensorName() {
		// TODO Auto-generated method stub
		return sensor.getSensorName();
	}

	@Override
	public Color getBarColor() {
		if(getSensorStatus()=="OK") { return Color.GREEN; }
		if(getSensorStatus()=="CRITICAL") { return Color.YELLOW; }
		if(getSensorStatus()=="DANGER") { return Color.RED; }
		
		return null;
	}

	@Override
	public int getBarProgress() {
		return barProgress;
	}

}

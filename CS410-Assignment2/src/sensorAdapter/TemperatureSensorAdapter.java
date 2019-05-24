package sensorAdapter;

import java.awt.Color;

import sensor.TemperatureSensor;

public class TemperatureSensorAdapter implements SensorAdapter {
	
	TemperatureSensor sensor;
	int barProgress = 0;
	
	public TemperatureSensorAdapter(TemperatureSensor ts)
	{
		sensor = ts;
	}

	@Override
	public double getSensorValue() {
		double value = sensor.senseTemperature();
		barProgress = (int) (100*value/400);
		return value;
	}

	@Override
	public String getSensorStatus() {
		// TODO Auto-generated method stub
		return sensor.getTempReport();
	}

	@Override
	public String getSensorName() {
		// TODO Auto-generated method stub
		return sensor.getSensorType();
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

package sensorAdapter;

import java.awt.Color;

import sensor.RadiationSensor;

public class RadiationSensorAdapter implements SensorAdapter {
	
	RadiationSensor sensor;
	int barProgress = 0;
	
	public RadiationSensorAdapter(RadiationSensor rs)
	{
		sensor = rs;
	}

	@Override
	public double getSensorValue() {
		double value = sensor.getRadiationValue();
		barProgress = (int) (100*value/5);
		return value;
	}

	@Override
	public String getSensorStatus() {
		
		return sensor.getStatusInfo();
	}

	@Override
	public String getSensorName() {
		
		return sensor.getName();
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

package sensorAdapter;

import sensor.TemperatureSensor;

public class TemperatureSensorAdapter implements SensorAdapter {
	
	TemperatureSensor sensor;
	
	public TemperatureSensorAdapter(TemperatureSensor ts)
	{
		sensor = ts;
	}

	@Override
	public double getSensorValue() {
		// TODO Auto-generated method stub
		return sensor.senseTemperature();
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

}

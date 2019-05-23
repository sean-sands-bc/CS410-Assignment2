package sensorAdapter;

import sensor.PressureSensor;

public class PressureSensorAdapter implements SensorAdapter {
	
	PressureSensor sensor;
	
	public PressureSensorAdapter(PressureSensor ps)
	{
		sensor = ps;
	}

	@Override
	public double getSensorValue() {
		// TODO Auto-generated method stub
		return sensor.readValue();
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

}

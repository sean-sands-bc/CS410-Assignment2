package sensorAdapter;

import sensor.RadiationSensor;

public class RadiationSensorAdapter implements SensorAdapter {
	
	RadiationSensor sensor;
	
	public RadiationSensorAdapter(RadiationSensor rs)
	{
		sensor = rs;
	}

	@Override
	public double getSensorValue() {
		
		return sensor.getRadiationValue();
	}

	@Override
	public String getSensorStatus() {
		
		return sensor.getStatusInfo();
	}

	@Override
	public String getSensorName() {
		
		return sensor.getName();
	}

}

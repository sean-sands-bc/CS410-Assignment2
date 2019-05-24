package sensorAdapter;

import java.awt.Color;

public interface SensorAdapter {
	
	public double getSensorValue();
	public String getSensorStatus();
	public String getSensorName();
	public Color getBarColor();
	public int getBarProgress();

}

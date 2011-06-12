package afc.lejostest;
import lejos.nxt.*;
import lejos.robotics.objectdetection.*;

public class DistanceTst implements FeatureListener {

	public static int MAX_DETECT = 80;
	
	public static void main(String[] args) throws Exception {
		
		DistanceTst listener = new DistanceTst();
		UltrasonicSensor us = new UltrasonicSensor(SensorPort.S2);
		RangeFeatureDetector fd = new RangeFeatureDetector(us, MAX_DETECT, 500);
		fd.addListener(listener);
		Button.ENTER.waitForPressAndRelease();
	}
	
	public void featureDetected(Feature feature, FeatureDetector detector) {
		int range = (int)feature.getRangeReading().getRange();
		Sound.playTone(1200 - (range * 10), 100);
		System.out.println("Range:" + range);
	}
}

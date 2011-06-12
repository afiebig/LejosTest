package afc.lejostest;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.objectdetection.Feature;
import lejos.robotics.objectdetection.FeatureDetector;
import lejos.robotics.objectdetection.RangeFeatureDetector;

public class UsTFwdBk {

	public static void main(String[] args) {

		int MAX_DISTANCE = 50; // Distancia maxima en centimetros.
		int PERIOD = 500; // Tiempo de escaneo en milisegundos.

		//Sensor de Presion en el puerto 4
		TouchSensor touch = new TouchSensor(SensorPort.S4);
		//Sensor de Ultra Sonido en el puerto 2
		UltrasonicSensor us = new UltrasonicSensor(SensorPort.S2);

		//Detector de objetos.
		FeatureDetector fd = new RangeFeatureDetector(us, MAX_DISTANCE, PERIOD);

		//Manejar 2 motores de forma simultanea
		//Parametros (Diametro de la rueda, ancho de la pista, Puertos de los motores, Opcional Boolean Reverse)
		DifferentialPilot pilot = new DifferentialPilot(DifferentialPilot.WHEEL_SIZE_NXT2, 5.5f, Motor.A, Motor.C);

		Feature result = fd.scan();
		if(result != null)
			if (result.getRangeReading().getRange() > 16f ){
				pilot.forward();
			}
			else
				pilot.stop();

		Button.waitForPress();
	}
}
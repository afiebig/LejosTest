package afc.lejostest;

import lejos.nxt.*;
import lejos.robotics.navigation.*;

public class MtrTest {

	public static void main(String[] args) {

		//Sensor de Presion en el puerto 4
		TouchSensor touch = new TouchSensor(SensorPort.S4);

		//Manejar 2 motores de forma simultanea
		//Parametros (Diametro de la rueda, ancho de la pista, Puertos de los motores, Opcional Boolean Reverse)
		DifferentialPilot pilot = new DifferentialPilot(DifferentialPilot.WHEEL_SIZE_NXT2, 5.5f, Motor.A, Motor.C);

		//Mover en 20 (Diametro de la rueda)Unidades por Segundo
		pilot.travel(200, true);

		//Mientras se mueva, si el sensor de tacto es precionado, el robot se detiene
		while (pilot.isMoving()) {
			if (touch.isPressed()) pilot.stop();
		}

		//Imprimimos estadisticas del viaje.
		System.out.println(" "+pilot.getMovement().getDistanceTraveled());

		//Esperamos por un boton para terminar.
		Button.waitForPress();
	}

}

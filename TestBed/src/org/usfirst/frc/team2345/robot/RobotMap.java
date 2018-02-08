/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2345.robot;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static Encoder Encoder = new Encoder(3,4);
	
	public static DigitalInput Switch1 = new DigitalInput(0);
	public static DigitalInput Switch2 = new DigitalInput(1);
	public static DigitalInput Switch3 = new DigitalInput(2);
	
	public static WPI_TalonSRX TestCim = new WPI_TalonSRX(0);
	
	public static AnalogInput Actuatorometer = new AnalogInput(2);
	public static VictorSP Actuator = new VictorSP(3);
	public static Counter HallEffect = new Counter(5);
	
	public static VictorSP Grabber1 = new VictorSP(0);
	public static VictorSP Grabber2 = new VictorSP(1);
	public static Relay TestPG = new Relay(0);
	
	public static AnalogInput Ultrasonic2 = new AnalogInput(1);
	public static AnalogInput UltraSonic = new AnalogInput(0);
	
	
	public static ADXRS450_Gyro Gyro = new ADXRS450_Gyro();
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}

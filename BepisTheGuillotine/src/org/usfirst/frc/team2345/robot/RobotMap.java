package org.usfirst.frc.team2345.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;


public class RobotMap {

	public static DigitalInput SwitchGrabber = new DigitalInput(6);
	public static DigitalInput SwitchGrabberDeployed = new DigitalInput(7);
	public static DigitalInput switchLiftBottom = new DigitalInput(8);
	public static DigitalInput switchLiftTop = new DigitalInput(9);
	public static DigitalInput switchGrabberIn = new DigitalInput(10);
	public static DigitalInput frontSwitch = new DigitalInput(11);
	public static DigitalInput HallEffect1 = new DigitalInput(12);// Retracting 
	public static DigitalInput HallEffect2 = new DigitalInput(1);// Extracting
	public static Counter HallEffectC = new Counter(0);
	
	public static VictorSP Grabber1 = new VictorSP(0);
	public static VictorSP Grabber2 = new VictorSP(1);
	public static VictorSP ViagraMotor = new VictorSP(2);
	
	public static ADXRS450_Gyro Gyro = new ADXRS450_Gyro();
	
	
	//Actautor Code
	
	public static VictorSP Actuator = new VictorSP(3);
	
	public static Encoder RightSideEncoder = new Encoder(2,3);
	//public static Encoder LeftSideEncoder = new Encoder(0,1); Currently does not work
	public static Encoder liftEncoder = new Encoder(4,5);
	
	public static WPI_TalonSRX lifterMotor1 = new WPI_TalonSRX(5);
	public static WPI_TalonSRX lifterMotor2 = new WPI_TalonSRX(6);
	
	
	public static WPI_TalonSRX Frontleftmotor = new WPI_TalonSRX(0);
	public static WPI_TalonSRX Backleftmotor = new WPI_TalonSRX(1);
	public static WPI_TalonSRX Frontrightmotor = new WPI_TalonSRX(2);
	public static WPI_TalonSRX Backrightmotor = new WPI_TalonSRX(4);
	
	
}

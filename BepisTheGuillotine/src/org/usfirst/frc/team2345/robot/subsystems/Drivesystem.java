package org.usfirst.frc.team2345.robot.subsystems;

import org.usfirst.frc.team2345.robot.OI;
import org.usfirst.frc.team2345.robot.Robot;
import org.usfirst.frc.team2345.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team2345.robot.RobotMap;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2345.robot.commands.TankDriveWithJoy;

/**
 *
 */
public class Drivesystem extends Subsystem {
	public static WPI_TalonSRX FrontLeftMotor = RobotMap.Frontleftmotor;
	public static WPI_TalonSRX BackLeftMotor = RobotMap.Backleftmotor;
	public static WPI_TalonSRX FrontRightMotor = RobotMap.Frontrightmotor;
	public static WPI_TalonSRX BackRightMotor = RobotMap.Backrightmotor;
	
	public static Encoder RightSideEncoder = RobotMap.RightSideEncoder;
	public static Encoder LeftSideEncoder = RobotMap.LeftSideEncoder;
	
	public static ADXRS450_Gyro Gyro = RobotMap.Gyro;
	public static double distancemathleftside;
	public static double distancemathrightside;
	public static double anglemathleftside;
	public static double anglemathrightside;
	public static double distancemath;
	public static double distancedelta;
	public static double angleDelta;
	public static double angleMath;
	
	public static Boolean gameSetup2 = false;
	
	public static Boolean first = false;
	
	public static int counter;
	public static int timer;
	
	//public static DigitalInput frontSwitch = RobotMap.frontSwitch;
	
	public void gyroreset() {
		counter += 1;
		Gyro.reset();
		RightSideEncoder.reset();
    	LeftSideEncoder.reset();
	}
	
	public void reset() {
		counter += 1;
		RightSideEncoder.reset();
    	LeftSideEncoder.reset();
    	
	}
	
	public void MoveForwardFeet(double Feet)
	{	
		
	double deviation = Gyro.getAngle()/129;
	double RightEncoder = RightSideEncoder.get();
	double LeftEncoder = LeftSideEncoder.get();
	double FeetMoved = ((RightEncoder + LeftEncoder)/720)*1.57;
	
	distancedelta = Feet-FeetMoved;
	distancemath=distancedelta/1.5;
	
	if(distancemath>1) {
		distancemath=1.;
	}
	if(distancemath<-1) {
		distancemath=-1.;
	}
	
	distancemathleftside=distancemath*.42;
	distancemathrightside=distancemath*.52;
	
	BackLeftMotor.set(distancemathleftside);
	FrontLeftMotor.set(distancemathleftside);
	BackRightMotor.set(-distancemathrightside);
	FrontRightMotor.set(-distancemathrightside);
	
	if(distancedelta<=.1 && distancedelta>=-.1) {

		BackLeftMotor.set(0);
		FrontLeftMotor.set(0);
		BackRightMotor.set(0);
		FrontRightMotor.set(0);
		
		
		
		counter += 1;
		
	}
	
		SmartDashboard.putNumber("DriveCounter",(int) counter);
		SmartDashboard.putNumber("FeetMoved", (double) FeetMoved);
		
    	
		SmartDashboard.putNumber("Gyro",(double) Gyro.getAngle());
		SmartDashboard.putNumber("RightSideEncoder",(double) RightSideEncoder.get());
		SmartDashboard.putNumber("LeftSideEncoder",(double) LeftSideEncoder.get());
		
		
		
		
	}
	
	public void MoveForwardShort(double Feet)
	{	
		
	double deviation = Gyro.getAngle()/129;
	double RightEncoder = RightSideEncoder.get();
	double LeftEncoder = LeftSideEncoder.get();
	double FeetMoved = ((RightEncoder + LeftEncoder)/720)*1.57;
	
	distancedelta = Feet-FeetMoved;
	
	if(Feet>0) {
		distancemath=1.;
	}
	if(Feet<0) {
		distancemath=-1.;
	}
	
	distancemathleftside=distancemath*.32;
	distancemathrightside=distancemath*.42;
	
	BackLeftMotor.set(distancemathleftside);
	FrontLeftMotor.set(distancemathleftside);
	BackRightMotor.set(-distancemathrightside);
	FrontRightMotor.set(-distancemathrightside);
	
	if(distancedelta<=.1 && distancedelta>=-.1) {

		BackLeftMotor.set(0);
		FrontLeftMotor.set(0);
		BackRightMotor.set(0);
		FrontRightMotor.set(0);
		
		
		
		counter += 1;
		
	}
	
		SmartDashboard.putNumber("DriveCounter",(int) counter);
		SmartDashboard.putNumber("FeetMoved", (double) FeetMoved);
		
    	
		SmartDashboard.putNumber("Gyro",(double) Gyro.getAngle());
		SmartDashboard.putNumber("RightSideEncoder",(double) RightSideEncoder.get());
		SmartDashboard.putNumber("LeftSideEncoder",(double) LeftSideEncoder.get());
		
		
		
		
	}
	
	public void rammingCommand() {
		if(timer<50) {
		BackLeftMotor.set(.2);
		FrontLeftMotor.set(.2);
		BackRightMotor.set(-.2);
		FrontRightMotor.set(-.2);
		timer+=1;
		SmartDashboard.putNumber("Timer",(int)timer);
		}
		else {
			BackLeftMotor.set(0);
			FrontLeftMotor.set(0);
			BackRightMotor.set(0);
			FrontRightMotor.set(0);
			gameSetup2=true;
		}
	}
	
	public void RotateRobot(double Angle)
	{
		double AngleRotated = Gyro.getAngle();//A 360 rotation for the robot at the angle it is at now is 128 2.8125
		
		angleDelta = Angle-AngleRotated;
		angleMath=angleDelta/5;
		
		if(angleMath>1) {
			angleMath=1.;
		}
		if(angleMath<-1) {
			angleMath=-1.;
		}
		
		anglemathleftside=angleMath*.32;
		anglemathrightside=angleMath*.4;
		
		
		
		if(angleDelta<=.5 && angleDelta>=-.5) {

			BackLeftMotor.set(0);
			FrontLeftMotor.set(0);
			BackRightMotor.set(0);
			FrontRightMotor.set(0);
			
			counter +=1;
			
		}
		else {
			BackLeftMotor.set(anglemathleftside);
			FrontLeftMotor.set(anglemathleftside);
			BackRightMotor.set(anglemathrightside);
			FrontRightMotor.set(anglemathrightside);
		}
		
		SmartDashboard.putNumber("Gyro", (double) AngleRotated);
    		
	}

	public void RobotDriveJoy(Joystick XboxC)
	{
		double Rightencoder = RightSideEncoder.get();
		double LeftEncoder = LeftSideEncoder.get();
		double FeetMoved = ((Rightencoder+LeftEncoder)/720)*1.57;
		
    	
		
	
		double forwardBasic = XboxC.getRawAxis(3);
		double backwardBasic= XboxC.getRawAxis(2);
		double turnBasic = -XboxC.getRawAxis(0);
		
		if(turnBasic<.05 && turnBasic>-.05) {
			turnBasic=0;
		}
		
		
		double forward = forwardBasic ;
		double backward = backwardBasic ;
		double turn = turnBasic*.75 ;
		//The math.sin function is used to slowly scale the value of the motors to accelerate it better
		/*FrontLeftMotor.set((forward-backward-turn)*Math.sin((forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57));
		BackLeftMotor.set((forward-backward-turn)*Math.sin((forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57));
		FrontRightMotor.set((-forward+backward-turn)*Math.sin((+forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57));
		BackRightMotor.set((-forward+backward-turn)*Math.sin((+forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57));*/
		
		/*
		FrontLeftMotor.set((forward-backward-turn)*Math.sin((forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57)*.42);
		BackLeftMotor.set((forward-backward-turn)*Math.sin((forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57)*.42);
		FrontRightMotor.set((-forward+backward-turn)*Math.sin((+forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57)*.5);
		BackRightMotor.set((-forward+backward-turn)*Math.sin((+forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57)*.5);
		*/
		double FowardWeight = Math.pow(forward, 2);
		double BackwardWeight = -Math.pow(backward, 2);
		double TurnWeight = Math.pow(turn, 2);
		
		if(turn<0) {
			TurnWeight = -TurnWeight;
		}
		
		
		double weight = FowardWeight + BackwardWeight + TurnWeight;
		
		FrontLeftMotor.set((forward-backward-turn)*weight*.42);
		BackLeftMotor.set((forward-backward-turn)*weight*.42);
		FrontRightMotor.set((-forward+backward-turn)*weight*.5);
		BackRightMotor.set((-forward+backward-turn)*weight*.5);
		
		FrontRightMotor.setNeutralMode(NeutralMode.Coast);
		BackRightMotor.setNeutralMode(NeutralMode.Coast);
		FrontLeftMotor.setNeutralMode(NeutralMode.Coast);
		BackLeftMotor.setNeutralMode(NeutralMode.Coast);
		
		/*FrontLeftMotor.set(forward-backward-turn);
		BackLeftMotor.set(forward-backward-turn);
		FrontRightMotor.set(-forward+backward-turn);
		BackRightMotor.set(-forward+backward-turn);*/

		SmartDashboard.putNumber("FeetMoved", (double) FeetMoved);
		
		SmartDashboard.putNumber("Gyro",(double) Gyro.getAngle());
		SmartDashboard.putNumber("RightSideEncoder",(double) RightSideEncoder.get());
		SmartDashboard.putNumber("LeftSideEncoder",(double) LeftSideEncoder.get());
		
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDriveWithJoy());
    }
}

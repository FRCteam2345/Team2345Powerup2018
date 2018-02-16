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
	//public static Encoder LeftSideEncoder = RobotMap.LeftSideEncoder;
	public static double distancemathleftside;
	public static double distancemathrightside;
	public static double anglemathleftside;
	public static double anglemathrightside;
	public static double distancemath;
	public static double distancedelta;
	public static double angleDelta;
	public static double angleMath;
	public static ADXRS450_Gyro Gyro = RobotMap.Gyro;
	public static Boolean first = false;
	public static int counter;
	public static DigitalInput frontSwitch = RobotMap.frontSwitch;
	
	public void MoveForwardFeet(double Feet)
	{	
		
	double deviation = Gyro.getAngle()/130;
	double RightEncoder = RightSideEncoder.get();
	//double LeftEncoder = -LeftSideEncoder.get();
	double FeetMoved = ((RightEncoder)/360)*1.57;
	
	distancedelta = Feet-FeetMoved;
	distancemath=distancedelta/.5;
	
	if(distancemath>1) {
		distancemath=1.;
	}
	if(distancemath<-1) {
		distancemath=-1.;
	}
	
	distancemathleftside=distancemath*.3;
	distancemathrightside=distancemath*.4;
	
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
		RightSideEncoder.reset();
    	//LeftSideEncoder.reset();
	}
		SmartDashboard.putNumber("DriveCounter",(int) counter);
		SmartDashboard.putNumber("FeetMoved", (double) FeetMoved);
		
    	
		SmartDashboard.putNumber("Gyro",(double) Gyro.getAngle());
		SmartDashboard.putNumber("RightSideEncoder",(double) RightSideEncoder.get());
		//SmartDashboard.putNumber("LeftSideEncoder",(double) LeftSideEncoder.get());
		/*
		if(deviation < -.05 || deviation > .05){
		FrontLeftMotor.set(FrontLeftMotor.get()+.1*deviation);
		BackLeftMotor.set(BackLeftMotor.get()+.1*deviation);
		FrontRightMotor.set(FrontRightMotor.get()+.1*deviation);
		BackRightMotor.set(BackRightMotor.get()+.1*deviation);
	}
		*/
		
		
		
	}
	
	public  void fowardTillSwitch() 
	{
		if(frontSwitch.get() == true) /*not pressed*/ 
		{
			BackLeftMotor.set(.4);
			FrontLeftMotor.set(.4);
			BackRightMotor.set(.4);
			FrontRightMotor.set(.4);
		}
		
		else 
		{
			BackLeftMotor.set(0);
			FrontLeftMotor.set(0);
			BackRightMotor.set(0);
			FrontRightMotor.set(0);
			counter+=1;
			
		}
	}
	
	public void RotateRobot(double Angle)
	{
		double AngleRotated = Gyro.getAngle();
		
		angleDelta = Angle-AngleRotated;
		angleMath=angleDelta/16.25;
		
		if(angleMath>1) {
			angleMath=1.;
		}
		if(angleMath<-1) {
			angleMath=-1.;
		}
		
		
		anglemathleftside=angleMath*.3;
		anglemathrightside=angleMath*.4;
		
		BackLeftMotor.set(anglemathleftside);
		FrontLeftMotor.set(anglemathleftside);
		BackRightMotor.set(anglemathrightside);
		FrontRightMotor.set(anglemathrightside);
		
		if(angleDelta<=5 && angleDelta>=-5) {

			BackLeftMotor.set(0);
			FrontLeftMotor.set(0);
			BackRightMotor.set(0);
			FrontRightMotor.set(0);
			
			counter +=1;
			Gyro.reset();
			RightSideEncoder.reset();
	    	//LeftSideEncoder.reset();
		}
		
		SmartDashboard.putNumber("Gyro", (double) Gyro.getAngle());
    		
	}

	public void RobotDriveJoy(Joystick XboxC)
	{
		double Rightencoder = RightSideEncoder.get();
		//double LeftEncoder = -LeftSideEncoder.get();
		double FeetMoved = ((Rightencoder)/360)*1.57;
		
    	
		
	
		double forwardBasic = XboxC.getRawAxis(3);
		double backwardBasic= XboxC.getRawAxis(2);
		double turnBasic = -XboxC.getRawAxis(0);
		
		if(turnBasic<.05 && turnBasic>-.05) {
			turnBasic=0;
		}
		
		
		double forward = forwardBasic ;
		double backward = backwardBasic ;
		double turn = turnBasic ;
		//The math.sin function is used to slowly scale the value of the motors to accelerate it better
		/*FrontLeftMotor.set((forward-backward-turn)*Math.sin((forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57));
		BackLeftMotor.set((forward-backward-turn)*Math.sin((forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57));
		FrontRightMotor.set((-forward+backward-turn)*Math.sin((+forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57));
		BackRightMotor.set((-forward+backward-turn)*Math.sin((+forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57));*/
		
		
		FrontLeftMotor.set((forward-backward-turn)*Math.sin((forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57)*.35);
		BackLeftMotor.set((forward-backward-turn)*Math.sin((forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57)*.35);
		FrontRightMotor.set((-forward+backward-turn)*Math.sin((+forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57)*.35);
		BackRightMotor.set((-forward+backward-turn)*Math.sin((+forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57)*.35);
		
	
		
		/*FrontLeftMotor.set(forward-backward-turn);
		BackLeftMotor.set(forward-backward-turn);
		FrontRightMotor.set(-forward+backward-turn);
		BackRightMotor.set(-forward+backward-turn);*/

		SmartDashboard.putNumber("FeetMoved", (double) FeetMoved);
		
		SmartDashboard.putNumber("Gyro",(double) Gyro.getAngle());
		SmartDashboard.putNumber("RightSideEncoder",(double) RightSideEncoder.get());
		//SmartDashboard.putNumber("LeftSideEncoder",(double) LeftSideEncoder.get());
		
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDriveWithJoy());
    }
}

package org.usfirst.frc.team2345.robot.subsystems;

import org.usfirst.frc.team2345.robot.OI;
import org.usfirst.frc.team2345.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team2345.robot.RobotMap;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
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
	public static Boolean first = false;
	public static int counter = 0;
	
	public void MoveForwardFeet(double Feet)
	{	
	double deviation = Gyro.getAngle()/360;
	double RightEncoder = RightSideEncoder.get();
	double LeftEncoder = -LeftSideEncoder.get();
	double FeetMoved = ((RightEncoder+LeftEncoder)/720)*1.57;
	
		
	
	
		if(FeetMoved<Feet-.5)
		{
			FrontLeftMotor.set(.30);
			BackLeftMotor.set(.30);
			FrontRightMotor.set(-.30);
			BackRightMotor.set(-.30);
		
		}
		else if(FeetMoved<Feet-.25){
			FrontLeftMotor.set(.15);
			BackLeftMotor.set(.15);
			FrontRightMotor.set(-.15);
			BackRightMotor.set(-.15);
		}
		else if(FeetMoved<Feet){
			FrontLeftMotor.set(.1);
			BackLeftMotor.set(.1);
			FrontRightMotor.set(-.1);
			BackRightMotor.set(-.1);
		}
		else{
			FrontLeftMotor.stopMotor();
			BackLeftMotor.stopMotor();
			FrontRightMotor.stopMotor();
			BackRightMotor.stopMotor();
			
			counter += 1;
			RightSideEncoder.reset();
	    	LeftSideEncoder.reset();
			
		}
		/*if(deviation < -5 || deviation > 5){
		FrontLeftMotor.set(FrontLeftMotor.get()+.1*deviation);
		BackLeftMotor.set(BackLeftMotor.get()+.1*deviation);
		FrontRightMotor.set(FrontRightMotor.get()+.1*deviation);
		BackRightMotor.set(BackRightMotor.get()+.1*deviation);
	}*/
		
		
		
		
	}
	
	public void RotateRobot(double Angle)
	{
		double AngleRotated = Gyro.getAngle();
		if(AngleRotated>Angle)
    	{
    		FrontLeftMotor.set(.30);
			BackLeftMotor.set(.30);
			FrontRightMotor.set(.30);
			BackRightMotor.set(.30);
    	}
    	else
    	{
    		FrontLeftMotor.stopMotor();
			BackLeftMotor.stopMotor();
			FrontRightMotor.stopMotor();
			BackRightMotor.stopMotor();
			
			counter += 1;
			Gyro.reset();
    	}
    		
	}

	public void RobotDriveJoy(Joystick Stick, Joystick Schtick)
	{
		/*Double Throttle = Stick.getZ();
		Double LeftSide = Stick.getX()*Throttle;
		Double RightSide = Stick.getX()*Throttle;
		//Double LeftSide = Stick.getY()*Throttle;
		//Double RightSide = Stick.getY()*Throttle;
		FrontLeftMotor.set(-LeftSide);
		BackLeftMotor.set(LeftSide);
		FrontRightMotor.set(-RightSide);
		BackRightMotor.set(RightSide);
		
		SmartDashboard.putNumber("Leftside",(Double) LeftSide);
		SmartDashboard.putNumber("Rightside",(Double) RightSide);*/
		double Rightencoder = RightSideEncoder.get();
		double LeftEncoder = -LeftSideEncoder.get();
		double FeetMoved = ((Rightencoder+LeftEncoder)/720)*1.57;
		
    	SmartDashboard.putNumber("FeetMoved", (double) FeetMoved);
		/*
    	Double Throttle = Stick.getZ();
		Double RightTrack = Stick.getY() * Throttle;
		Double LeftTrack = Schtick.getY() * Throttle;
		FrontLeftMotor.set(LeftTrack);
		BackLeftMotor.set(LeftTrack);
		FrontRightMotor.set(-RightTrack);
		BackRightMotor.set(-RightTrack);
		*/
    	
		SmartDashboard.putNumber("Gyro",(double) Gyro.getAngle());
		SmartDashboard.putNumber("RightSideEncoder",(double) RightSideEncoder.get());
		SmartDashboard.putNumber("LeftSideEncoder",(double) LeftSideEncoder.get());
		Double Throttle = Stick.getZ();
		SmartDashboard.putNumber("Throttle",(double) Throttle);
		Double RightTrack = Stick.getY() * Throttle + Schtick.getX()*Throttle;
		Double LeftTrack = Stick.getY() * Throttle - Schtick.getX()*Throttle;
		FrontLeftMotor.set(LeftTrack);
		BackLeftMotor.set(LeftTrack);
		FrontRightMotor.set(-RightTrack);
		BackRightMotor.set(-RightTrack);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDriveWithJoy());
    }
}

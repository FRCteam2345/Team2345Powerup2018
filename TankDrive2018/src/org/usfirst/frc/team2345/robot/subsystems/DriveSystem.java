package org.usfirst.frc.team2345.robot.subsystems;

import org.usfirst.frc.team2345.robot.OI;
import org.usfirst.frc.team2345.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2345.robot.commands.TankDrive;

/**
 *
 */
public class DriveSystem extends Subsystem {
	public static WPI_TalonSRX FrontLeftMotor = RobotMap.Frontleftmotor;
	public static WPI_TalonSRX BackLeftMotor = RobotMap.Backleftmotor;
	public static WPI_TalonSRX FrontRightMotor = RobotMap.Frontrightmotor;
	public static WPI_TalonSRX BackRightMotor = RobotMap.Backrightmotor;
	boolean triggerDrive = true;
	
	/*public void RobotDriveJoy(Joystick Stick, Joystick Schtick)
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
		
		/*Double Throttle = Stick.getZ();
		Double RightTrack = Stick.getY() * Throttle;
		Double LeftTrack = Schtick.getY() * Throttle;
		FrontLeftMotor.set(LeftTrack);
		BackLeftMotor.set(LeftTrack);
		FrontRightMotor.set(-RightTrack);
		BackRightMotor.set(-RightTrack);*/
		
		//Double Throttle = Stick.getZ();
		//Double RightTrack = Stick.getY() * Throttle + Schtick.getX()*Throttle;
		//Double LeftTrack = Stick.getY() * Throttle - Schtick.getX()*Throttle;
		//FrontLeftMotor.set(LeftTrack);
		//BackLeftMotor.set(LeftTrack);
		//FrontRightMotor.set(-RightTrack);
		//BackRightMotor.set(-RightTrack);
	//}
				
public void RobotDriveJoy(Joystick XboxC)
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
		
		/*Double Throttle = Stick.getZ();
		Double RightTrack = Stick.getY() * Throttle;
		Double LeftTrack = Schtick.getY() * Throttle;
		FrontLeftMotor.set(LeftTrack);
		BackLeftMotor.set(LeftTrack);
		FrontRightMotor.set(-RightTrack);
		BackRightMotor.set(-RightTrack);*/
		
	
	  //X  axis box Controller Code
	
	/*
	boolean BeckEthan = XboxC.getRawButton(7);
	boolean Best = XboxC.getRawButton(8);
	
		if (Best == true)
		{
			double forwardBasic = XboxC.getRawAxis(3);
			double backwardBasic= XboxC.getRawAxis(2);
			double turnBasic = XboxC.getRawAxis(0);
			
			double forward = forwardBasic * 0.35;
			double backward = backwardBasic * 0.35;
			double turn = turnBasic * 0.35;
			
			FrontLeftMotor.set(forward-backward-turn);
			BackLeftMotor.set(forward-backward-turn);
			FrontRightMotor.set(-forward+backward-turn);
			BackRightMotor.set(-forward+backward-turn);
				
		}

		if( BeckEthan == true)
		{
		
		double forwardBasic = XboxC.getRawAxis(1);
	
		double turnBasic = XboxC.getRawAxis(4);
		
		double forward = forwardBasic * 0.35;
		
		double turn = turnBasic * 0.35;
		
		FrontLeftMotor.set(-forward+turn);
		BackLeftMotor.set(-forward+turn);
		FrontRightMotor.set(forward+turn);
		BackRightMotor.set(forward+turn);

		}
		*/
		
	if(triggerDrive == true){
		
			//Best Controller Setup
		
			double forwardBasic = XboxC.getRawAxis(3);
			double backwardBasic= XboxC.getRawAxis(2);
			double turnBasic = XboxC.getRawAxis(0);
				
			double forward = forwardBasic * 0.35;
			double backward = backwardBasic * 0.35;
			double turn = turnBasic * 0.35;
			
			FrontLeftMotor.set(forward-backward-turn);
			BackLeftMotor.set(forward-backward-turn);
			FrontRightMotor.set(-forward+backward-turn);
			BackRightMotor.set(-forward+backward-turn);
			
			}		
			
		else
			{
				
			// Best Code
			// Who drives a robot with PvP controller setup?
			
			double forwardBasic = XboxC.getRawAxis(1);
		
			double turnBasic = XboxC.getRawAxis(4);
			
			double forward = forwardBasic * 0.35;
			
			double turn = turnBasic * 0.35;
			
			FrontLeftMotor.set(-forward+turn);
			BackLeftMotor.set(-forward+turn);
			FrontRightMotor.set(forward+turn);
			BackRightMotor.set(forward+turn);
			
			}
	}
	
		/*if(forward > 0) 
		{
			FrontLeftMotor.set(forward);
			BackLeftMotor.set(forward);
			FrontRightMotor.set(-forward);
			BackRightMotor.set(-forward);
		}
		
		if(backward > 0) 
		{
			FrontLeftMotor.set(-backward);
			BackLeftMotor.set(-backward);
			FrontRightMotor.set(backward);
			BackRightMotor.set(backward);
		}
		
		if(turn > 0) 
		{
			FrontLeftMotor.set(turn);
			BackLeftMotor.set(turn);
			FrontRightMotor.set(turn);
			BackRightMotor.set(turn);
		}
		
		else if(turn < 0) 
		{
			FrontLeftMotor.set(forward-backward-turn);
			BackLeftMotor.set(forward);
			FrontRightMotor.set(-forward);
			BackRightMotor.set(-forward);
		}*/
		
		//end X axis box Controller Code
		
		
		
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDrive());
    }
    
    
    //XboxController Code
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}


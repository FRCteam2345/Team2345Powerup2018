package org.usfirst.frc.team2345.robot.commands;

import java.util.ArrayList;
import java.util.Random;

import org.usfirst.frc.team2345.robot.Robot;
import org.usfirst.frc.team2345.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Autonomous extends Command {
	/*public static WPI_TalonSRX FrontLeftMotor = RobotMap.Frontleftmotor;
	public static WPI_TalonSRX BackLeftMotor = RobotMap.Backleftmotor;
	public static WPI_TalonSRX FrontRightMotor = RobotMap.Frontrightmotor;
	public static WPI_TalonSRX BackRightMotor = RobotMap.Backrightmotor;
	public static Encoder RightSideEncoder = RobotMap.RightSideEncoder;
	public static Encoder LeftSideEncoder = RobotMap.LeftSideEncoder;
	public static ADXRS450_Gyro Gyro = RobotMap.Gyro;*/
	//public static String gameData= Robot.gameData;
	public static Encoder liftEncoder = RobotMap.liftEncoder;
	public static Boolean first = Robot.Drivesystem.first;
	public static int counter = Robot.Drivesystem.counter;
	 
	public Autonomous() {
    	requires(Robot.Drivesystem);
        // Use requires() here to declare subsystem dependencies
       
    }

    protected void initialize() {
    	liftEncoder.reset();
    	
    	ArrayList<String> possibleGameStates = new ArrayList<String>();
		possibleGameStates.add("LLL");
		possibleGameStates.add("LLR");
		possibleGameStates.add("LRR");
		possibleGameStates.add("RRR");
		possibleGameStates.add("RLL");
		possibleGameStates.add("RRL");
		possibleGameStates.add("RLR");
		possibleGameStates.add("LRL");
		Random randomizer = new Random();
		String gameData = possibleGameStates.get(randomizer.nextInt(6));
		int fieldPosition = randomizer.nextInt(3);
		SmartDashboard.putString("FieldPosition",(String) gameData);
    	
    }

    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	/*double AngleRotated = Gyro.getAngle();
    	double RightEncoder = RightSideEncoder.get();
		double LeftEncoder = -LeftSideEncoder.get();
    	double FeetMoved = ((RightEncoder+LeftEncoder)/720)*1.57;*/
    	
		//j
		/*if(counter == 0){
		
			Robot.Drivesystem.MoveForwardFeet(2);
		}
		else if (counter == 1){
			Robot.Drivesystem.RotateRobot(360);
		}
		else if (counter == 2){
			Robot.Drivesystem.MoveForwardFeet(2);	
		}*/
    	//145 ticks of the lift encoder is one rotation of the axle
    	Robot.Liftsystem.SetLiftHeight(1450);
			
		
		
		
    	/*if(FeetMoved<5)
		{
			FrontLeftMotor.set(.30);
			BackLeftMotor.set(.30);
			FrontRightMotor.set(-.30);
			BackRightMotor.set(-.30);
		}
	else
		{
			FrontLeftMotor.stopMotor();
			BackLeftMotor.stopMotor();
			FrontRightMotor.stopMotor();
			BackRightMotor.stopMotor();
			
		}*/
    	/*if(AngleRotated>360)
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
    	}
    	*/
    	/*if(gameData=="RRR"){
    		if(FeetMoved<5)
    		{
    			FrontLeftMotor.set(.30);
    			BackLeftMotor.set(.30);
    			FrontRightMotor.set(-.40);
    			BackRightMotor.set(-.40);
    		}
    	else
    		{
    			FrontLeftMotor.set(0);
    			BackLeftMotor.set(0);
    			FrontRightMotor.set(0);
    			BackRightMotor.set(0);
    		}
    	}
    	
    	else if(gameData=="RRL"){
    		if(FeetMoved<5)
    		{
    			FrontLeftMotor.set(.30);
    			BackLeftMotor.set(.30);
    			FrontRightMotor.set(-.40);
    			BackRightMotor.set(-.40);
    		}
    	else
    		{
    			FrontLeftMotor.set(0);
    			BackLeftMotor.set(0);
    			FrontRightMotor.set(0);
    			BackRightMotor.set(0);
    		}
    	}

    	else if(gameData=="RLL"){
    		if(FeetMoved<5)
    		{
    			FrontLeftMotor.set(.30);
    			BackLeftMotor.set(.30);
    			FrontRightMotor.set(-.40);
    			BackRightMotor.set(-.40);
    		}
    	else
    		{
    			FrontLeftMotor.set(0);
    			BackLeftMotor.set(0);
    			FrontRightMotor.set(0);
    			BackRightMotor.set(0);
    		}
    	}

    	else if(gameData=="LLL"){
    		if(FeetMoved<5)
    		{
    			FrontLeftMotor.set(.30);
    			BackLeftMotor.set(.30);
    			FrontRightMotor.set(-.40);
    			BackRightMotor.set(-.40);
    		}
    	else
    		{
    			FrontLeftMotor.set(0);
    			BackLeftMotor.set(0);
    			FrontRightMotor.set(0);
    			BackRightMotor.set(0);
    		}
    	}

    	else if(gameData=="LLR"){
    		if(FeetMoved<5)
    		{
    			FrontLeftMotor.set(.30);
    			BackLeftMotor.set(.30);
    			FrontRightMotor.set(-.40);
    			BackRightMotor.set(-.40);
    		}
    	else
    		{
    			FrontLeftMotor.set(0);
    			BackLeftMotor.set(0);
    			FrontRightMotor.set(0);
    			BackRightMotor.set(0);
    		}

    	}

    	else if(gameData=="LRR"){
    		if(FeetMoved<5)
    		{
    			FrontLeftMotor.set(.30);
    			BackLeftMotor.set(.30);
    			FrontRightMotor.set(-.40);
    			BackRightMotor.set(-.40);
    		}
    	else
    		{
    			FrontLeftMotor.set(0);
    			BackLeftMotor.set(0);
    			FrontRightMotor.set(0);
    			BackRightMotor.set(0);
    		}

    	}

    	else if(gameData=="RLR"){
    		if(FeetMoved<5)
    		{
    			FrontLeftMotor.set(.30);
    			BackLeftMotor.set(.30);
    			FrontRightMotor.set(-.40);
    			BackRightMotor.set(-.40);
    		}
    	else
    		{
    			FrontLeftMotor.set(0);
    			BackLeftMotor.set(0);
    			FrontRightMotor.set(0);
    			BackRightMotor.set(0);
    		}
    	}

    	else if(gameData=="LRL"){
    		if(FeetMoved<5)
    		{
    			FrontLeftMotor.set(.30);
    			BackLeftMotor.set(.30);
    			FrontRightMotor.set(-.40);
    			BackRightMotor.set(-.40);
    		}
    	else
    		{
    			FrontLeftMotor.set(0);
    			BackLeftMotor.set(0);
    			FrontRightMotor.set(0);
    			BackRightMotor.set(0);
    		}
    	}*/
    	
    	
    	
    	/*SmartDashboard.putNumber("Angle", (double)AngleRotated);
    	SmartDashboard.putNumber("FeetMoved", (double) FeetMoved);*/
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

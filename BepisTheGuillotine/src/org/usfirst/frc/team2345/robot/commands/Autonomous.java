package org.usfirst.frc.team2345.robot.commands;

import java.util.ArrayList;
import java.util.Random;

import org.usfirst.frc.team2345.robot.Robot;
import org.usfirst.frc.team2345.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Autonomous extends Command {

	public static Encoder liftEncoder = RobotMap.liftEncoder;
	public static Boolean first = Robot.Drivesystem.first;
	public static String gameData;
	public static Boolean gameSetup2;
	public static int fieldPosition;
	public static Boolean gameSetup;
	public static int counter;
	
	public Autonomous() {
    	requires(Robot.Drivesystem);
    	requires(Robot.Grabber);
    	requires(Robot.Liftsystem);
      
       
    }

    protected void initialize() {
    	
    	
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
    	Boolean gameSetup=false;
    	Boolean gameSetup2=false;
    }

    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	gameSetup2 = Robot.Drivesystem.gameSetup2;
    	gameSetup = Robot.Liftsystem.gameSetup;
    	counter = Robot.Drivesystem.counter + Robot.Liftsystem.counter + Robot.Grabber.counter;
    	//gameData = DriverStation.getInstance().getGameSpecificMessage();
    	if(gameSetup==false) {
    		Robot.Liftsystem.Tilt();
    		Robot.Grabber.Grabbing();
    	}
    	else if(gameSetup2==false) {
    		Robot.Grabber.Stop();;
    		//Robot.Drivesystem.reset();
    		gameSetup2=true;
    	}

    	if(gameSetup2==true) { 
        	
        	if(fieldPosition == 1) {
        		if(gameData=="RLL" || gameData=="RLR" ) {
        			if(counter==0) {
                		//Robot.Drivesystem.RotateRobot(129);//129=Rotation
            			//Robot.Drivesystem.MoveForwardFeet(20);
                		Robot.Drivesystem.gyroreset();
            		//	Robot.Drivesystem.RotateRobot(-32.25);
            			}
        			else if(counter==1) {
        				Robot.Drivesystem.MoveForwardFeet(22);
        			}
            		else if(counter==2) {
            			Robot.Drivesystem.reset();
            		}
            		else if(counter==3) {
            		Robot.Drivesystem.RotateRobot(32.25);
            		}
            		else if(counter==4) {
            			Robot.Drivesystem.gyroreset();
            		}
            		else if(counter==5) {
            			Robot.Drivesystem.MoveForwardFeet(3);//MakeSmalldistancecode
            		}
            		else if(counter==6) {
            			Robot.Drivesystem.reset();
            		}
            		else if(counter==7) {
            			Robot.Grabber.Releasing();
            		}
            		
        			Robot.Liftsystem.LiftTop();
        		}
        		if(gameData=="LRR" || gameData=="LRL" || gameData=="LLL" || gameData=="LLR") {
        			if(counter==0) {
                		//Robot.Drivesystem.RotateRobot(129);//129=Rotation
            			//Robot.Drivesystem.MoveForwardFeet(20);
                		Robot.Drivesystem.gyroreset();
            		//	Robot.Drivesystem.RotateRobot(-32.25);
            			}
        			else if(counter==1) {
        				Robot.Drivesystem.MoveForwardFeet(11.5);
        			}
            		else if(counter==2) {
            			Robot.Drivesystem.reset();
            		}
            		else if(counter==3) {
            		Robot.Drivesystem.RotateRobot(32.25);
            		}
            		else if(counter==4) {
            			Robot.Drivesystem.gyroreset();
            		}
            		else if(counter==5) {
            			Robot.Drivesystem.MoveForwardFeet(3);//MakeSmalldistancecode
            		}
            		else if(counter==6) {
            			Robot.Drivesystem.reset();
            		}
            		else if(counter==7) {
            			Robot.Grabber.Releasing();
            		}
            		
        			Robot.Liftsystem.LiftHeightNoCounter(500);
        		}
        		if(gameData=="RRR" || gameData=="RRL") {
        			if(counter==0) {
                		//Robot.Drivesystem.RotateRobot(129);//129=Rotation
            			//Robot.Drivesystem.MoveForwardFeet(20);
                		Robot.Drivesystem.gyroreset();
            		//	Robot.Drivesystem.RotateRobot(-32.25);
            			}
        			else if(counter==1) {
        				Robot.Drivesystem.MoveForwardFeet(11);
        			}
            		else if(counter==2) {
            			Robot.Drivesystem.reset();
            		}
            		/*else if(counter==3) {
            		Robot.Drivesystem.MoveForwardFeet(-8);
            		}
            		else if(counter==4) {
            			Robot.Drivesystem.gyroreset();
            		}
            		else if(counter==5) {
            			Robot.Drivesystem.RotateRobot(32.25);//MakeSmalldistancecode
            		}
            		else if(counter==6) {
            			Robot.Drivesystem.gyroreset();
            		}
            		else if(counter==7) {
            			Robot.Grabber.MoveFowardShort()
            		}
            		
        			Robot.Liftsystem.LiftHeightNoCounter(500);*/
        		}
        	}
        	else if(fieldPosition == 2) {
        		if(gameData=="LRR" || gameData=="LRL" || gameData=="LLL" || gameData=="LLR") {
        			if(counter==0) {
                		//Robot.Drivesystem.RotateRobot(129);//129=Rotation
            			//Robot.Drivesystem.MoveForwardFeet(20);
                		Robot.Drivesystem.gyroreset();
            		//	Robot.Drivesystem.RotateRobot(-32.25);
            			}
        			else if(counter==1) {
        				Robot.Drivesystem.MoveForwardShort(1);
        			}
            		else if(counter==2) {
            			Robot.Drivesystem.reset();
            		}
            		else if(counter==3) {
            		Robot.Drivesystem.RotateRobot(-12.54);
            		}
            		else if(counter==4) {
            			Robot.Drivesystem.gyroreset();
            		}
            		else if(counter==5) {
            			Robot.Drivesystem.MoveForwardFeet(6.9);//MakeSmalldistancecode
            		}
            		else if(counter==6) {
            			Robot.Drivesystem.reset();
            		}
            		else if(counter==7) {
            			Robot.Drivesystem.RotateRobot(12.54);
            		}
            		else if(counter==8) {
            			Robot.Drivesystem.gyroreset();
            		}
            		else if(counter==9) {
            			Robot.Drivesystem.MoveForwardFeet(4.3);
            		}
            		else if(counter==10) {
            			Robot.Drivesystem.reset();
            		}
            		else if(counter==11) {
            			Robot.Grabber.Releasing();
            		}
            		else if(counter==12) {
            			Robot.Drivesystem.gyroreset();
            		}
            		
        			Robot.Liftsystem.LiftHeightNoCounter(500);
        		}
        		else if(gameData=="RLL" || gameData=="RLR" || gameData=="RRR" || gameData=="RRL") {
        			if(counter==0) {
                		
                		Robot.Drivesystem.gyroreset();
            		
            			}
        			else if(counter==1) {
        				Robot.Drivesystem.MoveForwardShort(1);
        			}
            		else if(counter==2) {
            			Robot.Drivesystem.reset();
            		}
            		else if(counter==3) {
            		Robot.Drivesystem.RotateRobot(24.8);
            		}
            		else if(counter==4) {
            			Robot.Drivesystem.gyroreset();
            		}
            		else if(counter==5) {
            			Robot.Drivesystem.MoveForwardFeet(8);//MakeSmalldistancecode
            		}
            		else if(counter==6) {
            			Robot.Drivesystem.reset();
            		}
            		else if(counter==7) {
            			Robot.Drivesystem.RotateRobot(-24.8);
            		}
            		else if(counter==8) {
            			Robot.Drivesystem.gyroreset();
            		}
            		else if(counter==9) {
            			Robot.Drivesystem.MoveForwardShort(1);
            		}
            		else if(counter==10) {
            			Robot.Drivesystem.reset();
            		}
            		else if(counter==11) {
            			Robot.Grabber.Releasing();
            		}
            		else if(counter==12) {
            			Robot.Drivesystem.gyroreset();
            		}
            		
        			Robot.Liftsystem.LiftHeightNoCounter(500);
        		}
        	}
        	
        	else if(fieldPosition == 3) {
        		if(gameData=="RLL" || gameData=="RLR" || gameData=="RRL" || gameData=="RRR" ) {
        			if(counter==0) {
                		//Robot.Drivesystem.RotateRobot(129);//129=Rotation
            			//Robot.Drivesystem.MoveForwardFeet(20);
                		Robot.Drivesystem.gyroreset();
            		//	Robot.Drivesystem.RotateRobot(-32.25);
            			}
        			else if(counter==1) {
        				Robot.Drivesystem.MoveForwardFeet(11.5);
        			}
            		else if(counter==2) {
            			Robot.Drivesystem.reset();
            		}
            		else if(counter==3) {
            		Robot.Drivesystem.RotateRobot(-32.25);
            		}
            		else if(counter==4) {
            			Robot.Drivesystem.gyroreset();
            		}
            		else if(counter==5) {
            			Robot.Drivesystem.MoveForwardFeet(3);//MakeSmalldistancecode
            		}
            		else if(counter==6) {
            			Robot.Drivesystem.reset();
            		}
            		else if(counter==7) {
            			Robot.Grabber.Releasing();
            		}
            		
        			Robot.Liftsystem.SetLiftHeight(500);
        		}
        		if(gameData=="LRR" || gameData=="LRL") {
        			if(counter==0) {
                		//Robot.Drivesystem.RotateRobot(129);//129=Rotation
            			//Robot.Drivesystem.MoveForwardFeet(20);
                		Robot.Drivesystem.gyroreset();
            		//	Robot.Drivesystem.RotateRobot(-32.25);
            			}
        			else if(counter==1) {
        				Robot.Drivesystem.MoveForwardFeet(22);
        			}
            		else if(counter==2) {
            			Robot.Drivesystem.reset();
            		}
            		else if(counter==3) {
            		Robot.Drivesystem.RotateRobot(-32.25);
            		}
            		else if(counter==4) {
            			Robot.Drivesystem.gyroreset();
            		}
            		else if(counter==5) {
            			Robot.Drivesystem.MoveForwardFeet(3);//MakeSmalldistancecode
            		}
            		else if(counter==6) {
            			Robot.Drivesystem.reset();
            		}
            		else if(counter==7) {
            			Robot.Grabber.Releasing();
            		}
            		
        			Robot.Liftsystem.LiftTop();
        		}
        		if(gameData=="LLL" || gameData=="LLR") {
        			if(counter==0) {
                		//Robot.Drivesystem.RotateRobot(129);//129=Rotation
            			//Robot.Drivesystem.MoveForwardFeet(20);
                		Robot.Drivesystem.gyroreset();
            		//	Robot.Drivesystem.RotateRobot(-32.25);
            			}
        			else if(counter==1) {
        				Robot.Drivesystem.MoveForwardFeet(11.5);
        			}
            		else if(counter==2) {
            			Robot.Drivesystem.reset();
            		}
            		/*else if(counter==3) {
            		Robot.Drivesystem.RotateRobot(32.25);
            		}
            		else if(counter==4) {
            			Robot.Drivesystem.gyroreset();
            		}
            		else if(counter==5) {
            			Robot.Drivesystem.MoveForwardFeet(3);//MakeSmalldistancecode
            		}
            		else if(counter==6) {
            			Robot.Drivesystem.reset();
            		}
            		else if(counter==7) {
            			Robot.Grabber.Releasing();
            		}
            		
        			Robot.Liftsystem.LiftHeightNoCounter(500);*/
        		}
        	}

        	
        }
    	
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

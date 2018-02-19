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
    		Robot.Grabber.Stop();
    		gameSetup2=true;
    	}
    	
    	
    	
    /*	if(counter==0) {
    		//Robot.Drivesystem.RotateRobot(129);//129=Rotation
			Robot.Drivesystem.MoveForwardFeet(20);
    		//Robot.Liftsystem.SetLiftHeight(435);
    		//Robot.Liftsystem.SetLiftHeight(820);
			}
    	else if(counter==1) {
    		Robot.Drivesystem.reset();
    	}
    	else if(counter==2) {
    		Robot.Drivesystem.RotateRobot(64.5);
    	}
    	
    	else if (counter==3) {
    		Robot.Drivesystem.gyroreset();
    	}
    	else if(counter==4) {
    		Robot.Drivesystem.MoveForwardFeet(10);
    		//Robot.Liftsystem.SetLiftHeight(820);
    	}
    	else if(counter==5) {
    		Robot.Drivesystem.reset();
    	}
    	else if(counter==6) {
    		Robot.Drivesystem.RotateRobot(64.5);
    	}
    	
    	/*switch (gameData) {
    	case "RRR": case "RRL":;
    		
    		
    	}*/
    	
		//Way for setting up an autonomous command chain, can't use two drive train functions at the same time, but can use seperate systems together.
		
    	//145 ticks of the lift encoder is one rotation of the axle
    	//The autonomous code is currently coded out by the conditional never being met. To activate it use the variable gameSetup instead of false
 /*   if(gameSetup2==true) {	
    	
    	if(gameData=="RRR" || gameData=="RRL"){
    		if(fieldPosition == 1) {
    			
    		} 
    		else if(fieldPosition == 2) {
    			
    		}
    		else if(fieldPosition == 3) {
    			
    		}
    	}
    	
    	else if(gameData=="RLL" || gameData=="RLR"){
    		if(fieldPosition == 1) {
    			
    		} 
    		else if(fieldPosition == 2) {
    			
    		}
    		else if(fieldPosition == 3) {
    			
    		}
    	}

    	else if(gameData=="LLL" || gameData=="LLR"){
    		
    		if(fieldPosition == 1) {
    			/*if(counter==1) {
    				Robot.Drivesystem.MoveForwardFeet(24.5);
    			}
    			else if(counter==2) {
    				Robot.Drivesystem.RotateRobot(90);//Positive Values are clockwise
    			}
    			else if(counter==3 || counter==4) {
    				Robot.Drivesystem.fowardTillSwitch();
    				Robot.Liftsystem.SetLiftHeight(6);
    			}
    			else if(counter==5) {
    				Robot.Grabber.Releasing();
    			}
    			else if(counter==6) {
    				Robot.Drivesystem.MoveForwardFeet(-.5);
    			}
    			else if(counter==7 || counter==8) {
    				Robot.Liftsystem.LiftBottom();
    				Robot.Drivesystem.RotateRobot(90);
    			}
    			else if(counter==9) {
    				Robot.Drivesystem.MoveForwardFeet(17);
    			}
    			else if(counter==10) {
    				
    			}
    			else if(counter==11) {
    				
    				
    			}
    			else if(counter==12) {
	
    				
    					
    			}
    			
    		} 
    		else if(fieldPosition == 2) {
    			
    		}
    		else if(fieldPosition == 3) {
    			
    		}
		
    	}

    	
    	else if(gameData=="LRR" || gameData=="LRL"){
    		if(fieldPosition == 1) {
    			
    		} 
    		else if(fieldPosition == 2) {
    			
    		}
    		else if(fieldPosition == 3) {
    			
    		}
    	}

    	
    }
    	*/
    	
    	
    
    	
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

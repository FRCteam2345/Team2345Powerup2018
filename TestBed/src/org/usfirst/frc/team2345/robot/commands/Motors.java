package org.usfirst.frc.team2345.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team2345.robot.OI;
import org.usfirst.frc.team2345.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
/**
 *
 */
public class Motors extends Command {
	
	VictorSP Grabber1 = RobotMap.Grabber1;
	VictorSP Grabber2 = RobotMap.Grabber2;
	Joystick Joy = OI.Joy;
	WPI_TalonSRX TestCim = RobotMap.TestCim;
	Relay TestPG = RobotMap.TestPG;
    public Motors() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Joy.getRawButton(2)==true)
    	{
    		Grabber1.set(.5);
    		Grabber2.set(-.5);
    	}
    	else if(Joy.getRawButton(3)==true)
    	{
    		Grabber1.set(1);
    		Grabber2.set(1);
    	}
    	else
    	{
    		Grabber1.set(0);
    		Grabber2.set(0);
    	}
    	
    	
    	TestCim.set(Joy.getY());
    	if(Joy.getRawButton(1)==true)
    	{
    		TestPG.set(Relay.Value.kForward);
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

package org.usfirst.frc.team2345.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2345.robot.OI;
import org.usfirst.frc.team2345.robot.Robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 *
 */
public class TestGrabbingCommand extends Command {
	Joystick Stick = OI.Stick;
	Joystick Schtick = OI.Schtick;
	JoystickButton In = OI.In;
	JoystickButton Out = OI.Out;
    public TestGrabbingCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kGrabber);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Stick.getRawButton(2)==true) {
    		Robot.kGrabber.In();
    	}
    	if(Stick.getRawButton(3)==true) {
    		Robot.kGrabber.Out();
    	}
    	if(Schtick.getRawButton(2)==true) {
    		Robot.kGrabber.In();
    	}
    	if(Schtick.getRawButton(3)==true) {
        		Robot.kGrabber.In();
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

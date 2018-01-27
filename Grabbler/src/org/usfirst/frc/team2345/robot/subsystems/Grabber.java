package org.usfirst.frc.team2345.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2345.robot.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import org.usfirst.frc.team2345.robot.commands.TestGrabbingCommand;
 
public class Grabber extends Subsystem {
	Relay Spike1 = RobotMap.Spike1;
	Relay Spike2 = RobotMap.Spike2;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void Out() {
		Spike1.set(Relay.Value.kForward);
		Spike2.set(Relay.Value.kForward);
	}
	public void In() {
		Spike1.set(Relay.Value.kReverse);
		Spike2.set(Relay.Value.kReverse);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TestGrabbingCommand());
    }
}


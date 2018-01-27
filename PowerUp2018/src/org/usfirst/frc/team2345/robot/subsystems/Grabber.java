package org.usfirst.frc.team2345.robot.subsystems;

import org.usfirst.frc.team2345.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {
	public static VictorSP Grabber1 = RobotMap.Grabber1;
	public static VictorSP Grabber2 = RobotMap.Grabber2;
	public static DigitalInput SwitchGrabber = RobotMap.SwitchGrabber;
	public static DigitalInput SwitchGrabberDeployed = RobotMap.SwitchGrabberDeployed;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
public void Setup(){
	if(SwitchGrabberDeployed.get()==false){
		
	}
	else{
		
	}
}

public void Grabbing(){
	if(SwitchGrabber.get()==false){
		Grabber1.set(1);
		Grabber2.set(1);
	}
	else{
		Grabber1.set(0);
		Grabber2.set(0);
	}
	
}

public void Releasing(){
	if(SwitchGrabber.get()==true){
		Grabber1.set(-1);
		Grabber2.set(-1);
	}
	else{
		Grabber1.set(0);
		Grabber2.set(0);
	}
	
}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

package org.usfirst.frc.team2345.robot.subsystems;

import org.usfirst.frc.team2345.robot.Robot;
import org.usfirst.frc.team2345.robot.RobotMap;
import org.usfirst.frc.team2345.robot.commands.Autonomous;
import org.usfirst.frc.team2345.robot.commands.LiftControlJoy;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Grabber extends Subsystem {
	public static VictorSP Grabber1 = RobotMap.Grabber1;
	public static VictorSP Grabber2 = RobotMap.Grabber2;
	public static DigitalInput bottomSwitch = RobotMap.switchLiftBottom;
	
//	public static VictorSP Actuator = RobotMap.Actuator;
	//public static DigitalInput HallEffect1 = RobotMap.HallEffect1;
	//public static DigitalInput HallEffect2 = RobotMap.HallEffect2;
	//public static Counter HallEffectC = RobotMap.HallEffectC;
	
	public static DigitalInput SwitchGrabber = RobotMap.SwitchGrabber;
	
	
	public static double PotentiometerVoltage;
	public static int autoTimer;
	public static int counter;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	



public void Grabbing(){
	Grabber1.set(-.3);
	Grabber2.set(.3);
}

public void angleGrabbing(){
	Grabber1.set(-.6);
	Grabber2.set(-.6);
}

public void Stop() {
	Grabber1.set(0);
	Grabber2.set(0);
}


public void Releasing(){
		Grabber1.set(1);
		Grabber2.set(-1);
}

public void AutoReleasing(){
	if(autoTimer<30) {
		Grabber1.set(1);
		Grabber2.set(-1);	
		autoTimer+=1;
	}
	else {
		Grabber1.set(0);
		Grabber2.set(0);
		counter+=1;
	}
	
}


public void ActuatorOut() {
	// Actuator will Extend
//	Actuator.set(.3);
	
	
}

public void AutonomousGrabbing() {
	Grabber1.set(-.6);
	Grabber2.set(-.6);
}

public void Grabbersoff() {
	Grabber1.set(0);
	Grabber2.set(0);
}

/*public void ActuatorIn() {
	// Actuator will retract
	Actuator.set(-.3);
	 if(HallEffect1.get()==false) {
		 Actuator.set(0);
	 }
	
	
}*/

public void JoystickGrabberControl(Joystick stick) {
	if(stick.getRawButton(6)==true) {
		Releasing();
	}
	else if(stick.getRawButton(5)==true) {
		Grabbing();
	}
	else if(stick.getRawButton(3)==true) {
		angleGrabbing();
		//ActuatorPushing();
	}
	/*else if(stick.getRawButton(5)==true) {
		//angleGrabbing();
		ActuatorIn();
	}*/
	
	
	else {
	//	Actuator.set(0);
		Grabber1.set(0);
		Grabber2.set(0);
		
		
	}
	//SmartDashboard.putBoolean("Halleffect1",(boolean) HallEffect1.get());
	//SmartDashboard.putBoolean("Halleffect2",(boolean) HallEffect2.get());
}


    public void initDefaultCommand() {
    	setDefaultCommand(new LiftControlJoy());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


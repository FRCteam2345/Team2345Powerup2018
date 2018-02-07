package org.usfirst.frc.team2345.robot.subsystems;

import org.usfirst.frc.team2345.robot.RobotMap;
import org.usfirst.frc.team2345.robot.commands.LiftControlJoy;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Grabber extends Subsystem {
	public static VictorSP Grabber1 = RobotMap.Grabber1;
	public static VictorSP Grabber2 = RobotMap.Grabber2;
	public static VictorSP ViagraMotor = RobotMap.ViagraMotor;
	
	public static VictorSP Actuator = RobotMap.Actuator;
	public static AnalogInput Actuatorometer = RobotMap.Actuatorometer;
	
	public static DigitalInput SwitchGrabber = RobotMap.SwitchGrabber;
	public static DigitalInput SwitchGrabberDeployed = RobotMap.SwitchGrabberDeployed;
	public static DigitalInput SwitchGrabberIn = RobotMap.switchGrabberIn;
	public static double PotentiometerVoltage;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
public void Viagra(){
	if(SwitchGrabberDeployed.get()==false){
		ViagraMotor.set(.2);
	}
	else{
		
		ViagraMotor.set(0);
	}
}

public void Flaccidity(){
	if(SwitchGrabberIn.get()==false){
		ViagraMotor.set(-.2);
	}
	else{
		ViagraMotor.set(0);
	}
}


public void ActuatorGrabbing() {
	PotentiometerVoltage=Actuatorometer.getAverageVoltage()*10;
	Actuator.set(.5);
	
	if(PotentiometerVoltage>4) {
		Actuator.set(0);
	}
	SmartDashboard.putNumber("Potentiometer",(double) PotentiometerVoltage);
}

public void ActuatorPushing() {
	PotentiometerVoltage=Actuatorometer.getAverageVoltage()*10;
	Actuator.set(-.5);
	
	if( PotentiometerVoltage<.1) {
		Actuator.set(0);
	}
	SmartDashboard.putNumber("Potentiometer",(double) PotentiometerVoltage);
}

public void Grabbing(){
	Grabber1.set(.3);
	Grabber2.set(-.6);
}

public void angleGrabbing(){
	Grabber1.set(.6);
	Grabber2.set(.6);
}


public void Releasing(){
		Grabber1.set(-1);
		Grabber2.set(1);
}

public void JoystickGrabberControl(Joystick stick) {
	if(stick.getRawButton(6)==true) {
		Releasing();
	}
	else if(stick.getRawButton(5)==true) {
		Grabbing();
	}
	else if(stick.getRawButton(3)==true) {
		//angleGrabbing();
		ActuatorPushing();
	}
	else if(stick.getRawButton(4)==true) {
		ActuatorGrabbing();
	}
	else {
		Actuator.set(0);
		Grabber1.set(0);
		Grabber2.set(0);
		SmartDashboard.putNumber("Potentiometer666",(double) Actuatorometer.getVoltage());
	}
}


    public void initDefaultCommand() {
    	setDefaultCommand(new LiftControlJoy());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


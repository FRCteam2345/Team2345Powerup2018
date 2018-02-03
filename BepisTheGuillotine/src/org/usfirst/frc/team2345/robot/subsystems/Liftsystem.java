package org.usfirst.frc.team2345.robot.subsystems;

import org.usfirst.frc.team2345.robot.RobotMap;
import org.usfirst.frc.team2345.robot.commands.LiftControlJoy;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 */
public class Liftsystem extends Subsystem {
	public static WPI_TalonSRX lifterMotor1 = RobotMap.lifterMotor1;
	public static WPI_TalonSRX lifterMotor2 = RobotMap.lifterMotor2;
	public static DigitalInput liftSwitchBottom = RobotMap.switchLiftBottom;
	public static DigitalInput liftSwitchTop = RobotMap.switchLiftTop;
	public static Encoder liftEncoder = RobotMap.liftEncoder;
	public static Boolean buttonBoolean = false;
	public static Boolean logicBoolean = false;
	public static Double heightdelta;
	public static Double heightMath;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void Brake() {
		lifterMotor1.setNeutralMode(NeutralMode.Brake);
		lifterMotor2.setNeutralMode(NeutralMode.Brake);
	}

	public void Coast() {
		lifterMotor1.setNeutralMode(NeutralMode.Coast);
		lifterMotor2.setNeutralMode(NeutralMode.Coast);
		
	}
	
	
	
public void SetLiftHeight(double height) {
	double liftheight = liftEncoder.get();
	
	
	
	
	/*if(liftheight<height-30){
		lifterMotor1.set(.3);
		lifterMotor2.set(.3);
		Coast();
	}
	
	else if(liftheight<height-20) {
		lifterMotor1.set(.15);
		lifterMotor2.set(.15);
		Coast();
	}
	else if(liftheight<height-10) {
		lifterMotor1.set(.075);
		lifterMotor2.set(.075);
		Coast();
	}
	
	else if(liftheight>height+30) {
		lifterMotor1.set(-.3);
		lifterMotor2.set(-.3);
		Coast();
	}
	
	else if(liftheight<height+20) {
		lifterMotor1.set(-.15);
		lifterMotor2.set(-.15);
		Coast();
	}
	else if(liftheight<height+10) {
		lifterMotor1.set(-.075);
		lifterMotor2.set(-.075);
		Coast();
	}
	
	else {
		lifterMotor1.set(0);
		lifterMotor2.set(0);
		Brake();
	}*/
	heightdelta = height-liftheight;
	heightMath=heightdelta/50;
	if(heightMath>1) {
		heightMath=1.;
	}
	heightMath=heightMath*.3;
	
	lifterMotor1.set(heightMath);
	lifterMotor2.set(heightMath);
	
	if(heightdelta<=5 && heightdelta>=-5) {
		lifterMotor1.set(0);
		lifterMotor2.set(0);
		Brake();
	}
	else {
		Coast();
	}
	
	if(liftSwitchBottom.get()==false) {
		lifterMotor1.set(0);
		lifterMotor2.set(0);
	}
	else if(liftSwitchTop.get()==false) {
		lifterMotor1.set(0);
		lifterMotor2.set(0);
	}
		
}

public void JoystickLiftControl(Joystick stick) {
	double liftheight = liftEncoder.get();
	if(stick.getRawAxis(5)>.05 || stick.getRawAxis(5)<-.05) {
		lifterMotor1.set(-stick.getRawAxis(5)*.5);
		lifterMotor2.set(-stick.getRawAxis(5)*.5);
		logicBoolean=false;
	}
	
	
	if(liftSwitchBottom.get()==false) {
		lifterMotor1.set(0);
		lifterMotor2.set(0);
	}
	else if(liftSwitchTop.get()==false) {
		lifterMotor1.set(0);
		lifterMotor2.set(0);
	}
	
	//Brake toggle code for lift
	if(stick.getRawButton(2)==false) {
		buttonBoolean=true;
		
	}
	
	else if(buttonBoolean==true) {
		
		if(logicBoolean==false) {
			
			logicBoolean=true;
		}
		else {
			
			logicBoolean=false;
		}	
		
		buttonBoolean=false;
	}
	
	
	if(logicBoolean==false) {
		SmartDashboard.putBoolean("Brake", false);
		Coast();
	}
	else {
		SmartDashboard.putBoolean("Brake", true);
		lifterMotor1.set(0);
		lifterMotor2.set(0);
		Brake();
	}
	
	
	
	SmartDashboard.putNumber("LiftEncoder",(int) liftheight);
}



    public void initDefaultCommand() {
    	setDefaultCommand(new LiftControlJoy());
    }
}


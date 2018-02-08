package org.usfirst.frc.team2345.robot.subsystems;

import org.usfirst.frc.team2345.robot.RobotMap;
import org.usfirst.frc.team2345.robot.commands.Autonomous;
import org.usfirst.frc.team2345.robot.commands.LiftControlJoy;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
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
	public static int counter = Autonomous.counter;
	
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
		counter += 1;
		Brake();
	}
	else {
		Coast();
	}
	

}

public void LiftTop() {
	if(liftSwitchTop.get()==true) {
		lifterMotor1.set(.5);
		lifterMotor2.set(.5);
		Coast();
	}
	else {
		counter += 1;
		lifterMotor1.set(0);
		lifterMotor2.set(0);
		Brake();
	}
	
}

public void LiftBottom() {
	if(liftSwitchBottom.get()==true) {
		lifterMotor1.set(-.5);
		lifterMotor2.set(-.5);
		Coast();
	}
	else {
		counter += 1;
		lifterMotor1.set(0);
		lifterMotor2.set(0);
		liftEncoder.reset();
		Brake();
	}
	
}

public void JoystickLiftControl(Joystick stick) {
	
	
	
	double liftheight = liftEncoder.get();
	
	if(stick.getRawAxis(5)>.1 || stick.getRawAxis(5)<-.1) {
		//lifterMotor1.set(-stick.getRawAxis(5)*.4);
		//lifterMotor2.set(-stick.getRawAxis(5)*.4);
		lifterMotor1.set(stick.getRawAxis(5)*Math.sin((Math.abs(stick.getRawAxis(5)*1.57)*.35)));
		lifterMotor2.set(stick.getRawAxis(5)*Math.sin((Math.abs(stick.getRawAxis(5)*1.57)*.35)));
		logicBoolean=false;
	}
	else {
		logicBoolean=true;
	}
	
	
	if(liftSwitchBottom.get()==false) {
		liftEncoder.reset();
	}
	
	
	//Brake toggle code for lift
	if(stick.getRawButton(2)==false) {
		buttonBoolean=true;
		
	}
	//This right here is a complicated way to turn the B button of the controller into a toggle;
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


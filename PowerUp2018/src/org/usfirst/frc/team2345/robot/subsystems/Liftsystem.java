package org.usfirst.frc.team2345.robot.subsystems;

import org.usfirst.frc.team2345.robot.RobotMap;
import org.usfirst.frc.team2345.robot.commands.LiftControlJoy;
import org.usfirst.frc.team2345.robot.commands.TankDriveWithJoy;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Liftsystem extends Subsystem {
	public static WPI_TalonSRX lifterMotor1 = RobotMap.lifterMotor1;
	public static WPI_TalonSRX lifterMotor2 = RobotMap.lifterMotor2;
	public static DigitalInput liftSwitchBottom = RobotMap.switchLiftBottom;
	public static DigitalInput liftSwitchTop = RobotMap.switchLiftTop;
	public static Encoder liftEncoder = RobotMap.liftEncoder;

public void SetLiftHeight(double height) {
	double liftheight = liftEncoder.get();
	if(liftheight<height-.1){
		lifterMotor1.set(.3);
		lifterMotor2.set(.3);
	}
	else if(liftheight>height+.1) {
		lifterMotor1.set(-.3);
		lifterMotor2.set(-.3);
	}
	else {
		lifterMotor1.set(0);
		lifterMotor2.set(0);
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
	
	lifterMotor1.set(stick.getX()*.5);
	lifterMotor2.set(stick.getX()*.5);
	
	if(liftSwitchBottom.get()==false) {
		lifterMotor1.set(0);
		lifterMotor2.set(0);
	}
	else if(liftSwitchTop.get()==false) {
		lifterMotor1.set(0);
		lifterMotor2.set(0);
	}
	
	
}


    public void initDefaultCommand() {
    	setDefaultCommand(new LiftControlJoy());
    }
}


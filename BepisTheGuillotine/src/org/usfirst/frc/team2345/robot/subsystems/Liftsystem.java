package org.usfirst.frc.team2345.robot.subsystems;

import org.usfirst.frc.team2345.robot.Robot;
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
	public static WPI_TalonSRX ClimbingMotor = RobotMap.ClimbingMotor;
	public static DigitalInput liftSwitchBottom = RobotMap.switchLiftBottom;
	public static DigitalInput liftSwitchTop = RobotMap.switchLiftTop;
	public static VictorSP TiltMotor = RobotMap.TiltMotor;
	public static DigitalInput SwitchGrabberDeployed = RobotMap.SwitchGrabberDeployed;
	
	public static Encoder liftEncoder = RobotMap.liftEncoder;
	public static Boolean buttonBoolean = false;
	public static Boolean logicBoolean = false;
	public static Double heightdelta;
	public static Double heightMath;
	public static Boolean gameSetup = false;
	public static int counter;
	public static int AutoCounter;
	
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
	
	public void Tilt(){
		if(AutoCounter<20){
			TiltMotor.set(-1);
			AutoCounter+=1;
			SmartDashboard.putNumber("AutoCounter",(int) AutoCounter);
		}
		else{
			gameSetup = true;
			TiltMotor.set(0);
		}
	}
	

	
	
public void SetLiftHeight(double height) {
	double liftheight = liftEncoder.get();
	

	heightdelta = height-liftheight;
	heightMath=heightdelta/50;
	if(heightMath>1) {
		heightMath=1.;
	}
	if(heightMath<-1) {
		heightMath=-1.;
	}
	
	if(heightMath<0) {
		lifterMotor1.set(heightMath*.18);
		lifterMotor2.set(heightMath*.18);
		
		ClimbingMotor.set(heightMath*.75);
	}
	else if(heightMath>0) {
		lifterMotor1.set(heightMath*.33);
		lifterMotor2.set(heightMath*.33);
		
		ClimbingMotor.set(heightMath*.73);
	}
	
	

	
	
	
	
	if(heightdelta<=5 && heightdelta>=-5) {
		lifterMotor1.set(0);
		lifterMotor2.set(0);
		
		ClimbingMotor.set(0);
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
	//SmartDashboard.putBoolean("LiftBottom", true);
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

public void Climbing() {
	ClimbingMotor.set(-1);
}

public void AntiClimbing() {
	ClimbingMotor.set(1);
}

public void JoystickLiftControl(Joystick stick) {
	
	
	
	double liftheight = liftEncoder.get();
	
	if(stick.getRawAxis(5)<-.3) {
		//lifterMotor1.set(-stick.getRawAxis(5)*.4);
		//lifterMotor2.set(-stick.getRawAxis(5)*.4);
		lifterMotor1.set(-stick.getRawAxis(5)*Math.sin((Math.abs(stick.getRawAxis(5)*1.57)*.35)));
		lifterMotor2.set(-stick.getRawAxis(5)*Math.sin((Math.abs(stick.getRawAxis(5)*1.57)*.35)));
		//TiltMotor.set(stick.getRawAxis(5)*Math.sin((Math.abs(stick.getRawAxis(5)*1.57)))*.9);
		ClimbingMotor.set(-stick.getRawAxis(5)*Math.sin((Math.abs(stick.getRawAxis(5)*1.57)))*.75);
		/*lifterMotor1.set(-stick.getRawAxis(5)*.35);
		lifterMotor2.set(-stick.getRawAxis(5)*.35);
		
		
		ClimbingMotor.set(-stick.getRawAxis(5)*.73);/*
		
		
		/*if(stick.getRawAxis(5)<0) {
			TiltMotor.set(stick.getRawAxis(5));
		}
		else {
			TiltMotor.set(stick.getRawAxis(5)*.9);
		}*/
		
		
		//TiltMotor.set();
		logicBoolean=false;
	}
	else if(stick.getRawAxis(5)>.3) {
		lifterMotor1.set(-stick.getRawAxis(5)*Math.sin((Math.abs(stick.getRawAxis(5)*1.57)*.18)));
		lifterMotor2.set(-stick.getRawAxis(5)*Math.sin((Math.abs(stick.getRawAxis(5)*1.57)*.18)));
		//TiltMotor.set(stick.getRawAxis(5)*Math.sin((Math.abs(stick.getRawAxis(5)*1.57)))*.9);
		ClimbingMotor.set(-stick.getRawAxis(5)*Math.sin((Math.abs(stick.getRawAxis(5)*1.57)))*.75);
		
		
		logicBoolean=false;
	}
	
	else {
		logicBoolean=true;
	}
	
	
	if(liftSwitchBottom.get()==false) {
		liftEncoder.reset();
	}
	
	
	if(stick.getRawButton(9)==true) {
		TiltMotor.set(.5);//Pulling it in
	}
	
	else if(stick.getRawButton(10)==true) {
		TiltMotor.set(-.8);//Releasing, going up
	}
	else {
		TiltMotor.set(0);
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
	
	if(stick.getRawButton(4)==true) {
		Climbing();
		
	}
	else if(stick.getRawButton(1)==true) {
		AntiClimbing();//A pulling in 
		
	}
	else if (stick.getRawAxis(5)<.3 && stick.getRawAxis(5)>-.3) {
		ClimbingMotor.set(0);
	}
	
	if(liftSwitchBottom.get()==false && -stick.getRawAxis(5)<0) {
		lifterMotor1.set(0);
		lifterMotor2.set(0);
		
		ClimbingMotor.set(0);
		Brake();
	}
	else if(liftSwitchTop.get()==false && -stick.getRawAxis(5)>0) {
		lifterMotor1.set(0);
		lifterMotor2.set(0);
		
		ClimbingMotor.set(0);
		Brake();
	}
	
	
	if(logicBoolean==false) {
		SmartDashboard.putBoolean("Brake", false);
		Coast();
	}
	else {
		SmartDashboard.putBoolean("Brake", true);
		lifterMotor1.set(0);
		lifterMotor2.set(0);
		//TiltMotor.set(0);
		//ClimbingMotor.set(0);
		Brake();
	}
	
	SmartDashboard.putBoolean("BottomSwitch",(Boolean) liftSwitchBottom.get());
	SmartDashboard.putBoolean("GrabberSwitch",(Boolean) SwitchGrabberDeployed.get());
	SmartDashboard.putNumber("LiftValue",(double) stick.getRawAxis(5) );
	SmartDashboard.putNumber("LiftEncoder",(int) liftheight);
}



    public void initDefaultCommand() {
    	setDefaultCommand(new LiftControlJoy());
    }
}


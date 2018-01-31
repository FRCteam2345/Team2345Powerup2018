package org.usfirst.frc.team2345.robot.subsystems;

import org.usfirst.frc.team2345.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
 */
public class Liftsystem extends Subsystem {
	public static WPI_TalonSRX lifterMotor1 = RobotMap.lifterMotor1;
	public static WPI_TalonSRX lifterMotor2 = RobotMap.lifterMotor2;
	public static DigitalInput liftSwitchBottom = RobotMap.switchLiftBottom;
	public static DigitalInput liftSwitchTop = RobotMap.switchLiftTop;
	public static Encoder liftEncoder = RobotMap.liftEncoder;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
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


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


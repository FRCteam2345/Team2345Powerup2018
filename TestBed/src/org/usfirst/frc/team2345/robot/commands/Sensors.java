package org.usfirst.frc.team2345.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWM;

import org.usfirst.frc.team2345.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
/**
 *
 */
public class Sensors extends Command {
	Encoder Encoder = RobotMap.Encoder;
	AnalogInput Ultrasonic2 = RobotMap.Ultrasonic2;
	AnalogInput Ultrasonic = RobotMap.UltraSonic;
	ADXRS450_Gyro Gyro = RobotMap.Gyro;
	DigitalInput Switch2 = RobotMap.Switch2;
	DigitalInput Switch1 = RobotMap.Switch1;
	DigitalInput Switch3 = RobotMap.Switch3;
	DigitalInput HallEffect = RobotMap.HallEffect;
	AnalogInput Diode = RobotMap.Diode;
	double Ultrasonic2value;
	double Ultrasonic22value;
	double UltrasonicValue;
	double Diodee;
    public Sensors() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double Ultrasonic2value = Ultrasonic2.getVoltage()*1000;
    	double UltrasonicValue = Ultrasonic.getVoltage();
    	double Ultrasonic22value = (Ultrasonic2value/9.8);
    	Diodee=Diode.getVoltage();
    	UltrasonicValue = UltrasonicValue*25;
    	UltrasonicValue = UltrasonicValue-1.6;
    	
    	SmartDashboard.putNumber("PhotoDiode",(double) Diodee);
    	SmartDashboard.putBoolean("HalleffectSnesor",(boolean) HallEffect.get());
    	SmartDashboard.putBoolean("Switch",(boolean) Switch1.get());
    	SmartDashboard.putBoolean("Switch2",(boolean) Switch2.get());
    	SmartDashboard.putBoolean("Switch3",(boolean) Switch3.get());
    	SmartDashboard.putNumber("UltrasonicValue",(double) UltrasonicValue);
    	SmartDashboard.putNumber("Encoder",(double) Encoder.get());
    	SmartDashboard.putNumber("Gyro",(double) Gyro.getAngle());
    	SmartDashboard.putNumber("Ultrasonic22",(double) Ultrasonic22value);
    	SmartDashboard.putNumber("Ultrasonic2",(double) Ultrasonic2value);
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

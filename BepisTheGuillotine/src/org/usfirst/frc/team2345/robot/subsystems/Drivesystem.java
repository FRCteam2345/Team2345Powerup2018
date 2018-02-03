package org.usfirst.frc.team2345.robot.subsystems;

import org.usfirst.frc.team2345.robot.OI;
import org.usfirst.frc.team2345.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team2345.robot.RobotMap;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2345.robot.commands.TankDriveWithJoy;

/**
 *
 */
public class Drivesystem extends Subsystem {
	public static WPI_TalonSRX FrontLeftMotor = RobotMap.Frontleftmotor;
	public static WPI_TalonSRX BackLeftMotor = RobotMap.Backleftmotor;
	public static WPI_TalonSRX FrontRightMotor = RobotMap.Frontrightmotor;
	public static WPI_TalonSRX BackRightMotor = RobotMap.Backrightmotor;
	public static Encoder RightSideEncoder = RobotMap.RightSideEncoder;
	public static Encoder LeftSideEncoder = RobotMap.LeftSideEncoder;
	public static double distancemath;
	public static double distancedelta;
	public static double angleDelta;
	public static double angleMath;
	public static ADXRS450_Gyro Gyro = RobotMap.Gyro;
	public static Boolean first = false;
	public static int counter = 0;
	
	public void MoveForwardFeet(double Feet)
	{	
	double deviation = Gyro.getAngle()/360;
	double RightEncoder = RightSideEncoder.get();
	double LeftEncoder = -LeftSideEncoder.get();
	double FeetMoved = ((RightEncoder)/360)*1.57;
	
	distancedelta = Feet-FeetMoved;
	distancemath=distancedelta/3;
	
	if(distancemath>1) {
		distancemath=1.;
	}
	
	distancemath=distancemath*.3;
	
	BackLeftMotor.set(distancemath);
	FrontLeftMotor.set(distancemath);
	BackRightMotor.set(-distancemath);
	FrontRightMotor.set(-distancemath);
	
	if(distancedelta<=.1 && distancedelta>=-.1) {

		BackLeftMotor.set(0);
		FrontLeftMotor.set(0);
		BackRightMotor.set(0);
		FrontRightMotor.set(0);
		
		counter += 1;
		RightSideEncoder.reset();
    	LeftSideEncoder.reset();
	}
	
	
	
	/*	if(FeetMoved<Feet-.5)
		{
			FrontLeftMotor.set(.30);
			BackLeftMotor.set(.30);
			FrontRightMotor.set(-.30);
			BackRightMotor.set(-.30);
		
		}
		else if(FeetMoved<Feet-.25){
			FrontLeftMotor.set(.15);
			BackLeftMotor.set(.15);
			FrontRightMotor.set(-.15);
			BackRightMotor.set(-.15);
		}
		else if(FeetMoved<Feet){
			FrontLeftMotor.set(.1);
			BackLeftMotor.set(.1);
			FrontRightMotor.set(-.1);
			BackRightMotor.set(-.1);
		}
		else{
			FrontLeftMotor.stopMotor();
			BackLeftMotor.stopMotor();
			FrontRightMotor.stopMotor();
			BackRightMotor.stopMotor();
			
			counter += 1;
			RightSideEncoder.reset();
	    	LeftSideEncoder.reset();
			
		}*/
	
		SmartDashboard.putNumber("FeetMoved", (double) FeetMoved);
		
    	
		SmartDashboard.putNumber("Gyro",(double) Gyro.getAngle());
		SmartDashboard.putNumber("RightSideEncoder",(double) RightSideEncoder.get());
		SmartDashboard.putNumber("LeftSideEncoder",(double) LeftSideEncoder.get());
		/*if(deviation < -5 || deviation > 5){
		FrontLeftMotor.set(FrontLeftMotor.get()+.1*deviation);
		BackLeftMotor.set(BackLeftMotor.get()+.1*deviation);
		FrontRightMotor.set(FrontRightMotor.get()+.1*deviation);
		BackRightMotor.set(BackRightMotor.get()+.1*deviation);
	}*/
		
		
		
		
	}
	
	public void RotateRobot(double Angle)
	{
		double AngleRotated = Gyro.getAngle();
		
		angleDelta = Angle-AngleRotated;
		angleMath=distancedelta/45;
		
		if(angleMath>1) {
			angleMath=1.;
		}
		
		angleMath=angleMath*.3;
		
		BackLeftMotor.set(angleMath);
		FrontLeftMotor.set(angleMath);
		BackRightMotor.set(angleMath);
		FrontRightMotor.set(angleMath);
		
		if(angleDelta<=4 && angleDelta>=-4) {

			BackLeftMotor.set(0);
			FrontLeftMotor.set(0);
			BackRightMotor.set(0);
			FrontRightMotor.set(0);
			
			counter += 1;
			Gyro.reset();
			RightSideEncoder.reset();
	    	LeftSideEncoder.reset();
		}
		
	/*	if(AngleRotated>Angle)
    	{
    		FrontLeftMotor.set(.30);
			BackLeftMotor.set(.30);
			FrontRightMotor.set(.30);
			BackRightMotor.set(.30);
    	}
    	else
    	{
    		FrontLeftMotor.stopMotor();
			BackLeftMotor.stopMotor();
			FrontRightMotor.stopMotor();
			BackRightMotor.stopMotor();
			
			counter += 1;
			RightSideEncoder.reset();
	    	LeftSideEncoder.reset();
			Gyro.reset();
    	}
    		*/
	}

	public void RobotDriveJoy(Joystick XboxC)
	{
		double Rightencoder = RightSideEncoder.get();
		double LeftEncoder = -LeftSideEncoder.get();
		double FeetMoved = ((Rightencoder)/360)*1.57;
		
    	SmartDashboard.putNumber("FeetMoved", (double) FeetMoved);
		
    	
		SmartDashboard.putNumber("Gyro",(double) Gyro.getAngle());
		SmartDashboard.putNumber("RightSideEncoder",(double) RightSideEncoder.get());
		SmartDashboard.putNumber("LeftSideEncoder",(double) LeftSideEncoder.get());
		
	
		double forwardBasic = XboxC.getRawAxis(3);
		double backwardBasic= XboxC.getRawAxis(2);
		double turnBasic = -XboxC.getRawAxis(0);
		
		if(turnBasic<.05 && turnBasic>-.05) {
			turnBasic=0;
		}
		
		
		double forward = forwardBasic ;
		double backward = backwardBasic ;
		double turn = turnBasic ;
		//The math.sin function is used to slowly scale the value of the motors to accelerate it better
		/*FrontLeftMotor.set((forward-backward-turn)*Math.sin((forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57));
		BackLeftMotor.set((forward-backward-turn)*Math.sin((forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57));
		FrontRightMotor.set((-forward+backward-turn)*Math.sin((+forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57));
		BackRightMotor.set((-forward+backward-turn)*Math.sin((+forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57));*/
		FrontLeftMotor.setNeutralMode(NeutralMode.Coast);
		
		FrontLeftMotor.set((forward-backward-turn)*Math.sin((forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57)*.35);
		BackLeftMotor.set((forward-backward-turn)*Math.sin((forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57)*.35);
		FrontRightMotor.set((-forward+backward-turn)*Math.sin((+forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57)*.35);
		BackRightMotor.set((-forward+backward-turn)*Math.sin((+forwardBasic+backwardBasic+Math.abs(turnBasic))*1.57)*.35);
		
	
		
		/*FrontLeftMotor.set(forward-backward-turn);
		BackLeftMotor.set(forward-backward-turn);
		FrontRightMotor.set(-forward+backward-turn);
		BackRightMotor.set(-forward+backward-turn);*/
		
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDriveWithJoy());
    }
}

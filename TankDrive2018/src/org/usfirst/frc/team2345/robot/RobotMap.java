/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2345.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static ADXRS450_Gyro Gyro = new ADXRS450_Gyro();
	/*public static CANTalon Frontleftmotor = new CANTalon(0);
	public static CANTalon Backleftmotor = new CANTalon(1);
	public static CANTalon Frontrightmotor = new CANTalon(2);
	public static CANTalon Backrightmotor = new CANTalon(3);*/
	public static WPI_TalonSRX Frontleftmotor = new WPI_TalonSRX(3);
	public static WPI_TalonSRX Backleftmotor = new WPI_TalonSRX(1);
	public static WPI_TalonSRX Frontrightmotor = new WPI_TalonSRX(0);
	public static WPI_TalonSRX Backrightmotor = new WPI_TalonSRX(2);
}

package org.usfirst.frc.team2345.robot;

import org.usfirst.frc.team2345.robot.commands.LiftBottom;
import org.usfirst.frc.team2345.robot.commands.LiftTop;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick XboxC = new Joystick(0);
	
	public OI() {
		JoystickButton Select = new JoystickButton(XboxC,7);
		JoystickButton Start = new JoystickButton(XboxC, 8);
		
		Select.whenPressed(new LiftTop());
		Start.whenPressed(new LiftBottom());
		//SmartDashboard.putBoolean("LiftBottom", false);
		
	}
	
}

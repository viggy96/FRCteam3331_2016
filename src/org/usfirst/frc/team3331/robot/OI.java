package org.usfirst.frc.team3331.robot;

import org.usfirst.frc.team3331.robot.commands.*;
import org.usfirst.frc.team3331.robot.triggers.ArmDownButton;
import org.usfirst.frc.team3331.robot.triggers.ArmUpButton;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	Button a = new JoystickButton(RobotMap.gamepad, 1),
			b = new JoystickButton(RobotMap.gamepad, 2),
			x = new JoystickButton(RobotMap.gamepad, 3),
			y = new JoystickButton(RobotMap.gamepad, 4),
			leftStickButton = new JoystickButton(RobotMap.gamepad, 9),
			leftTrigger = new ArmDownButton(),
			rightTrigger = new ArmUpButton();
	
	public OI() {
		/*
		a.whenPressed(new UnfoldArmCommandGroup());
		b.whenPressed(new FoldArmCommandGroup());
		x.whenPressed(new HookPistonToggleCommand());
		y.whileHeld(new ManualArmFoldCommand());
		leftStickButton.whenPressed(new ManualArmCalibrationCommand());
		leftTrigger.whileHeld(new UpperArmDownCommand());
		rightTrigger.whileHeld(new UpperArmUpCommand());
		*/
		
		a.whileHeld(new LowerArmUpCommand());
		b.whileHeld(new UpperArmUpCommand());;
		x.whileHeld(new LowerArmDownCommand());
		y.whileHeld(new UpperArmUpCommand());;
		
		leftStickButton.whenPressed(new HookPistonToggleCommand());;
	}
}


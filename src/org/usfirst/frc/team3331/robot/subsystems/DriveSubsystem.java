package org.usfirst.frc.team3331.robot.subsystems;

import org.usfirst.frc.team3331.robot.RobotMap;
import org.usfirst.frc.team3331.robot.commands.TeleopDriveCommand;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    private static final int NORMALISE_POW = 2;
    private static final double FILTER_VALUE = 0.5;
    
    private double moveValue, rotateValue, leftValue, rightValue;
    private double oldMoveValue = 0, oldRotateValue = 0, oldLeftValue = 0, oldRightValue = 0;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
       setDefaultCommand(new TeleopDriveCommand());
    }
    
    public void init() {
    	RobotMap.drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
    	RobotMap.drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    	RobotMap.drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
    	RobotMap.drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    	RobotMap.drivetrain.setLeftRightMotorOutputs(0, 0);
    }
    
    public void stopDrive() {
    	RobotMap.drivetrain.tankDrive(0, 0);
    }
    
    public void teleopDrive() {
    	RobotMap.drivetrain.tankDrive(RobotMap.gamepad.getRawAxis(RobotMap.leftStickY), RobotMap.gamepad.getRawAxis(RobotMap.rightStickY));
    	/*
    	// let's try a low pass filter...
    	// capture left/right values
    	leftValue = RobotMap.gamepad.getRawAxis(RobotMap.leftStickY);
    	rightValue = RobotMap.gamepad.getRawAxis(RobotMap.rightStickY);
    	
    	// pass the left/right values through a low pass filter to smooth them out
    	RobotMap.drivetrain.tankDrive(lowPassFilter(leftValue, oldLeftValue), 
    			                      lowPassFilter(rightValue, oldRightValue));
    	
    	// capture left/right values to use in next low pass filtering pass
    	oldLeftValue = leftValue;
    	oldRightValue = rightValue;
    	
    	//*/
    	
    	///*
    	// * 
    	//motor_value = k * joystick_reading + ( 1 - k ) * motor_value; // k is between 0 and 1
    	
    	/*
    	
    	 moveValue = RobotMap.gamepad.getRawAxis(RobotMap.leftStickY);
    	rotateValue = RobotMap.gamepad.getRawAxis(RobotMap.leftStickX);
    	RobotMap.drivetrain.arcadeDrive(lowPassFilter(moveValue, oldMoveValue), lowPassFilter(rotateValue, oldRotateValue));
    	oldMoveValue = moveValue;
    	oldRotateValue = rotateValue; */
    }
    
    public void autoDrive(double leftValue, double rightValue) {
    	RobotMap.drivetrain.tankDrive(leftValue, rightValue);
    }
    
    private double lowPassFilter(double inputValue, double oldValue) {
    	
    	return (oldValue * (1 - FILTER_VALUE) + (FILTER_VALUE + oldValue));

    }
    
    private double[] normaliseAxes() {
    	double left = Math.copySign(Math.pow(RobotMap.gamepad.getRawAxis(RobotMap.leftStickY), NORMALISE_POW),
    			RobotMap.gamepad.getRawAxis(RobotMap.leftStickY));
    	double right = Math.copySign(Math.pow(RobotMap.gamepad.getRawAxis(RobotMap.rightStickY), NORMALISE_POW),
    			RobotMap.gamepad.getRawAxis(RobotMap.rightStickY));
    	
    	double output[] = {left, right};
    	return output;
    }
}


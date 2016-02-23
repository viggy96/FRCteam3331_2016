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
    
    public void teleopDrive() {
    	//double axes[] = normaliseAxes();
    	RobotMap.drivetrain.tankDrive(RobotMap.gamepad.getRawAxis(RobotMap.leftStickY), RobotMap.gamepad.getRawAxis(RobotMap.rightStickY));
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


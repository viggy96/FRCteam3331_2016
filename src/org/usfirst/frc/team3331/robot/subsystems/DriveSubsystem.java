package org.usfirst.frc.team3331.robot.subsystems;

import org.usfirst.frc.team3331.robot.RobotMap;
import org.usfirst.frc.team3331.robot.commands.teleopDriveCommand;

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
       setDefaultCommand(new teleopDriveCommand());
    }
    
    public void init() {
    	RobotMap.drivetrain.setLeftRightMotorOutputs(0, 0);
    	RobotMap.drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
    	RobotMap.drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }
    
    public void teleopDrive() {
    	double axes[] = normaliseAxes();
    	RobotMap.drivetrain.tankDrive(axes[0], axes[1]);
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


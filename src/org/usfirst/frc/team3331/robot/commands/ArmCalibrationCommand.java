package org.usfirst.frc.team3331.robot.commands;

import org.usfirst.frc.team3331.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmCalibrationCommand extends Command {
	boolean position = false;
	final double EPSILON = 0.01;
	
    public ArmCalibrationCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.armSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//dt Robot.armSubsystem.setBottomPiston(position);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
        //dt return Robot.armSubsystem.isLowerArmDown();
    }

    // Called once after isFinished returns true
    protected void end() {
    	//dt Robot.armSubsystem.calibrateArm();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

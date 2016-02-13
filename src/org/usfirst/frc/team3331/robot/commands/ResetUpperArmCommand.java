package org.usfirst.frc.team3331.robot.commands;

import org.usfirst.frc.team3331.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetUpperArmCommand extends Command {
	boolean isLevel = false;

    public ResetUpperArmCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(DEEZNUTZ);
    	requires(Robot.armSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = Robot.armSubsystem.getArmAngle();
    	if (angle < -0.125) Robot.armSubsystem.setTopPiston(DoubleSolenoid.Value.kForward);
    	else if (angle > 0.125) Robot.armSubsystem.setTopPiston(DoubleSolenoid.Value.kReverse);
    	else { 
    		Robot.armSubsystem.lockTopPiston();
    		isLevel = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isLevel;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.armSubsystem.lockTopPiston();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

package org.usfirst.frc.team3331.robot.commands;

import org.usfirst.frc.team3331.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class bottonPistonDown extends Command {
	DoubleSolenoid.Value position = DoubleSolenoid.Value.kReverse;

    public bottonPistonDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.pneumaticSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.pneumaticSubsystem.setBottomPiston(position);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.pneumaticSubsystem.getBottomPiston() == position);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

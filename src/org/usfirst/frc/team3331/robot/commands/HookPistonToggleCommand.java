package org.usfirst.frc.team3331.robot.commands;

import org.usfirst.frc.team3331.robot.Robot;
import org.usfirst.frc.team3331.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HookPistonToggleCommand extends Command {
	DoubleSolenoid.Value position;
	
    public HookPistonToggleCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.armSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (RobotMap.hookState = true) {
    		position = DoubleSolenoid.Value.kReverse;
    		Robot.armSubsystem.setHookPiston(position);
    	}
    	else {
    		position = DoubleSolenoid.Value.kReverse;
    		Robot.armSubsystem.setHookPiston(position);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.armSubsystem.getHookPiston() == position);
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.hookState = !RobotMap.hookState;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

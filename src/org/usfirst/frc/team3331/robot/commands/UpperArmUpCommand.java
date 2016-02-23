package org.usfirst.frc.team3331.robot.commands;

import org.usfirst.frc.team3331.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UpperArmUpCommand extends Command {
	boolean position = true, upperLimit = false;
	
    public UpperArmUpCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.armSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (DriverStation.getInstance().getMatchTime() <= 130 && Robot.armSubsystem.getArmAngle() >= 45) 
    		upperLimit = true;
    	else Robot.armSubsystem.setTopPiston(position);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.armSubsystem.getTopPiston() == position) || upperLimit;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.armSubsystem.lockTopPiston();
    }
}

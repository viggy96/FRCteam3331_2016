package org.usfirst.frc.team3331.robot.commands;

import org.usfirst.frc.team3331.robot.Robot;
import org.usfirst.frc.team3331.robot.RobotMap;
import org.usfirst.frc.team3331.robot.subsystems.ArmSubsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UpperArmLevelCommand extends Command {
	ArmSubsystem.Action action;
	
    public UpperArmLevelCommand(ArmSubsystem.Action action) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.armSubsystem);
    	this.action = action;
    }

    // Called just before this Command runs the first time
    protected void initialize() {	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = Robot.armSubsystem.getArmAngle();
    	if (angle < -0.125) Robot.armSubsystem.setTopPiston(DoubleSolenoid.Value.kForward);
    	else if (angle > 0.125) Robot.armSubsystem.setTopPiston(DoubleSolenoid.Value.kReverse);
    	else Robot.armSubsystem.lockTopPiston();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (action == ArmSubsystem.Action.FOLD) return Robot.armSubsystem.isFolded();
        else return Robot.armSubsystem.isLowerArmUp();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.armSubsystem.lockTopPiston();
    	if (action == ArmSubsystem.Action.FOLD) RobotMap.armFoldState = true;
    	else RobotMap.armFoldState = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

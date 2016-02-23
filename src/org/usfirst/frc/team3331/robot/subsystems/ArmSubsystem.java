package org.usfirst.frc.team3331.robot.subsystems;

import org.usfirst.frc.team3331.robot.RobotMap;
import org.usfirst.frc.team3331.robot.commands.LockArmCommand;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public enum Action {
		FOLD, UNFOLD;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new LockArmCommand());
    }
    
    public void init() {
    	RobotMap.topPistonForward.set(false);
    	RobotMap.topPistonReverse.set(false);
    	RobotMap.bottomPistonForward.set(false);
    	RobotMap.bottomPistonReverse.set(false);
    	RobotMap.hookPiston.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void setBottomPiston(boolean forward) {
    	RobotMap.bottomPistonForward.set(forward);
    	RobotMap.bottomPistonReverse.set(!forward);
    }
    
    public void lockBottomPiston() {
    	RobotMap.bottomPistonForward.set(false);
    	RobotMap.bottomPistonReverse.set(false);
    }
    
    public boolean getBottomPiston() {
    	return RobotMap.bottomPistonForward.get();
    }
    
    public void setTopPiston(boolean forward) {
    	RobotMap.topPistonForward.set(forward);
    	RobotMap.topPistonReverse.set(!forward);
    }
    
    public void lockTopPiston() {
    	RobotMap.topPistonForward.set(false);
    	RobotMap.topPistonReverse.set(false);
    }
    
    public boolean getTopPiston() {
    	return RobotMap.topPistonForward.get();
    }
    
    public void setHookPiston(DoubleSolenoid.Value position) {
    	RobotMap.hookPiston.set(position);
    }
    
    public DoubleSolenoid.Value getHookPiston() {
    	return RobotMap.hookPiston.get();
    }
    
    public boolean isFolded() {
    	return RobotMap.upperArmFoldedSwitch.get();
    }
    
    public boolean isLowerArmUp() {
    	return RobotMap.lowerArmUpSwitch.get();
    }
    
    public boolean isLowerArmDown() {
    	return RobotMap.lowerArmDownSwitch.get();
    }
    
    public void calibrateArm() {
    	RobotMap.gyro.calibrate();
    }
    
    public double getArmAngle() {
    	return RobotMap.gyro.getAngle(); 
    }
}


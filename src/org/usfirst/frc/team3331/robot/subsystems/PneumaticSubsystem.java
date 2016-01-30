package org.usfirst.frc.team3331.robot.subsystems;

import org.usfirst.frc.team3331.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class PneumaticSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void init() {
    	RobotMap.topPiston.set(DoubleSolenoid.Value.kOff);
    	RobotMap.bottomPiston.set(DoubleSolenoid.Value.kOff);
    }
    
    public void setBottomPiston(DoubleSolenoid.Value position) {
    	RobotMap.bottomPiston.set(position);
    }
    
    public DoubleSolenoid.Value getBottomPiston() {
    	return RobotMap.bottomPiston.get();
    }
    
    public void setTopPiston(DoubleSolenoid.Value position) {
    	RobotMap.topPiston.set(position);
    }
    
    public DoubleSolenoid.Value getTopPiston() {
    	return RobotMap.topPiston.get();
    }
}


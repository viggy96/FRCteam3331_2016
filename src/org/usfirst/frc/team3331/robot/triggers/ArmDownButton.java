package org.usfirst.frc.team3331.robot.triggers;

import org.usfirst.frc.team3331.robot.RobotMap;

import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 */
public class ArmDownButton extends Button {
    
    public boolean get() {
        return (!RobotMap.armFoldState && RobotMap.gamepad.getRawButton(5));
    }
    
}

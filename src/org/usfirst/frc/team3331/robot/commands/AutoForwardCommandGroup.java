package org.usfirst.frc.team3331.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoForwardCommandGroup extends CommandGroup {
    
    public  AutoForwardCommandGroup() {
        // addSequential(new ArmCalibrationCommand());
        addSequential(new AutoDriveForwardCommand());
    }
}

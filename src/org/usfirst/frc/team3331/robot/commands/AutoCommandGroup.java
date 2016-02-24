package org.usfirst.frc.team3331.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandGroup extends CommandGroup {
    
    public  AutoCommandGroup() {
        addSequential(new ArmCalibrationCommand());
        addSequential(new AutoDriveForwardCommand());
    }
}

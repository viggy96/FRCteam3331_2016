package org.usfirst.frc.team3331.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoReverseCommandGroup extends CommandGroup {
    
    public  AutoReverseCommandGroup() {
        addSequential(new ArmCalibrationCommand());
        addSequential(new AutoDriveReverseCommand());
    }
}

package org.usfirst.frc.team3331.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team3331.robot.subsystems.ArmSubsystem;

/**
 *
 */
public class FoldArmCommandGroup extends CommandGroup {
    
    public  FoldArmCommandGroup() {
    	addSequential(new ResetUpperArmCommand());
        addParallel(new LowerArmDownCommand());
        addParallel(new UpperArmLevelCommand(ArmSubsystem.Action.FOLD));
    }
}

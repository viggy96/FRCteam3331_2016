package org.usfirst.frc.team3331.robot.commands;

import org.usfirst.frc.team3331.robot.subsystems.ArmSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class UnfoldArmCommandGroup extends CommandGroup {
    
    public  UnfoldArmCommandGroup() {
        addParallel(new LowerArmUpCommand());
        addParallel(new UpperArmLevelCommand(ArmSubsystem.Action.UNFOLD));
    }
}
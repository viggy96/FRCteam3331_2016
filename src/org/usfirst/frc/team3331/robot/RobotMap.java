package org.usfirst.frc.team3331.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final Talon frontLeftMotor = new Talon(0);
    public static final Talon frontRightMotor = new Talon(1);
    public static final Talon rearLeftMotor = new Talon(2);
    public static final Talon rearRightMotor = new Talon(3);
    
    public static final RobotDrive drivetrain = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    
    public static final Joystick gamepad = new Joystick(0);
    public static final int leftStickX = 0;
    public static final int leftStickY = 1;
    public static final int rightStickX = 4;
    public static final int rightStickY = 5;
    
    public static final DoubleSolenoid bottomPiston = new DoubleSolenoid(0, 1);
    public static final DoubleSolenoid topPiston = new DoubleSolenoid(2, 3);
    
    public static final Talon shooterMotorLeft = new Talon(4);
    public static final Talon shooterMotorRight = new Talon(5);
}

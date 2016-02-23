package org.usfirst.frc.team3331.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
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
    
    public static final Solenoid bottomPistonForward = new Solenoid(0);
    public static final Solenoid bottomPistonReverse = new Solenoid(1);
    public static final Solenoid topPistonForward = new Solenoid(2);
    public static final Solenoid topPistonReverse = new Solenoid(3);
    
    public static final DoubleSolenoid hookPiston = new DoubleSolenoid(4, 5);
    
    public static final Talon shooterMotorLeft = new Talon(4);
    public static final Talon shooterMotorRight = new Talon(5);
    
    public static final DigitalInput lowerArmUpSwitch = new DigitalInput(0);
    public static final DigitalInput lowerArmDownSwitch = new DigitalInput(1);
    public static final DigitalInput upperArmFoldedSwitch = new DigitalInput(2);
    public static final ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    
    public static boolean armFoldState = false;
    public static boolean hookState = false;
    
    public static void init() {
    	frontLeftMotor.enableDeadbandElimination(true);
    	frontRightMotor.enableDeadbandElimination(true);
    	rearLeftMotor.enableDeadbandElimination(true);
    	rearRightMotor.enableDeadbandElimination(true);
    }
}

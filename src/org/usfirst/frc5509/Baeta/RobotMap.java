// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5509.Baeta;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.interfaces.Gyro;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveRightDrive;
    public static SpeedController driveLeftDrive;
    public static RobotDrive driveRobotDrive21;
    public static SpeedController weainchWench;
    public static SpeedController ball_MechControl_Mech;
    public static SpeedController ballBox;
    public static Gyro subsystem1Gyro1;
    //public static Compressor pneumaticsCompressor;
    //public static DoubleSolenoid pneumaticsDoubleSolenoid;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveRightDrive = new Talon(0);
        LiveWindow.addActuator("Drive", "Right Drive", (Talon) driveRightDrive);
        
        driveLeftDrive = new Talon(1);
        LiveWindow.addActuator("Drive", "Left Drive", (Talon) driveLeftDrive);
        
        driveRobotDrive21 = new RobotDrive(driveLeftDrive, driveRightDrive);
        
        driveRobotDrive21.setSafetyEnabled(false);
        //driveRobotDrive21.setExpiration(0.1);
        driveRobotDrive21.setSensitivity(0.5);
        driveRobotDrive21.setMaxOutput(1.0);

        driveRobotDrive21.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        weainchWench = new Talon(3);
        LiveWindow.addActuator("Weainch", "Wench", (Talon) weainchWench);
        
        ball_MechControl_Mech = new Talon(2);
        LiveWindow.addActuator("Ball_Mech", "Control_Mech", (Talon) ball_MechControl_Mech);

        ballBox = new Talon(4);
        LiveWindow.addActuator("BallBox", "BoxWench", (Talon) ballBox);
//pneumaticsCompressor = new Compressor(0);
        
        
       // pneumaticsDoubleSolenoid = new DoubleSolenoid(0, 0, 1);      
        //LiveWindow.addActuator("Pneumatics", "Double Solenoid", pneumaticsDoubleSolenoid);
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}

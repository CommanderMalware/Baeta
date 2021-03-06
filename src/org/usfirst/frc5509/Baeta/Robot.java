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

import org.usfirst.frc5509.Baeta.commands.Autonomous;
import org.usfirst.frc5509.Baeta.commands.AutonomousDriveForward;
import org.usfirst.frc5509.Baeta.commands.AutonomousWheelieBar;
import org.usfirst.frc5509.Baeta.commands.WheelieBarIn;
import org.usfirst.frc5509.Baeta.commands.WheelieBarOut;
import org.usfirst.frc5509.Baeta.commands.BallPokeIn;
import org.usfirst.frc5509.Baeta.commands.BallPokeOut;
import org.usfirst.frc5509.Baeta.commands.WenchDown;
import org.usfirst.frc5509.Baeta.commands.WenchUp;
import org.usfirst.frc5509.Baeta.subsystems.BallBox;
import org.usfirst.frc5509.Baeta.subsystems.Ball_Mech;
import org.usfirst.frc5509.Baeta.subsystems.Drive;
import org.usfirst.frc5509.Baeta.subsystems.Weainch;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Command DriveForwardLittle;
	Command DriveForwardOverTrap;
	Command DriveForwardwithWheelie;
	Command wenchUp;
	Command wenchDown;
	Command wheelieBarIn;
	Command wheelieBarOut;
	Command ballPokeIn;
	Command ballPokeOut;
	CameraServer server;
	public static OI oi;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static Drive drive;
	public static Weainch weainch;
	public static Ball_Mech ball_Mech;
	public static Encoder Encode;
	public static Encoder EncodeRight;
	public static DoubleSolenoid pneumatic;
	public static DoubleSolenoid pneumatic2;
	public static Gyro gyro1;
	public static BallBox ballBox;
	public static DigitalInput switchA;
	public static DigitalInput switchB;
	public static DigitalInput switchC;
	public static DigitalInput LimswitchBoxTop;
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotMap.init();
		//CommandBase.init();
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		drive = new Drive();
		ball_Mech = new Ball_Mech();
		weainch = new Weainch();
		ballBox = new BallBox();
		Encode = new Encoder(0, 1);
		EncodeRight = new Encoder(2, 3);
		wheelieBarIn = new WheelieBarIn();
		wheelieBarOut = new WheelieBarOut();
		ballPokeIn = new BallPokeIn();
		ballPokeOut = new BallPokeOut();
		switchA = new DigitalInput(4);
		switchB = new DigitalInput(5);
		switchC = new DigitalInput(6);
		LimswitchBoxTop = new DigitalInput(7);
		
		gyro1 = new ADXRS450_Gyro();
		gyro1.reset();
		
		Compressor c = new Compressor(0);
		c.start();

		c.setClosedLoopControl(true);
		//BallPoke
		pneumatic = new DoubleSolenoid(0, 1);
		pneumatic.set(DoubleSolenoid.Value.kReverse);

		//WheelieBar
		pneumatic2 = new DoubleSolenoid(2, 3);
		pneumatic2.set(DoubleSolenoid.Value.kForward);
		
		//Enable Camera
		server = CameraServer.getInstance();
        server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        server.startAutomaticCapture("cam0");

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// instantiate the command used for the autonomous period
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

		DriveForwardOverTrap = new Autonomous();
		DriveForwardwithWheelie = new AutonomousWheelieBar();
		DriveForwardLittle = new AutonomousDriveForward();

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		gyro1.reset();
	EncodeRight.reset();
		// schedule the autonomous command (example)
		
		if(switchA.get() == true && switchB.get() == true && switchC.get() == true){
			DriveForwardOverTrap.start();
		}
		else if(switchA.get() == false && switchB.get() == false && switchC.get() == false){
			DriveForwardwithWheelie.start();
		}
		else if(switchA.get() == true && switchB.get() == false && switchC.get() == false){
			DriveForwardLittle.start();
		}
		
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		// drive forward:
		 //drive.DriveRobot(1, 1);
		 //Timer.delay(2);
		 
		//if (switchA.get() == true && switchB.get() == true && switchC.get() == true) {

		//}
		// Go Forward

		// Cross Defense??

		// Shoot Ball?????

		SmartDashboard.putNumber("Gyro Reading", gyro1.getAngle());
		SmartDashboard.putNumber("Gyro Rate: ", gyro1.getRate());
		SmartDashboard.putNumber("Encoder value", Encode.get());
		SmartDashboard.putNumber("Encoder right value", EncodeRight.get());
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
			DriveForwardLittle.cancel();
			DriveForwardwithWheelie.cancel();
			gyro1.reset();
			EncodeRight.reset();
			
			//Wheelie Bar In and Out
			oi.joystickButton5.whenPressed(wheelieBarIn);
			oi.joystickButton6.whenPressed(wheelieBarOut);

			// ADD POKE TO LAUNCH
			oi.joystickButton1.whileHeld(ballPokeOut);
			oi.joystickButton1.whenReleased(ballPokeIn);
			
			
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		// Define Variables

		// JOYSTICK 1
		double y = oi.joystick1.getRawAxis(1);
		double x = oi.joystick1.getRawAxis(4);

		double g = oi.joystick2.getRawAxis(5);
		double e = oi.joystick2.getRawAxis(1);

		// JOYSTICK 2 LAUNCH
		double ball_launchin = oi.joystick2.getRawAxis(2);
		double ball_launchout = oi.joystick2.getRawAxis(3);
		
		// Drive Robot
		drive.DriveRobot(x, y);

		
		//Buttons have been moved to TeleopInt to save memory. Only need to be called once.

		// BallBox movement up and down. Limit switch at top.
		/*if (LimswitchBoxTop.get() == true) {
			if (e > 0) {
				ballBox.MoveBallBox(e * -1);
			} else {
				ballBox.MoveBallBox(e);
			}

		} else {
			ballBox.MoveBallBox(e);
		}*/
			ballBox.MoveBallBox(e);
		// Wench movement up and down
		weainch.MoveWench(g);
		
		
		// Ball_Mech

		if (ball_launchout == 0) {
			ball_Mech.Ball_launcherin(ball_launchin);
		} else if (ball_launchin == 0) {
			ball_Mech.Ball_launcherout(ball_launchout);
		}else if(ball_launchout == 0 && ball_launchin == 0){
			ball_Mech.Ball_launcherin(0);
		}

		// SmartDashBoard Stuff
		SmartDashboard.putNumber("Gyro Reading", gyro1.getAngle());
		SmartDashboard.putNumber("Gyro Rate: ", gyro1.getRate());
		SmartDashboard.putNumber("Encoder value", Encode.get());
		SmartDashboard.putNumber("Encoder right value", EncodeRight.get());
		

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}

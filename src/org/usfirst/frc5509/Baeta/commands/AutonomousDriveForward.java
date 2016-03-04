package org.usfirst.frc5509.Baeta.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The main autonomous command to pickup and deliver the
 * soda to the box.
 */
public class AutonomousDriveForward extends CommandGroup {
    public AutonomousDriveForward() {
    	addSequential(new DriveForward());
    	addSequential(new DriveForward());
        
    }
}

package org.usfirst.frc5509.Baeta.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The main autonomous command to pickup and deliver the
 * soda to the box.
 */
public class Autonomous extends CommandGroup {
    public Autonomous() {
    	addSequential(new WheelieBarIn());
        addSequential(new DriveForward());
    }
}

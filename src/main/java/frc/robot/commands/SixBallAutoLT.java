// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.*;

/**
 *
 */
public class SixBallAutoLT extends CommandGroup {


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public SixBallAutoLT() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS
        //nothing here yet
        /**
         * this will shoot 3 balls
         * then grab 3 from trench
         * then shoot them from trench
         * */

        addSequential(new PrepareBallForShoot(false));
        addParallel(new SetRPMVision());
        addParallel(new Start_Shooter(true));
        addSequential(new AutoAlign());
        addSequential(new WaitForShooterSpeed());
        addSequential(new AutomatedShoot());
        addSequential(new AutomatedShoot());
        addSequential(new AutomatedShoot());
        addSequential(new TurnToGyroAngle(0));
        addParallel(new Run_Intake());
        // addSequential(new DriveQuick(-.7,.5));
        // addSequential(new PauseFor(.5));
        addSequential(new driveForFeet(16.5,.48));
        addSequential(new PauseFor(.25));
        //addSequential(new Stop_Intake());
        addSequential(new driveForFeet(-15,.9));
        //addParallel(new Start_Shooter_RPM(3100));
        addParallel(new SetRPMVision());
        addParallel(new Start_Shooter(true));
        addSequential(new AutoAlign());
        addSequential(new WaitForShooterSpeed());
        addSequential(new PrepareBallForShoot(false));
        //addParallel(new Run_Intake());
        addSequential(new AutomatedShoot());
        addSequential(new Stop_Intake()); //so they fall if jammed
        addSequential(new AutomatedShoot());
        addSequential(new AutomatedShoot());
    } 
}

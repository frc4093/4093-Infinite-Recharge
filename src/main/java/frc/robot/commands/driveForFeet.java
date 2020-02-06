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

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * self explanatory this can be a lot more advanced but this will do for now
 *
 */
public class driveForFeet extends Command {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_ft;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double kP = .1;
    private double output;
    private double error;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public driveForFeet(double ft) {

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_ft = ft;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drive);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.drive.resetEnc(); //need to redo command twice dont think its realizes it reset       
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        error = Math.abs(m_ft) - Math.abs(Robot.drive.getFeetMovedFromEnc());
        if (m_ft > 0)
            Robot.drive.arcade(-.35-kP*error, 0);
        if (m_ft < 0)
            Robot.drive.arcade(.35+kP*error, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished(){
        //doesnt matter what direction if we do it like this
        return (Math.abs(m_ft) < Math.abs(Robot.drive.getFeetMovedFromEnc()));
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.drive.arcade(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}

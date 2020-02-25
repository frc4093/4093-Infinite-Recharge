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
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class Run_Intake extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double feedSpeed;
    private double jammedShot = 0;
    private boolean jammed = false;
    private double count;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public Run_Intake() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.intake);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        feedSpeed = .2;
        count = 0;
        jammedShot = -1;
        jammed = false;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (!jammed){
            feedSpeed = .1;
        }
        Robot.dash.displayData("RPM intake", Robot.intake.feedWheelRPM());
        Robot.intake.runFeedWheel(feedSpeed);
        if (Math.abs(Robot.intake.feedWheelRPM())<5 & /*Math.abs(Robot.intake.getFeedSpeed())>=.3 & */(!jammed) & (count > 60)){
            //uh oh jammed
            feedSpeed = -.2;
            jammedShot = Robot.roughShotCounter;
            jammed = true;
            count = 0;
        }
        if (jammed & (Robot.roughShotCounter != jammedShot)){
            jammed = false;
        }
        if (count > 10 && jammed){
            feedSpeed =0;
        }
        Robot.intake.runIntakeWheels(-.6);
        count++;
        Robot.dash.displayData("Shot counter", Robot.roughShotCounter);
        Robot.dash.displayData("jammed shot", jammedShot);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.intake.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}

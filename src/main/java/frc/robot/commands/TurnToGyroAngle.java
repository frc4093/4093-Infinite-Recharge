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
 * Problem: Its currently inefficent but cant seem to fix no matter what I do
 * good enough for what we will do in autonomous though
 */
public class TurnToGyroAngle extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_angle;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private int count;
    private double offset =1.1;
    private double extraSpeed;
    private double correctedDriveAngle;
    public TurnToGyroAngle(double angle, double timeout) {
        m_angle = angle;
       // setTimeout(timeout);
    }
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public TurnToGyroAngle(double angle) {
        //setTimeout(5);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_angle = angle;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        count = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        correctedDriveAngle = Robot.drive.getAngle();
        extraSpeed = (Math.abs(m_angle-Math.abs(correctedDriveAngle))/360)*.4;
        if (correctedDriveAngle > m_angle+offset || correctedDriveAngle < m_angle-offset){
            count = 0; //reset count
            if (m_angle>correctedDriveAngle){
                Robot.drive.arcade(0, .15+extraSpeed,false);
            }else{
                Robot.drive.arcade(0, -.15-extraSpeed,false);
            }
            
        }else{
            Robot.drive.arcade(0,0);
            count++;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return count>10; //|| isTimedOut(); //this probably isnt the best way but easiest way I could think of to check if stable
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

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
 *
 */
public class turnPlusGyroValue extends Command {
    private int count;
    private double addedAngle;
    private double offset = 1;
    private double extraSpeed;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_angle;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public turnPlusGyroValue(double angle) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_angle = angle;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drive);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        count = 0;
        addedAngle = Robot.drive.getAngle() + m_angle;
        
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        extraSpeed = ((addedAngle-Robot.drive.getAngle())/360)*.65;
        if (Robot.drive.getAngle() > addedAngle+offset || Robot.drive.getAngle() < addedAngle-offset ){
            count = 0; //reset count
            if (addedAngle>Robot.drive.getAngle()){
                Robot.drive.arcade(0, .35+extraSpeed);
            }else{
                Robot.drive.arcade(0, -.35+extraSpeed);
            }
            
        }else{
            Robot.drive.arcade(0,0);
            count++;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return count>10; //this probably isnt the best way but easiest way I could think of to check if stable
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

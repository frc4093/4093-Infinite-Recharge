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
public class Start_Shooter extends Command {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_RPM;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private int count;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public Start_Shooter(double RPM) {
        m_RPM = RPM;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.shooter);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        //Robot.shooter.setPowerLevel(0);
        Robot.shooter.setRPM(m_RPM);
        // if (Robot.dash.readNumber("RPM force set") >1){
        //     Robot.shooter.setRPM(Robot.dash.readNumber("RPM force set"));
        // }
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        //Robot.shooter.setRPM(Robot.dash.readNumber("shoot RPM setter"));
        Robot.shooter.setRPM(m_RPM);
        Robot.shooter.shootAtRPM();
        Robot.dash.displayData("RPM", Robot.shooter.getShooter_RPM());
        Robot.dash.displayData("Goal", m_RPM);
        // if (Robot.shooter.isReady()){
        //     count++;
        // }else{
        //     count = 0;
        // }
        //for testing at rally
        if (Robot.oi.operatorGamepad.getPOV() == 0){
            m_RPM+=10;
        }else if (Robot.oi.operatorGamepad.getPOV() == 180){
            m_RPM-=10;
        }
        
        //until we can do by distance
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
        //return count>5;//count>5;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        //Robot.shooter.stop();
        System.out.println("Shooter ended");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}

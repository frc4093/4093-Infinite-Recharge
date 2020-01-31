// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class Shooter extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonFX shooterFalcon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public final int kSensorUnitsPerRotation = 2048;
    public final double kRPMConstant = 600 / kSensorUnitsPerRotation;
    private static double setRPM;
    private static double currentRPM;
    public static double powerLevel;

    // if I was to do PIDF control
    private final double kP =0;
    private final double kI =0;
    private final double kD = 0;
    private final double kF = 0;

    public Shooter() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        shooterFalcon = new WPI_TalonFX(0);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        shooterFalcon.configFactoryDefault();
        //braking makes no sense on shooter lets coast
        shooterFalcon.setNeutralMode(NeutralMode.Coast);
        
        //voltage comp
        shooterFalcon.enableVoltageCompensation(true);
        shooterFalcon.configVoltageCompSaturation(12.5);
        //PIDF
        shooterFalcon.config_kP(0,kP);
        shooterFalcon.config_kI(0,kI);
        shooterFalcon.config_kD(0,kD);
        shooterFalcon.config_kF(0,kF);
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        Robot.dash.displayData("power", powerLevel);

    }

    public void setRPM(double rpm) {
        setRPM = rpm;
        powerLevel = .5;

    }

    public void setShooter(ControlMode controlMode, double val) {
        shooterFalcon.set(controlMode, val);
    }

    public void shootAtRPM() {
        // this dont work quite right yet(mininum 3200 no idea why)
        double currentRPM = getShooter_RPM();
        if (currentRPM < setRPM) {
            powerLevel += .01;
        }
        if (currentRPM > setRPM) {
            powerLevel -= .01;
        }
        if (powerLevel > .5)
            setShooter(ControlMode.PercentOutput,powerLevel);
    }

    public void currentStatus() {

    }

    // for testing purposes
    public double getShooter_RPM() {
        return ((shooterFalcon.getSelectedSensorVelocity() * 600) / kSensorUnitsPerRotation); // actual
    }

    public void stop() {
        shooterFalcon.set(0);
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

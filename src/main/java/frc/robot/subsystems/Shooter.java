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
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
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
    public static double setRPM;
    private static double currentRPM;
    public static double powerLevel;
    public static int shooterCount;
    // if I was to do PIDF control
    private final double kP = 1.0;
    private final double kI =0;
    private final double kD =1.0;
    private final double kF = 0.02;

    private final int kTimeout = 30;

    public Shooter() {
        shooterCount = 0;
        setRPM = 0;
        powerLevel = 0;
        shooterCount = 0;
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
shooterFalcon = new WPI_TalonFX(7);


        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        shooterFalcon.configFactoryDefault();
        //braking makes no sense on shooter lets coast
        shooterFalcon.setNeutralMode(NeutralMode.Coast);
        shooterFalcon.setSensorPhase(true);
        shooterFalcon.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor,0,0);

        shooterFalcon.configNominalOutputForward(0,kTimeout);
        shooterFalcon.configNominalOutputReverse(0,kTimeout);
        shooterFalcon.configPeakOutputForward(1,kTimeout);
        shooterFalcon.configPeakOutputReverse(-1,kTimeout);

        //voltage comp
        shooterFalcon.enableVoltageCompensation(true);

        shooterFalcon.configVoltageCompSaturation(12.5);
        shooterFalcon.setSelectedSensorPosition(0);

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
        // Robot.dash.displayData("recieved", setRPM);
                

    }

    public void setRPM(double rpm) {
        setRPM = rpm;
    }
    public void setPowerLevel(double pl){
        powerLevel = pl;
    }

    public void setShooter(ControlMode controlMode, double val) {
        shooterFalcon.set(controlMode, val);
    }

    public void shootAtRPM() {
        //Note: too many ifs
        if (shooterCount<7){
            shooterCount++;
            return;
        }
        shooterCount = 0;
        double currentRPM = getShooter_RPM();
        double error = currentRPM/setRPM;
        double change = 0;
        double rpmDifferenceAbs = Math.abs(setRPM-currentRPM);
        if (rpmDifferenceAbs<5){
            return;
        }
        if (rpmDifferenceAbs<50){
            change = .001;
        }
        else if (rpmDifferenceAbs<200){
            change = .002;
        }
        else if (rpmDifferenceAbs<300){
            change = .006;
        }else if (rpmDifferenceAbs<500){
            change = .014;
        }else if (rpmDifferenceAbs<1000){
            change = .025;
        }else{
            change = .05;
        }
        if (currentRPM < setRPM) {
            change *=1;
        }else{
            change*=-1;
        }
        powerLevel += change;
        if (powerLevel > .05){
            setShooter(ControlMode.PercentOutput,powerLevel);
        }else{
            setShooter(ControlMode.PercentOutput, 0);
        }
            
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
    public boolean isReady(){
        //we need to make sure shooter is spinning before we shoot
        if ((getShooter_RPM()>setRPM-50 & getShooter_RPM()<setRPM+50) & !(getShooter_RPM()<500)){
            return true;
        }
        return false;
    }
    public boolean preciseShotReady(){
        if ((getShooter_RPM()>setRPM-10 & getShooter_RPM()<setRPM+10) & !(getShooter_RPM()<500)){
            return true;
        }
        return false;
    }
    public double getSetRPM(){
        return setRPM;
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

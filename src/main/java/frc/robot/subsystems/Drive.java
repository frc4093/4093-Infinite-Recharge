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
import edu.wpi.first.wpilibj.RobotDrive;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drive extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    private static final double kGearRatio = 10.71;
    private static final int kSensorUnitsPerRotation = 2048;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_TalonFX falconFR;
private WPI_TalonFX falconBR;
private SpeedControllerGroup rightSide;
private WPI_TalonFX falconFL;
private WPI_TalonFX falconBL;
private SpeedControllerGroup leftSide;
private DifferentialDrive drive;
private AnalogGyro gyro;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public Drive() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
falconFR = new WPI_TalonFX(3);


        
falconBR = new WPI_TalonFX(2);


        
rightSide = new SpeedControllerGroup(falconFR, falconBR  );
addChild("rightSide",rightSide);

        
falconFL = new WPI_TalonFX(1);


        
falconBL = new WPI_TalonFX(4);


        
leftSide = new SpeedControllerGroup(falconFL, falconBL  );
addChild("leftSide",leftSide);

        
drive = new DifferentialDrive(leftSide, rightSide);
addChild("drive",drive);
drive.setSafetyEnabled(true);
drive.setExpiration(0.1);
drive.setMaxOutput(1.0);

        
gyro = new AnalogGyro(0);
addChild("gyro",gyro);
gyro.setSensitivity(0.007);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new XDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public void arcade(double xSpeed, double zRotation){
        drive.arcadeDrive(xSpeed, zRotation);
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

        //this should work
        Robot.dash.displayData("RPM FL", getDriveRPM(falconFL));
        Robot.dash.displayData("RPM FR", getDriveRPM(falconFR));
        Robot.dash.displayData("RPM BL", getDriveRPM(falconBL));
        Robot.dash.displayData("RPM BR", getDriveRPM(falconBR));

        //For testing
        Robot.dash.displayData("Drive left FPS", getDriveFPS(getDriveRPM(falconFL)));
        Robot.dash.displayData("Drive average", getDriveFPS(getDriveRPM(falconFL),getDriveRPM(falconFR)));
    }

    public double getMotor_RPM(WPI_TalonFX motor){
        return ((motor.getSelectedSensorVelocity()*600)/kSensorUnitsPerRotation); //actual
    }

    public double getDriveRPM(WPI_TalonFX motor){
        return getMotor_RPM(motor)/kGearRatio; //after gearbox
    }
    //lets get feet per second
    public double getDriveFPS(double RPM){
        return (0); //this isnt done yet
    }
    public double getDriveFPS(double RPM1, double RPM2){
        double total = RPM1+RPM2;
        double average = total/2;
        return getDriveFPS(average);
    }
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}


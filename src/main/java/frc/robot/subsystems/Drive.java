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
import frc.robot.commands.XDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.analog.adis16448.frc.ADIS16448_IMU;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class Drive extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
    private int count;
    private static final double kGearRatio = 1/10.71;
    private static final int kSensorUnitsPerRotation = 2048;
    private static final double kWheelDiameter = 6;// 6" wheel
    private static final double kDriveEncoderToFt = (1.0/kSensorUnitsPerRotation)*(kGearRatio)*(kWheelDiameter*Math.PI)/12; //1rotation/encoder ticks(2048)*gear ratio(1/10)*wheel diameter*PI/12 in
    private static ADIS16448_IMU imu = new ADIS16448_IMU();
    public static double virtualEncOffset;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_TalonFX falconFL;
private WPI_TalonFX falconBL;
private SpeedControllerGroup leftSide;
private WPI_TalonFX falconFR;
private WPI_TalonFX falconBR;
private SpeedControllerGroup rightSide;
private DifferentialDrive drive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Drive() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
falconFL = new WPI_TalonFX(1);


        
falconBL = new WPI_TalonFX(4);


        


//Set SlaveSpeedControllers to Follow MasterSpeedController
falconBL.follow(falconFL);
        
        
        
falconFR = new WPI_TalonFX(3);


        
falconBR = new WPI_TalonFX(2);


        


//Set SlaveSpeedControllers to Follow MasterSpeedController
falconBR.follow(falconFR);
        
        
        
drive = new DifferentialDrive(falconFL, falconFR);
addChild("drive",drive);
drive.setSafetyEnabled(true);
drive.setExpiration(0.1);
drive.setMaxOutput(1.0);

        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    falconBL.setNeutralMode(NeutralMode.Brake);
    falconBR.setNeutralMode(NeutralMode.Brake);
    falconFL.setNeutralMode(NeutralMode.Brake);
    falconFR.setNeutralMode(NeutralMode.Brake);
    drive.setDeadband(.05); //Deadband
    //voltage comp?
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new XDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void arcade(double xSpeed, double zRotation) {
        drive.arcadeDrive(xSpeed, zRotation);
    }
    public void arcade(double xSpeed, double zRotation, boolean squaredInputs){
        drive.arcadeDrive(xSpeed, zRotation,squaredInputs);
    }
    public void tank(double left, double right,boolean squaredInputs){
        drive.tankDrive(left, right,squaredInputs);
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

        // this should work
        // Robot.dash.displayData("RPM FL", getDriveRPM(falconFL));
        // Robot.dash.displayData("RPM FR", getDriveRPM(falconFR));
        // Robot.dash.displayData("RPM BL", getDriveRPM(falconBL));
        // Robot.dash.displayData("RPM BR", getDriveRPM(falconBR));
        // count++;
        // // For testing
        // Robot.dash.displayData("Drive left FPS", getDriveFPS(falconFL));
        Robot.dash.displayData("Corrected val", getAngle360());
        Robot.dash.displayData("Gyro Value", getAngle());
        Robot.dash.displayData("enc", getEnc());
        Robot.dash.displayData("venc", getVirtualEnc());
        //why is there drift?
    }

    public double getMotor_RPM(WPI_TalonFX motor) {
        return ((motor.getSelectedSensorVelocity() * 600) / kSensorUnitsPerRotation); // actual
    }

    public double getDriveRPM(WPI_TalonFX motor) {
        return getMotor_RPM(motor)*kGearRatio; // after gearbox
    }

    // lets get feet per second
    public double getDriveFPS(TalonFX motor){
        return Math.abs((motor.getSelectedSensorVelocity()*10)*kDriveEncoderToFt);
    }
    public void calGyro(){
        imu.calibrate();
    }
    public void resetGyro(){
        imu.reset();
    }

    public double getAngle(){
        return imu.getAngle();
    }
    public double getAngle360(){
        double step1 = getAngle()%360;
        double step2;
        if (step1<0){
            step2 = 360+step1; //subtracting value from 360(its negative so technically adding)
        }else{
            step2 = step1;
        }
        return step2; 
    }

    //sort of rough methods for autonomous use
    public void resetEnc(){
        falconFL.setSelectedSensorPosition(0);
    }
    public double getEnc(){
         return falconFL.getSelectedSensorPosition();
    }
    //resetEnc() doesnt always work(unsure why)
    // simple solution was to create a virtual encoder
    public void resetVirtualEnc(){
        virtualEncOffset = falconFL.getSelectedSensorPosition();
    }
    public double getVirtualEnc(){
        return getEnc()-virtualEncOffset;
    }
    public double getFeetMovedFromVEnc(){
        return getVirtualEnc()*kDriveEncoderToFt;
    }
    public double getFeetMovedFromEnc(){
        return getEnc()*kDriveEncoderToFt;
    }

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

// Put methods for controlling this subsystem
// here. Call these from Commands.

}

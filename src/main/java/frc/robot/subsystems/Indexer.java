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
import com.revrobotics.*;
import com.revrobotics.Rev2mDistanceSensor.Port;
import com.revrobotics.Rev2mDistanceSensor.Unit;
import com.ctre.phoenix.motorcontrol.NeutralMode;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Indexer extends Subsystem {
    private Rev2mDistanceSensor powerCellSensor;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_TalonFX conveyor;
private DigitalInput break_Beam;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
 private double kGearRatio = 1/5;
 private int kEncoderTicks = 2048;
 private double desiredDistance = 150;
 public boolean wasMoved;
 /**
  * Some notes on for sensor
  * sensor spacing ???mm
  * Ball in mm 177.8
  * space between sides of indexer 203.2 mm
  * in accuracy caused by spacing 1 in/ 25.4 mm
  * Sensor deadzone is like 28 mm 
  */
    public Indexer() {
        powerCellSensor = new Rev2mDistanceSensor(Port.kOnboard);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
conveyor = new WPI_TalonFX(0);


        
break_Beam = new DigitalInput(0);
addChild("break_Beam",break_Beam);

        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    conveyor.setNeutralMode(NeutralMode.Brake);
        //conveyor is probably a bad name but it better describes functionality vs any other name
        powerCellSensor.setAutomaticMode(true);
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new indexerFiller());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        Robot.dash.displayData("distance sensor intake", getDistance(Unit.kMillimeters));
        Robot.dash.displayData("BreakBeam", break_Beam.get());
    }

    public void runUp(){
        conveyor.set(.3);
        wasMoved = true;
        Robot.roughShotCounter++;
    }

    public void runDown(){
        conveyor.set(-.3);
        wasMoved = true;
    }
    public void stop(){
        conveyor.set(0);
    }
    public double getRotations(){
        return (conveyor.getSelectedSensorPosition()/kEncoderTicks)*kGearRatio;
    }
    public double getpos(){
        return (conveyor.getSelectedSensorPosition());
    }
    public double getDistance(Unit u){
        return powerCellSensor.getRange(u);
    }
    //unfinished
    public boolean isFull(){
        return false; //not sure how we will work this yet
    }
    //unfinished
    public int countGuess(){
        return 0; 
    }
    public boolean ballInDesiredPosition(){
        double d = getDistance(Unit.kMillimeters);
        return (d<desiredDistance);
    }
    public boolean beamBroke(){
        return !break_Beam.get();
    }
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}


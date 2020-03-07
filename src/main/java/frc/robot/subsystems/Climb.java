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
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Climb extends Subsystem {
    private double upEncVal = 174000; //?
    private double downEncVal = 0;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_TalonFX leftClimbMotor;
private WPI_TalonFX rightClimbMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public Climb() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
leftClimbMotor = new WPI_TalonFX(9);


        
rightClimbMotor = new WPI_TalonFX(8);


        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    //rightClimbMotor.follow(leftClimbMotor); //we may get more advanced later(leveling) but this is the simple way for now
    rightClimbMotor.setNeutralMode(NeutralMode.Brake);
    leftClimbMotor.setNeutralMode(NeutralMode.Brake);
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new runClimb());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        Robot.dash.displayData("Climb L", getLeftEnc());
        Robot.dash.displayData("climb R", getRightEnc());
    }
    public void moveup(double speed){
        leftClimbMotor.set(ControlMode.PercentOutput,speed);
    }
    public void movedown(double speed){
        leftClimbMotor.set(ControlMode.PercentOutput,speed);
    }
    public void move(double speed){
        if (!(getLeftEnc() >= upEncVal)){
            leftClimbMotor.set(ControlMode.PercentOutput,speed);
        }else{
            leftClimbMotor.set(ControlMode.PercentOutput,0);
        }
        if (!(getRightEnc() >= upEncVal)){
            rightClimbMotor.set(ControlMode.PercentOutput,speed);
        }else{
            rightClimbMotor.set(ControlMode.PercentOutput,0);
        }
    }
    public void stop(){
        leftClimbMotor.set(ControlMode.PercentOutput,0);
    }
    public double getLeftEnc(){
        return leftClimbMotor.getSelectedSensorPosition();
    }
    public double getRightEnc(){
        return rightClimbMotor.getSelectedSensorPosition();
    }

    public void setLeftEnc(int v){
        leftClimbMotor.setSelectedSensorPosition(v);
    }
    public void setRightEnc(int v){
        rightClimbMotor.setSelectedSensorPosition(v);
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}


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
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Limelight extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
    //limelight values
    static NetworkTable ll;
    static NetworkTableEntry tx;
    static NetworkTableEntry ty;
    static NetworkTableEntry ta;
    static NetworkTableEntry tv;
    static NetworkTableEntry LED;
    static NetworkTableEntry camMode;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    //for distance
    private final double a1 = 35.5; //mounting angle of camera
    private double a2 = 0; //y angle will grab from method
    private final double h1 = 19.5; //height of camera above floor
    private final double h2 = 90; //height of 
    private final double kHeight = h2 - h1;
    private final double closest = 0;
    public static enum LEDMode {
        PIPELINE(0),
        OFF(1),
        BLINK(2),
        ON(3);
        private int v;
        private LEDMode(final int mode){
            v = mode;
        }
        public int getMode(){
            return v;
        }
    }
    public static enum CamMode {
        VISION(0),
        DRIVER(1);
        private int v;

        private CamMode(final int mode){
            v = mode;
        }
        public int getMode() {
            return v;
        }
    }

    public Limelight() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        ll = NetworkTableInstance.getDefault().getTable("limelight");
        tx = ll.getEntry("tx");
        ty = ll.getEntry("ty");
        ta  = ll.getEntry("ta");
        tv = ll.getEntry("tv");
        LED = ll.getEntry("ledMode");
        camMode = ll.getEntry("camMode");
        setLight(LEDMode.OFF);
        setCameraMode(CamMode.DRIVER);
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
        if  (targetInSight()){
            Robot.dash.displayData("Distance estimation", getDistance());
            Robot.dash.displayData("Target Area", getTargetArea());
        }
    }
    
    public boolean targetInSight(){
        return (tv.getDouble(0) == 1); //check if target is in sight using network table
    }
    public double getTargetAngleX(){
        return tx.getDouble(0.0); //get X angle off network table
    }
    public double getTargetAngleY(){
        return ty.getDouble(0.0); //get Y off network table
    }
    public double getTargetArea(){
        return ta.getDouble(0.0); //get target area off network table
    }
    public void setLight(final LEDMode v){
        LED.setNumber(v.getMode()); //set LED mode
    }
    public void setCameraMode(final CamMode v){
        camMode.setNumber(v.getMode()); //set camera mode
    }
    public double getDistance(){
        //see http://docs.limelightvision.io/en/latest/cs_estimating_distance.html
        /**
         * equation in document
         * h1 = height of camera above floor
         * h2 = height of target
         * a1 = mounting angle
         * a2 = y angle of target
         * d = distance
         * 
         * tan(a1+a2) = (h2-h1) / d
         * 
         * d = (h2-h1) / tan(a1+a2)
         */
        a2 = getTargetAngleY();
        return (kHeight)/(Math.tan(Math.toRadians(a1+a2)));
    }

    public double getLimelightRPM(){
        double rpm;
        double distance = getDistance();
        if (targetInSight()){
            if (!(Robot.distanceToRPM.getInterpolated(distance)==null)){
                rpm = Robot.distanceToRPM.getInterpolated(distance);
            }else{
                rpm = 0;
            }
                
        }else{
            rpm = -1;
        }

        
        // if (getDistance()>closest){
        
        // }
        return rpm;

    }
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}


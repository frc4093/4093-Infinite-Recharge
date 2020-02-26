// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
public JoystickButton bButtonAutoAlign;
public JoystickButton xButtonAutoAlign;
public Joystick driveGamepad;
public JoystickButton startShooterRB;
public JoystickButton stopShooterLB;
public JoystickButton autoAlignX;
public JoystickButton runIntakeWhileHeldY;
public JoystickButton startIntake8;
public JoystickButton stopIntake7;
public JoystickButton shootOneA;
public JoystickButton dumbIntakeB;
public Joystick operatorGamepad;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

operatorGamepad = new Joystick(1);

dumbIntakeB = new JoystickButton(operatorGamepad, 2);
dumbIntakeB.whenPressed(new Run_Intake());
shootOneA = new JoystickButton(operatorGamepad, 1);
shootOneA.whenPressed(new AutomatedShoot());
stopIntake7 = new JoystickButton(operatorGamepad, 7);
stopIntake7.whenPressed(new Stop_Intake());
startIntake8 = new JoystickButton(operatorGamepad, 8);
startIntake8.whenPressed(new AutomatedIntake());
runIntakeWhileHeldY = new JoystickButton(operatorGamepad, 4);
runIntakeWhileHeldY.whileHeld(new AutomatedIntake());
autoAlignX = new JoystickButton(operatorGamepad, 3);
autoAlignX.whileHeld(new AutoAlign());
stopShooterLB = new JoystickButton(operatorGamepad, 5);
stopShooterLB.whenPressed(new StopShooter());
startShooterRB = new JoystickButton(operatorGamepad, 6);
startShooterRB.whenPressed(new Start_Shooter(3000));
driveGamepad = new Joystick(0);

xButtonAutoAlign = new JoystickButton(driveGamepad, 3);
xButtonAutoAlign.whileHeld(new AutoAlign());
bButtonAutoAlign = new JoystickButton(driveGamepad, 2);
bButtonAutoAlign.whileHeld(new AutoAlign());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("XDrive", new XDrive());
        SmartDashboard.putData("Run_Intake", new Run_Intake());
        SmartDashboard.putData("Do_Climb", new Do_Climb());
        SmartDashboard.putData("StopShooter", new StopShooter());
        SmartDashboard.putData("AutoAlign", new AutoAlign());
        SmartDashboard.putData("RumbleDrive", new RumbleDrive());
        SmartDashboard.putData("RumbleOperator", new RumbleOperator());
        SmartDashboard.putData("setRumble", new setRumble());
        SmartDashboard.putData("stopRumble", new stopRumble());
        SmartDashboard.putData("Run_Indexer", new Run_Indexer());
        SmartDashboard.putData("passAutoLine", new passAutoLine());
        SmartDashboard.putData("SixBallAutoLT", new SixBallAutoLT());
        SmartDashboard.putData("TargetPosAuto", new TargetPosAuto());
        SmartDashboard.putData("SixBallAutoRT", new SixBallAutoRT());
        SmartDashboard.putData("UniversalShootAuto", new UniversalShootAuto());
        SmartDashboard.putData("Stop_Intake", new Stop_Intake());
        SmartDashboard.putData("ContinuousShot", new ContinuousShot());
        SmartDashboard.putData("PrepareBallForShoot", new PrepareBallForShoot());
        SmartDashboard.putData("Start_Shooter_Distance", new Start_Shooter_Distance());
        SmartDashboard.putData("WaitForShooterSpeed", new WaitForShooterSpeed());
        SmartDashboard.putData("AutomatedShoot", new AutomatedShoot());
        SmartDashboard.putData("AutomatedIntake", new AutomatedIntake());
        SmartDashboard.putData("ReturnToStartGyro", new ReturnToStartGyro());
        SmartDashboard.putData("tankDrive", new tankDrive());
        SmartDashboard.putData("turnLLOn", new turnLLOn());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    SmartDashboard.putData("Turn To 0", new TurnToGyroAngle(0));

    SmartDashboard.putData("Start_Shooter", new Start_Shooter(1000)); //very slow shoot
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public Joystick getdriveGamepad() {
        return driveGamepad;
    }

public Joystick getoperatorGamepad() {
        return operatorGamepad;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public void setDriveRumble(double left, double right){
        driveGamepad.setRumble(RumbleType.kLeftRumble, left);
        driveGamepad.setRumble(RumbleType.kRightRumble, right);
    }

    public void setOperatorRumble(double left, double right){
        operatorGamepad.setRumble(RumbleType.kLeftRumble, left);
        operatorGamepad.setRumble(RumbleType.kRightRumble, right);
    }
}


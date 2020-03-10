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

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutoAlign;
import frc.robot.commands.AutomatedIntake;
import frc.robot.commands.AutomatedShoot;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.ContinuousShot;
import frc.robot.commands.RumbleDrive;
import frc.robot.commands.RumbleOperator;
import frc.robot.commands.Run_Indexer;
import frc.robot.commands.Run_Intake;
import frc.robot.commands.SetRPMVision;
import frc.robot.commands.SixBallAutoLT;
import frc.robot.commands.SixBallAutoRT;
import frc.robot.commands.Start_Shooter;
import frc.robot.commands.Start_Shooter_RPM;
import frc.robot.commands.StopShooter;
import frc.robot.commands.Stop_Intake;
import frc.robot.commands.TargetPosAuto;
import frc.robot.commands.TurnToGyroAngle;
import frc.robot.commands.UniversalShootAuto;
import frc.robot.commands.WaitForShooterSpeed;
import frc.robot.commands.incrementRPM;
import frc.robot.commands.indexerFiller;
import frc.robot.commands.passAutoLine;
import frc.robot.commands.resetClimbEncs;
import frc.robot.commands.runClimb;
import frc.robot.commands.runIntakeBackwards;
import frc.robot.commands.shootFromButton;
import frc.robot.commands.startShooterDistanceGroup;
import frc.robot.commands.tankDrive;
import frc.robot.commands.turnLLOn;

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

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton bButtonAutoAlign;
    public JoystickButton xButtonAutoAlign;
    public JoystickButton stopintakedriver;
    public JoystickButton startIntakedriver;
    public JoystickButton startFillerDriver;
    public Joystick driveGamepad;
    public JoystickButton startShooterRB;
    public JoystickButton stopShooterLB;
    public JoystickButton autoAlignX;
    public JoystickButton shootWhileHeldY;
    public JoystickButton ejectB;
    public JoystickButton startIntake8;
    public JoystickButton stopIntake7;
    public JoystickButton shootOneA;
    public JoystickButton startFillerOperator;
    public JoystickButton allowClimb;
    public Joystick operatorGamepad;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Button upPOV;
    public Button downPOV;

    public OI() {

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        operatorGamepad = new Joystick(1);

        allowClimb = new JoystickButton(operatorGamepad, 10);
        allowClimb.whileHeld(new runClimb());
        startFillerOperator = new JoystickButton(operatorGamepad, 8);
        startFillerOperator.whenPressed(new indexerFiller());
        shootOneA = new JoystickButton(operatorGamepad, 1);
        shootOneA.whenPressed(new AutomatedShoot());
        stopIntake7 = new JoystickButton(operatorGamepad, 7);
        stopIntake7.whenPressed(new Stop_Intake());
        startIntake8 = new JoystickButton(operatorGamepad, 8);
        startIntake8.whenPressed(new Run_Intake());
        ejectB = new JoystickButton(operatorGamepad, 2);
        ejectB.whileHeld(new runIntakeBackwards());
        shootWhileHeldY = new JoystickButton(operatorGamepad, 4);
        shootWhileHeldY.whileHeld(new AutomatedShoot());
        autoAlignX = new JoystickButton(operatorGamepad, 3);
        autoAlignX.whileHeld(new AutoAlign());
        stopShooterLB = new JoystickButton(operatorGamepad, 5);
        stopShooterLB.whenPressed(new StopShooter());
        startShooterRB = new JoystickButton(operatorGamepad, 6);
        startShooterRB.whenPressed(new shootFromButton());
        driveGamepad = new Joystick(0);

        startFillerDriver = new JoystickButton(driveGamepad, 8);
        startFillerDriver.whenPressed(new indexerFiller());
        startIntakedriver = new JoystickButton(driveGamepad, 8);
        startIntakedriver.whenPressed(new Run_Intake());
        stopintakedriver = new JoystickButton(driveGamepad, 7);
        stopintakedriver.whenPressed(new Stop_Intake());
        xButtonAutoAlign = new JoystickButton(driveGamepad, 3);
        xButtonAutoAlign.whileHeld(new AutoAlign());
        bButtonAutoAlign = new JoystickButton(driveGamepad, 2);
        bButtonAutoAlign.whileHeld(new AutoAlign());

        // SmartDashboard Buttons
        // SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        // SmartDashboard.putData("Run_Intake", new Run_Intake());
        // SmartDashboard.putData("StopShooter", new StopShooter());
        // SmartDashboard.putData("AutoAlign", new AutoAlign());
        // SmartDashboard.putData("Run_Indexer", new Run_Indexer());
        // SmartDashboard.putData("passAutoLine", new passAutoLine());
        // SmartDashboard.putData("SixBallAutoLT", new SixBallAutoLT());
        // SmartDashboard.putData("TargetPosAuto", new TargetPosAuto());
        // SmartDashboard.putData("SixBallAutoRT", new SixBallAutoRT());
        // SmartDashboard.putData("UniversalShootAuto", new UniversalShootAuto());
        // SmartDashboard.putData("Stop_Intake", new Stop_Intake());
        // SmartDashboard.putData("ContinuousShot", new ContinuousShot());
        // SmartDashboard.putData("AutomatedShoot", new AutomatedShoot());
        // SmartDashboard.putData("WaitForShooterSpeed", new WaitForShooterSpeed());
        // SmartDashboard.putData("AutomatedIntake", new AutomatedIntake());
        // SmartDashboard.putData("tankDrive", new tankDrive());
        SmartDashboard.putData("turnLLOn", new turnLLOn());
        // SmartDashboard.putData("SetRPMVision", new SetRPMVision());
        // SmartDashboard.putData("startShooterDistanceGroup", new
        // startShooterDistanceGroup());
        // SmartDashboard.putData("Start_Shooter", new Start_Shooter());
        // SmartDashboard.putData("indexerFiller", new indexerFiller());
        // SmartDashboard.putData("shootFromButton", new shootFromButton());
        // SmartDashboard.putData("runClimb", new runClimb());
        // SmartDashboard.putData("resetClimbEncs", new resetClimbEncs());
        // SmartDashboard.putData("runIntakeBackwards", new runIntakeBackwards());
        // SmartDashboard.putData("DriveQuick", new DriveQuick());
        // SmartDashboard.putData("FiveBallAutoRendezvous", new
        // FiveBallAutoRendezvous());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // oops fix for increment rpm
        upPOV = new DPad(operatorGamepad, DPad.Direction.UP);
        downPOV = new DPad(operatorGamepad, DPad.Direction.DOWN);
        upPOV.whileHeld(new incrementRPM(10.0));
        downPOV.whileHeld(new incrementRPM(-10.0));
        SmartDashboard.putData("Turn To 0", new TurnToGyroAngle(0));

        // SmartDashboard.putData("Start_Shooter_RPM", new Start_Shooter_RPM(1000));
        // //very slow shoot
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getdriveGamepad() {
        return driveGamepad;
    }

    public Joystick getoperatorGamepad() {
        return operatorGamepad;
    }

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public void setDriveRumble(double left, double right) {
        driveGamepad.setRumble(RumbleType.kLeftRumble, left);
        driveGamepad.setRumble(RumbleType.kRightRumble, right);
    }

    public void setOperatorRumble(double left, double right) {
        operatorGamepad.setRumble(RumbleType.kLeftRumble, left);
        operatorGamepad.setRumble(RumbleType.kRightRumble, right);
    }
}

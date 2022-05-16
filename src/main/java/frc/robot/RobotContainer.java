/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.ADIS16470_IMU;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.AutoAdvancedCommandGroup;
import frc.robot.commands.AutoBasicCommandGroup;
import frc.robot.commands.AutoDriveCommand;
import frc.robot.commands.AutoDriveToBallCommand;
import frc.robot.commands.BUTTONShootBallCommand;
import frc.robot.commands.BallManipulateCommand;
import frc.robot.commands.BallOverrideCommand;
import frc.robot.commands.ClimberLowerCommand;
import frc.robot.commands.ClimberRaiseCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.DriveShiftGearCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeBallCommand;
import frc.robot.commands.IntakeLiftCommand;
import frc.robot.commands.MoveBallCommandGroup;
import frc.robot.commands.ResetBallCountCommand;
import frc.robot.commands.ShootBallCommand;
import frc.robot.commands.TurretSpinLeftCommand;
import frc.robot.commands.TurretSpinRightCommand;
import frc.robot.subsystems.BallCounterSubsystem;
import frc.robot.subsystems.BallManipulatorSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TurretSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...


  public final BallCounterSubsystem m_ballCounterSubsystem = new BallCounterSubsystem();
  public final BallManipulatorSubsystem m_ballManipulatorSubsystem = new BallManipulatorSubsystem();
  public final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();
  public final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
  public final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  public final LimelightSubsystem m_limelightSubsystem = new LimelightSubsystem();
  public final ShooterSubsystem m_shooterSubsystem  = new ShooterSubsystem();
  public final TurretSubsystem m_turretSubsystem = new TurretSubsystem();

  public final AutoBasicCommandGroup m_autoBasicCommandGroup = new AutoBasicCommandGroup(m_drivetrainSubsystem, m_shooterSubsystem, m_ballManipulatorSubsystem, m_ballCounterSubsystem, m_intakeSubsystem, m_limelightSubsystem, m_turretSubsystem);
  public final AutoAdvancedCommandGroup m_autoAdvancedCommandGroup = new AutoAdvancedCommandGroup(m_drivetrainSubsystem, m_shooterSubsystem, m_ballManipulatorSubsystem, m_ballCounterSubsystem, m_intakeSubsystem, m_limelightSubsystem, m_turretSubsystem);

  public final AutoDriveCommand m_autoDriveCommand = new AutoDriveCommand(m_drivetrainSubsystem);
  public final AutoDriveToBallCommand m_autoDriveToBallCommand = new AutoDriveToBallCommand(m_drivetrainSubsystem, m_ballCounterSubsystem, Robot.ourFieldPosition);
  public final BallOverrideCommand m_ballOverrideCommand = new BallOverrideCommand(m_ballManipulatorSubsystem, m_ballCounterSubsystem, m_intakeSubsystem);
  public final BallManipulateCommand m_ballManipulateCommand = new BallManipulateCommand(m_intakeSubsystem, m_ballManipulatorSubsystem, m_ballCounterSubsystem);
  public final ClimberLowerCommand m_climberLowerCommand = new ClimberLowerCommand(m_climberSubsystem);
  public final ClimberRaiseCommand m_climberRaiseCommand = new ClimberRaiseCommand(m_climberSubsystem);
  public final DriveCommand m_driveCommand = new DriveCommand(m_drivetrainSubsystem);
  public final DriveShiftGearCommand m_driveShiftGearCommand = new DriveShiftGearCommand(m_drivetrainSubsystem);
  public final IntakeBallCommand m_intakeBallCommand = new IntakeBallCommand(m_intakeSubsystem, m_ballCounterSubsystem);
  public final IntakeLiftCommand m_intakeLiftCommand = new IntakeLiftCommand(m_intakeSubsystem);
  public final MoveBallCommandGroup m_moveBallCommand = new MoveBallCommandGroup(m_ballManipulatorSubsystem, m_ballCounterSubsystem, m_intakeSubsystem);
  public final ResetBallCountCommand m_resetBallCountCommand = new ResetBallCountCommand(m_ballCounterSubsystem);
  public final ShootBallCommand m_shootBallCommand = new ShootBallCommand(m_shooterSubsystem, 
      m_ballManipulatorSubsystem, m_ballCounterSubsystem, m_intakeSubsystem, m_limelightSubsystem, m_turretSubsystem);
  public final BUTTONShootBallCommand m_BUTTONShootBallCommand = new BUTTONShootBallCommand(m_ballManipulatorSubsystem, m_shooterSubsystem, m_intakeSubsystem);
  // public final TurretSetAngleCommand m_turretSetAngleCommand = new TurretSetAngleCommand(m_limelightSubsystem, m_turretSubsystem);
  // public final TurretSpinCommand m_turretSpinCommand = new TurretSpinCommand(m_turretSubsystem);
  public final TurretSpinLeftCommand m_turretSpinLeftCommand = new TurretSpinLeftCommand(m_turretSubsystem);
  public final TurretSpinRightCommand m_turretSpinRightCommand = new TurretSpinRightCommand(m_turretSubsystem);
    
    public Joystick driveStick = new Joystick(0);
    public XboxController xboxController = new XboxController(1);

    public Button driveStick1Button = new JoystickButton(driveStick, 1);
    public Button driveStick2Button = new JoystickButton(driveStick, 2);
    public Button driveStick3Button = new JoystickButton(driveStick, 3);
    public Button driveStick4Button = new JoystickButton(driveStick, 4);
    public Button driveStick5Button = new JoystickButton(driveStick, 5);
    public Button driveStick6Button = new JoystickButton(driveStick, 6);
    public Button driveStick7Button = new JoystickButton(driveStick, 7);
    public Button driveStick8Button = new JoystickButton(driveStick, 8);
    public Button driveStick9Button = new JoystickButton(driveStick, 9);
    public Button driveStick10Button = new JoystickButton(driveStick, 10);
    public Button driveStick11Button = new JoystickButton(driveStick, 11);
    public Button driveStick12Button = new JoystickButton(driveStick, 12);  
  
    public Button xboxControllerAButton = new JoystickButton(xboxController, 1);
    public Button xboxControllerBButton = new JoystickButton(xboxController, 2);
    public Button xboxControllerXButton = new JoystickButton(xboxController, 3);
    public Button xboxControllerYButton = new JoystickButton(xboxController, 4);
    public Button xboxControllerLBButton = new JoystickButton(xboxController, 5);
    public Button xboxControllerRBButton = new JoystickButton(xboxController, 6);  
    public Button xboxControllerBackButton = new JoystickButton(xboxController, 7);
    public Button xboxControllerStartButton = new JoystickButton(xboxController, 8);
    public Button xboxControllerLeftStickButton = new JoystickButton(xboxController, 9);
    public Button xboxControllerRightStickButton = new JoystickButton(xboxController, 10);
  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();    
    CommandScheduler.getInstance().setDefaultCommand(m_drivetrainSubsystem, m_driveCommand);
    //CommandScheduler.getInstance().setDefaultCommand(m_intakeSubsystem, m_intakeBallCommand);
    //CommandScheduler.getInstance().setDefaultCommand(m_ballManipulatorSubsystem, m_ballManipulateCommand);
  }

/**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * 
   * 
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first
   * .wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driveStick11Button.whileHeld(m_turretSpinLeftCommand);
    driveStick12Button.whileHeld(m_turretSpinRightCommand);
    xboxControllerAButton.whileHeld(m_BUTTONShootBallCommand);
    //xboxControllerBButton.toggleWhenPressed(m_shootBallCommand);
    xboxControllerBButton.whenPressed(m_intakeLiftCommand);
    xboxControllerXButton.whileHeld(m_intakeBallCommand);
    xboxControllerYButton.toggleWhenPressed(m_ballManipulateCommand);
    xboxControllerLBButton.whileHeld(m_climberLowerCommand);
    xboxControllerRBButton.whileHeld(m_climberRaiseCommand);
    xboxControllerStartButton.whenPressed(m_ballOverrideCommand);
    xboxControllerBackButton.whileHeld(m_ballOverrideCommand);
    driveStick2Button.whenPressed(m_driveShiftGearCommand);
    driveStick9Button.whenPressed(m_resetBallCountCommand);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous00
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoBasicCommandGroup;
    // return m_autoAdvancedCommandGroup; CHANGE TO THIS WHEN TESTING ADVANCED AUTO
  }
}

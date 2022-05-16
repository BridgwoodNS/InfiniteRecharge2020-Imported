/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallCounterSubsystem;
import frc.robot.subsystems.BallManipulatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class BallManipulateCommand extends CommandBase {
  /**
   * Creates a new BallManipulateCommand.
   */
  public IntakeSubsystem m_intakeSubsystem;
  public BallManipulatorSubsystem m_ballManipulatorSubsystem;
  public BallCounterSubsystem m_ballCounterSubsystem;
  int ballCount;
  String sensors;
  int motors;

  public BallManipulateCommand(IntakeSubsystem intakeSubsystem, BallManipulatorSubsystem ballManipulatorSubsystem, BallCounterSubsystem ballCounterSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_intakeSubsystem = intakeSubsystem;
    m_ballManipulatorSubsystem = ballManipulatorSubsystem;
    m_ballCounterSubsystem = ballCounterSubsystem;
    addRequirements(ballManipulatorSubsystem);
    SmartDashboard.putString("test" ,"");
    SmartDashboard.putString("sensor string", "");

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //ballCount = m_ballCounterSubsystem.getBallsInRobot();
    sensors = m_ballCounterSubsystem.getSensorValues();
    motors = m_ballCounterSubsystem.getMotorsBasedOnBalls(sensors);
    //SmartDashboard.putString("test" ,m_ballManipulatorSubsystem.manipulate(ballCount, sensors));
    SmartDashboard.putString("motors", "" + motors);
    System.out.println(motors);
    m_intakeSubsystem.autoBallIntakeMotors(motors, m_intakeSubsystem.intakePosition());
    m_ballManipulatorSubsystem.autoBallManipulatorMotors(motors);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intakeSubsystem.setIntakeMotor(0);
    m_intakeSubsystem.setSingulatorMotor(0);
    m_ballManipulatorSubsystem.setBallIndexerMotor(0);
    m_ballManipulatorSubsystem.setConveyorMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

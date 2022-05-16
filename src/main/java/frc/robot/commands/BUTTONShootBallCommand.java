/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallManipulatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class BUTTONShootBallCommand extends CommandBase {
  /**
   * Creates a new BUTTONShootBallCommand.
   */
  public BallManipulatorSubsystem m_ballManipulatorSubsystem;
  public ShooterSubsystem m_shooterSubsystem;
  public IntakeSubsystem m_intakeSubsystem;

  public BUTTONShootBallCommand(BallManipulatorSubsystem ballManipulatorSubsystem, ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem){
    m_ballManipulatorSubsystem = ballManipulatorSubsystem;
    m_shooterSubsystem = shooterSubsystem;
    m_intakeSubsystem = intakeSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_ballManipulatorSubsystem.setConveyorMotor(-1);
    m_ballManipulatorSubsystem.setBallIndexerMotor(1);
    m_shooterSubsystem.setShooterMotor(-1);
    m_intakeSubsystem.setSingulatorMotor(1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_ballManipulatorSubsystem.setConveyorMotor(0);
    m_ballManipulatorSubsystem.setBallIndexerMotor(0);
    m_shooterSubsystem.setShooterMotor(0);
    m_intakeSubsystem.setSingulatorMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class AutoDriveCommand extends CommandBase {
  /**
   * Creates a new AutoDriveCommand.
   */
  private final DrivetrainSubsystem m_drivetrainSubsystem;
  public AutoDriveCommand(DrivetrainSubsystem drivetrainSubsystem) {
    m_drivetrainSubsystem = drivetrainSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double initialCount = m_drivetrainSubsystem.getEncoderCount();
    double currentCount = initialCount;
    int totalCount = 4096; //Need to fix value when we determine how far to move
    while(currentCount - initialCount < totalCount){
      currentCount = m_drivetrainSubsystem.getEncoderCount();
      m_drivetrainSubsystem.motorSpeed();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

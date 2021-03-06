/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.subsystems.BallCounterSubsystem;
import frc.robot.subsystems.BallManipulatorSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TurretSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoAdvancedCommandGroup extends SequentialCommandGroup {
  /**
   * Creates a new AutoAdvancedCommandGroup.
   */
  public AutoAdvancedCommandGroup(DrivetrainSubsystem drivetrainSubsystem, ShooterSubsystem shooterSubsystem, BallManipulatorSubsystem ballManipulatorSubsystem, 
  BallCounterSubsystem ballCounterSubsystem, IntakeSubsystem intakeSubsystem, LimelightSubsystem limelightSubsystem, TurretSubsystem turretSubsystem){
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super();
    addCommands(
     new AutoBasicCommandGroup(drivetrainSubsystem, shooterSubsystem, ballManipulatorSubsystem, ballCounterSubsystem, intakeSubsystem, limelightSubsystem, turretSubsystem),
      new ParallelCommandGroup(
        new AutoDriveToBallCommand(drivetrainSubsystem, ballCounterSubsystem, Robot.ourFieldPosition),
        new IntakeBallCommand(intakeSubsystem, ballCounterSubsystem)),
      new ShootBallCommand(shooterSubsystem, ballManipulatorSubsystem, ballCounterSubsystem, intakeSubsystem, limelightSubsystem, turretSubsystem)
    );

  }
}

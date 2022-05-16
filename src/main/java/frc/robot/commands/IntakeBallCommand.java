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
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeBallCommand extends CommandBase {
  /**
   * Creates a new IntakeBallCommand.
   */

   private final IntakeSubsystem m_intakeSubsystem;
   private final BallCounterSubsystem m_ballCounterSubsystem;
   int ballsInRobot;
   private boolean finished;
   

  public IntakeBallCommand(IntakeSubsystem intakeSubsystem, BallCounterSubsystem ballCounterSubsystem) {
    m_intakeSubsystem = intakeSubsystem;
    m_ballCounterSubsystem = ballCounterSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intakeSubsystem);
    SmartDashboard.putString("intake" ,"");

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {    
    //m_intakeSubsystem.setIntakePosition(true);//Might need to change to false
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //int ballCount = m_ballCounterSubsystem.getBallsInRobot();
    //int ballInIntake = m_ballCounterSubsystem.getEntrySensorValue();
    //boolean intakePosition = m_intakeSubsystem.intakePosition();
    if(m_intakeSubsystem.intakePosition()){
      m_intakeSubsystem.setIntakeMotor(1);
    }
    //finished = m_intakeSubsystem.intakeBalls(ballCount, ballInIntake, intakePosition);
    //m_intakeSubsystem.autoBallIntakeMotors(m_ballCounterSubsystem.getMotorsBasedOnBalls(), intakePosition);
    SmartDashboard.putString("intake" ,"on");

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intakeSubsystem.setIntakeMotor(0);
    //m_intakeSubsystem.setIntakePosition(false);
    SmartDashboard.putString("intake" ," off");

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

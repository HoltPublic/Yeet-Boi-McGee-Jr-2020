/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Drivetrain;

public class DriveSoFar extends CommandBase {
  private final Drivetrain drive;
  private final double time;
  private final double speed;
  private boolean isdone;
  WaitCommand waitCommand;

  /**
   * Creates a new DriveSoFar.
   */
  public DriveSoFar(double timeYallWant, double speedYallWant, Drivetrain driveIGuess) {
    // Use addRequirements() here to declare subsystem dependencies.
    time = timeYallWant;
    speed = speedYallWant;
    drive = driveIGuess;
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drive.arcadeDrive(speed, 0);
    isdone = false;
    waitCommand = new WaitCommand(time);
    waitCommand.schedule();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(waitCommand.isFinished()){
      isdone = true;
    }else{
      isdone = false;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isdone;
  }
}

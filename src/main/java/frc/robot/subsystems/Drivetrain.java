/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */
  WPI_VictorSPX rightVictor1 = new WPI_VictorSPX(DriveConstants.rightVictor1CAN);
  WPI_VictorSPX rightVictor2 = new WPI_VictorSPX(DriveConstants.rightVictor2CAN);
  WPI_VictorSPX leftVictor1 = new WPI_VictorSPX(DriveConstants.leftVictor1CAN);
  WPI_VictorSPX leftVictor2 = new WPI_VictorSPX(DriveConstants.leftVictor2CAN);

  WPI_TalonFX testFalcon = new WPI_TalonFX(69);


  DifferentialDrive weBeDriftingBois = new DifferentialDrive(leftVictor1, rightVictor1);

  public Drivetrain() {
    rightVictor1.configFactoryDefault();
    rightVictor2.configFactoryDefault();
    leftVictor1.configFactoryDefault();
    leftVictor2.configFactoryDefault();

    rightVictor2.follow(rightVictor1);
    leftVictor2.follow(leftVictor1);

    weBeDriftingBois.setRightSideInverted(true);

    rightVictor1.setInverted(false);
    rightVictor2.setInverted(InvertType.FollowMaster);
    leftVictor1.setInverted(false);
    leftVictor2.setInverted(InvertType.FollowMaster);

  }

  public void telopDrive(double speed, double rotation){
    weBeDriftingBois.arcadeDrive(speed, rotation);
  }

  public void setMaxSpeed(double maxSpeed){
    weBeDriftingBois.setMaxOutput(maxSpeed);
  }

  public void arcadeDrive(double fwd, double rot){
    weBeDriftingBois.arcadeDrive(fwd, rot);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

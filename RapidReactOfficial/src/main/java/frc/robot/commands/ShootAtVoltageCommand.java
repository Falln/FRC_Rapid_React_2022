// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.ConstantsValues;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootAtVoltageCommand extends CommandBase {

  double voltage;
  ShooterSubsystem shooterSubsystem;

  public ShootAtVoltageCommand(double voltage, ShooterSubsystem shooterSubsystem) {
    this.voltage = voltage;
    this.shooterSubsystem = shooterSubsystem;
    addRequirements(shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterSubsystem.setFlywheelVoltage(voltage);
    shooterSubsystem.setKickwheelVoltage(ConstantsValues.defaultKickwheelVoltage);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.stopAll();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

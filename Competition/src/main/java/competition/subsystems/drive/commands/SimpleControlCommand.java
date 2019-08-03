package competition.subsystems.drive.commands;

import com.google.inject.Inject;

import competition.operator_interface.OperatorInterface;
import competition.subsystems.drive.DriveSubsystem;
import xbot.common.command.BaseCommand;

public class SimpleControlCommand extends BaseCommand {

    DriveSubsystem drive;
    OperatorInterface oi;

    @Inject
    public SimpleControlCommand(DriveSubsystem drive, OperatorInterface oi) {
        this.drive = drive;
        this.oi = oi;
        requires(drive);
    }

    @Override
    public void initialize() {
        log.info("Initializing");
    }

    @Override
    public void execute() {
        double one = oi.gamepad.getLeftVector().y;
        double two = oi.gamepad.getRightVector().y;
        boolean positive = oi.gamepad.getLeftTrigger() > 0.5;
        boolean negative = oi.gamepad.getRightTrigger() > 0.5;

        drive.analogPower(one, two);
        drive.digitalPower(positive, negative);
    }

}
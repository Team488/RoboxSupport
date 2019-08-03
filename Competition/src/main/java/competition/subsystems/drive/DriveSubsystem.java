package competition.subsystems.drive;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.apache.log4j.Logger;

import xbot.common.command.BaseSubsystem;
import xbot.common.controls.actuators.XSpeedController;
import xbot.common.injection.wpi_factories.CommonLibFactory;
import xbot.common.properties.XPropertyManager;

@Singleton
public class DriveSubsystem extends BaseSubsystem {
    private static Logger log = Logger.getLogger(DriveSubsystem.class);

    public final XSpeedController deviceOne;
    public final XSpeedController deviceTwo;
    public final XSpeedController deviceThree;

    @Inject
    public DriveSubsystem(CommonLibFactory factory, XPropertyManager propManager) {
        log.info("Creating DriveSubsystem");

        this.deviceOne = factory.createSpeedController(1);
        this.deviceTwo = factory.createSpeedController(2);
        this.deviceThree = factory.createSpeedController(3);
    }

    public void analogPower(double one, double two) {
        deviceOne.setPower(one);
        deviceTwo.setPower(two);
    }

    public void digitalPower(boolean positive, boolean negative) {
        double power = 0;
        if (negative) {
            power = -1;
        }
        if (positive) {
            power = 1;
        }

        deviceThree.setPower(power);
    }
}

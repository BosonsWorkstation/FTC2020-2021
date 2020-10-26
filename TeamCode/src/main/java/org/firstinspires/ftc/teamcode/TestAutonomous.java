package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous(name="TestAutonomous2", group = "Linear OpMode")
public class TestAutonomous extends LinearOpMode {
    private OmniDriveTrainV2 autoOmni;
    private static final long INITIAL_WAIT = 1000;
    private final OmniDriveTrainV2.DirectionEnum direction = OmniDriveTrainV2.DirectionEnum.NORTH;

    @Override
    public void runOpMode() throws InterruptedException {
        this.autoOmni = new OmniDriveTrainV2(this.hardwareMap, this.telemetry, this.direction);
        this.autoOmni.initializeMotors(this.hardwareMap, this.telemetry);
        ColorSensor color_sensor;
        color_sensor = hardwareMap.colorSensor.get("color_sensor");



        waitForStart();
        while (opModeIsActive()) {
            this.autoOmni.drive(4, 3, 0);

            Thread.sleep(1000);
            this.stop();
            telemetry.addData("Blue Value: ", color_sensor.blue());
            telemetry.update();

        }
    }



    }



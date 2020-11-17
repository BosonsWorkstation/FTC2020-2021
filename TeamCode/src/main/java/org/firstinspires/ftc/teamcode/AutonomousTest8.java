package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="TestAutonomous8", group = "Linear OpMode")
public class AutonomousTest8 extends LinearOpMode {
    private AutonomousDriveTest autoOmni;
    private static final long INITIAL_WAIT = 1000;
    private final AutoOmniDriveTrain.DirectionEnum direction = AutoOmniDriveTrain.DirectionEnum.NORTH;

    @Override
    public void runOpMode() throws InterruptedException {
        this.autoOmni = new AutonomousDriveTest(this.hardwareMap, this.telemetry);
        ColorSensor color_sensor;
        color_sensor = hardwareMap.colorSensor.get("color_sensor");



        this.autoOmni.autoDrive(5000);

        waitForStart();


        //            if (color_sensor.blue() > 4000 && color_sensor.green() > 4000 && color_sensor.red() > 4000){
//                this.autoOmni.stop();
//            }

        while (opModeIsActive()) {
            this.autoOmni.drive();

            telemetry.addData("Blue Value: ", color_sensor.blue());
            telemetry.addData("Green Value: ", color_sensor.green());
            telemetry.addData("Red Value: ", color_sensor.red());
            telemetry.update();
            sleep(100);


        }

    }



}



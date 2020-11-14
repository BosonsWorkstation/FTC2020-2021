package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous(name="TestAutonomous2", group = "Linear OpMode")
public class TestAutonomous extends LinearOpMode {
    private AutoOmniDriveTrain autoOmni;
    private static final long INITIAL_WAIT = 1000;
    private final AutoOmniDriveTrain.DirectionEnum direction = AutoOmniDriveTrain.DirectionEnum.NORTH;

    @Override
    public void runOpMode() throws InterruptedException {
        this.autoOmni = new AutoOmniDriveTrain(this.hardwareMap, this.telemetry, this.direction);
        this.autoOmni.initializeMotors(this.hardwareMap, this.telemetry);
        ColorSensor color_sensor;
        color_sensor = hardwareMap.colorSensor.get("color_sensor");




        waitForStart();
        this.autoOmni.crabbingDistance(5);
        //            if (color_sensor.blue() > 4000 && color_sensor.green() > 4000 && color_sensor.red() > 4000){
//                this.autoOmni.stop();
//            }

        while (opModeIsActive()) {
            telemetry.addData("Blue Value: ", color_sensor.blue());
            telemetry.addData("Green Value: ", color_sensor.green());
            telemetry.addData("Red Value: ", color_sensor.red());
            telemetry.update();
            sleep(100);


        }

    }



    }



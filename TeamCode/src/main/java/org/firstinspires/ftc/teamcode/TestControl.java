package org.firstinspires.ftc.teamcode;

import android.text.method.Touch;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "Control Hub Test", group = "Linear OpMode")
public class TestControl extends LinearOpMode {
    private static final OmniDriveTrainV2.DirectionEnum direction = OmniDriveTrainV2.DirectionEnum.SOUTH;
    private OmniDriveTrainV2 driveTrain2;
    DcMotor backRightWheel;
    DcMotor backLeftWheel;
    DcMotor frontRightWheel;
    DcMotor frontLeftWheel;


    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor test_motor;
        ColorSensor color_sensor;
        TouchSensor touch_sensor;
        this.driveTrain2 = new OmniDriveTrainV2(this.hardwareMap, this.telemetry,direction);

        touch_sensor = hardwareMap.touchSensor.get("touch_sensor");
        color_sensor = hardwareMap.colorSensor.get("color_sensor");
       waitForStart();

       while (opModeIsActive()) {


          if (color_sensor.red() > 3000 && color_sensor.blue() > 3000 && color_sensor.green() > 3000) {
                this.driveTrain2.stop();
          }



           double crabValue = 0;
           double moveValue = 0;
           double turnValue = 0;

           crabValue = -gamepad1.left_stick_x;
           moveValue = gamepad1.left_stick_y;
           turnValue = gamepad1.right_stick_x;

           if (Math.abs(moveValue) < 0.1 && Math.abs(crabValue) < 0.1 && Math.abs(crabValue) < 0.1) {
               this.driveTrain2.stop();
           }


           this.driveTrain2.drive(crabValue, moveValue, turnValue);
           idle();


           telemetry.addData("Is pressed", touch_sensor.isPressed());
           telemetry.addData("Touch Sensor Value", touch_sensor.getValue());
           telemetry.addData("Blue Value: ", color_sensor.blue());
           telemetry.addData("Red Value: ", color_sensor.red());
           telemetry.addData("Green Value: ", color_sensor.green());
           telemetry.update();
       }
        }
    }


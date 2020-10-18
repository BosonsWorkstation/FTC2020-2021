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
    public void initializeMotors() {
        DcMotor test_motor;
        ColorSensor color_sensor;
        test_motor = hardwareMap.dcMotor.get("test_motor");
        color_sensor = hardwareMap.colorSensor.get("color_sensor");
        test_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor test_motor;
        ColorSensor color_sensor;
        TouchSensor touch_sensor;
        touch_sensor = hardwareMap.touchSensor.get("touch_sensor");
        test_motor = hardwareMap.dcMotor.get("test_motor");
        color_sensor = hardwareMap.colorSensor.get("color_sensor");
        test_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       waitForStart();

       while (opModeIsActive()) {
           //if (gamepad1.right_trigger > 0){

           //  test_motor.setPower(1);
           //}
           //if (gamepad1.right_trigger < .5){
           //  test_motor.setPower(0);
           //}


          //if (color_sensor.red() > 3000 && color_sensor.blue() > 3000 && color_sensor.green() > 3000) {
              // test_motor.setPower(1);

         //  } else {
            //   test_motor.setPower(0);
           //}

           if (touch_sensor.isPressed()){
               test_motor.setPower(1);
           }else{
               test_motor.setPower(0);
           }

           telemetry.addData("Red Value", color_sensor.red());
           telemetry.addData("Blue Value", color_sensor.blue());
           telemetry.addData("Green Value", color_sensor.green());
           telemetry.addData("Is pressed", touch_sensor.isPressed());
           telemetry.addData("Touch Sensor Value", touch_sensor.getValue());
           telemetry.update();
       }
        }
    }


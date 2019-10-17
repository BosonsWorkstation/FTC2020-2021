package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.TouchSensor;



@Autonomous(name="Touch Sensor Test", group="Linear OpMode")
public class TouchSensorTest extends AbstractSensorTest
{

    TouchSensor touch = null;


    @Override
    void initializeSensor(){
        touch = hardwareMap.touchSensor.get("Touch Sensor");
    }

    @Override
    void waitForSensor() {

        while (!touch.isPressed()) {
            idle();
            telemetry.addData("touch", "waiting");
            telemetry.update();

        }
        telemetry.addData("touch", "done");
        telemetry.update();
    }
}

//     called when init button is  pressed.
//    @Override
//    public void runOpMode() throws InterruptedException
//    {
//        this.initialize();
//
//        touch = hardwareMap.touchSensor.get("Touch Sensor");
//
//        telemetry.addData("Mode", "waiting");
//        telemetry.update();
//
//        // wait for start button.
//
//
//
//        waitForStart();
//
//
//
//
//        telemetry.addData("Mode", "running");
//        telemetry.update();
//
//        this.drive();
//
//        resetStartTime();
//        // drive until touch sensor button pressed or 5 seconds passes.
//
//        while (!touch.isPressed()) {
//            idle();
//            telemetry.addData("touch", "waiting");
//            telemetry.update();
//
//        }
//        telemetry.addData("touch", "done");
//        telemetry.update();
//        // turn the motors off.
//
//        this.stopMotors();
//
//
//    }
//}

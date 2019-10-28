package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public abstract class AbstractSensorTest extends LinearOpMode {

    DcMotor leftMotor;
    DcMotor     rightMotor;
    Servo clawArm;
    protected void initialize(){
        leftMotor = hardwareMap.dcMotor.get("Left Wheel");
        rightMotor = hardwareMap.dcMotor.get("Right Wheel");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        clawArm = hardwareMap.servo.get("Claw Arm");
        this.initializeSensor();
    }


    protected void drive(){

        leftMotor.setPower(-.75);
        rightMotor.setPower(-.75);

    }
    protected void stopMotors(){
        leftMotor.setPower(0);
        rightMotor.setPower(0);

    }

    abstract void waitForSensor();
    abstract void initializeSensor();

    @Override
    public void runOpMode() throws InterruptedException
    {
        this.initialize();

//        touch = hardwareMap.touchSensor.get("Touch Sensor");

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.



        waitForStart();

        drive();


        telemetry.addData("Mode", "running");
        telemetry.update();



        resetStartTime();

        // drive until touch sensor button pressed or 5 seconds passes.

        waitForSensor();
        idle();
        clawArm.setPosition(10);
        clawArm.setPosition(10);


    }

}

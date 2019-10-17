package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public abstract class AbstractSensorTest extends LinearOpMode {

    DcMotor leftMotor;
    DcMotor     rightMotor;
    protected void initialize(){
        leftMotor = hardwareMap.dcMotor.get("Left Wheel");
        rightMotor = hardwareMap.dcMotor.get("Right Wheel");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        this.initializeSensor();
    }


    protected void drive(double power){

        leftMotor.setPower(power);
        rightMotor.setPower(power);

    }
    protected void stopMotors(){
        this.drive(0.0);

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




        telemetry.addData("Mode", "running");
        telemetry.update();

        this.drive(0.75);

        resetStartTime();
        // drive until touch sensor button pressed or 5 seconds passes.

        waitForSensor();
        this.stopMotors();


    }

}

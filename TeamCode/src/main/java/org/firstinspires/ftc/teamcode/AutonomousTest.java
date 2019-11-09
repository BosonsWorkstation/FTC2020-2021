package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous(name="AutonomousTest", group="Linear OpMode")

public abstract class AutonomousTest extends LinearOpMode {

        DcMotor leftMotor;
        DcMotor     rightMotor;
        TouchSensor  touch;
        Servo clawArm;
        protected void initialize(){
            leftMotor = hardwareMap.dcMotor.get("Left Wheel");
            rightMotor = hardwareMap.dcMotor.get("Right Wheel");
            leftMotor.setDirection(DcMotor.Direction.REVERSE);
            clawArm = hardwareMap.servo.get("Claw Arm");

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

             touch = hardwareMap.touchSensor.get("Touch Sensor");

            telemetry.addData("Mode", "waiting");
            telemetry.update();


            // wait for start button.



            waitForStart();




            telemetry.addData("Mode", "running");
            telemetry.update();

            this.drive(0.75);


            // drive until touch sensor button pressed or 5 seconds passes.
            waitForSensor();
            idle();
            clawArm.setPosition(0.6);
            clawArm.setPosition(-0.6);
            sleep(3000);

        }

    }



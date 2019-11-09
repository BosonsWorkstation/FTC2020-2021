package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous(name="Testbot Autonomous Test")

public class Testbot_Autonomous_Test extends LinearOpMode{
    //declare motors
    DcMotor leftWheel = null;
    DcMotor rightWheel = null;
    DcMotor clawArm = null;

    //declare servos
    Servo claw = null;

    @Override public void runOpMode() throws InterruptedException {
        //initialize motors
        leftWheel = hardwareMap.dcMotor.get("Left Wheel");
        rightWheel = hardwareMap.dcMotor.get("Right Wheel");
        clawArm = hardwareMap.dcMotor.get("Claw Arm");
        clawDown(0.1, 100);


        //initialize servos
        claw = hardwareMap.servo.get("Claw");
        claw.setPosition(0.3);

        leftWheel.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        forwardTime(0.5, 1300);

        rightTime(0.5, 600);

        forwardTime(0.5, 2000);

        leftTime(0.5, 600);

        forwardTime(0.2, 800);
        //straighten out on the lip
        forwardTime(.1, 2000);

        forwardTime(0.2, 2000);

        clawUpTime(0.5, 1000);

        rightTime(0.5, 620);

        forwardTime(0.5, 1300);


    }
        public void forwardTime(double power, long time) throws InterruptedException{
            leftWheel.setPower(power);
            rightWheel.setPower(power);
            Thread.sleep(time);
        }
        public void rightTime(double power, long time) throws InterruptedException{
        leftWheel.setPower(power);
        rightWheel.setPower(-power);
        Thread.sleep(time);
        }
        public void leftTime(double power, long time) throws InterruptedException{
        leftWheel.setPower(power);
        leftWheel.setPower(-power);
        Thread.sleep(time);
        }
        public void clawUpTime(double power, long time) throws InterruptedException{
        clawArm.setPower(power);
        Thread.sleep(time);
        }
        public void clawDown(double power, long time) throws InterruptedException{
        clawArm.setPower(-power);
        Thread.sleep(time);
        }
        public void openClaw(){
        claw.setPosition(0);
        }
        public void closeClaw(){
        claw.setPosition(0.8);
        }

    }

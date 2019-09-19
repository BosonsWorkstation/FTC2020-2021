package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;



    @TeleOp(name = "Test OP Mode", group = "Linear Opmode")
    public class MyFIRSTJavaOpMode extends LinearOpMode {
        private DcMotor RightWheel;
        private DcMotor LeftWheel;
        private DcMotor ClawArm;
        private Servo Claw;
        private ElapsedTime runtime = new ElapsedTime();

        @Override
        public void runOpMode() {
            telemetry.addData("Status", "Initializing");
            telemetry.update();

            RightWheel = hardwareMap.dcMotor.get("Right Wheel");
            LeftWheel = hardwareMap.dcMotor.get("Left Wheel");
            ClawArm = hardwareMap.dcMotor.get("Claw Arm");
            Claw = hardwareMap.servo.get("Claw");

            LeftWheel.setDirection(DcMotor.Direction.FORWARD);
            RightWheel.setDirection(DcMotor.Direction.REVERSE);

            telemetry.addData("Status", "Initialized");
            telemetry.update();
            //Driver Presses Play
            waitForStart();
            //run
            double LeftPower = 0.0;
            double RightPower = 0.0;
            double ClawUpPower = 0.0;
            while (opModeIsActive()) {
                double drive = -gamepad1.left_stick_y;
                double turn = -gamepad1.right_stick_x;
                double ClawUp = -gamepad2.left_stick_y;
                double ClawClose = -gamepad2.right_trigger;
                double ClawOpen = -gamepad2.left_trigger;

                LeftPower = Range.clip(drive + turn, -1, 1);
                RightPower = Range.clip(drive - turn, -1, 1);
                ClawUpPower = Range.clip(ClawUp, -1, 1);
                LeftWheel.setPower(LeftPower);
                RightWheel.setPower(RightPower);
                ClawArm.setPower(ClawUpPower);

                //servo
                if (gamepad1.y) {
                    Claw.setPosition(1.0);
                }
                else if (gamepad1.a) {
                    Claw.setPosition(1.0);
                }
                telemetry.addData("Target Power", RightPower);
                telemetry.addData("Target Power", LeftPower);
                telemetry.addData("Motor Power", RightWheel.getPower());
                telemetry.addData("Motor Power", LeftWheel.getPower());
                telemetry.addData("ServoPosition", Claw.getPosition());
                telemetry.addData("runtime", runtime.toString());
                telemetry.addData("Status", "Running");
                telemetry.addData("Motors", "left (%.2f), right (%.2f)", LeftPower, RightPower);
                telemetry.update();
            }
        }
    }


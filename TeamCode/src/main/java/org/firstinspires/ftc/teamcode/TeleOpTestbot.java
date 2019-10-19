
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;



@TeleOp(name = "Testbot TeleOp", group = "Linear Opmode")
public class TeleOpTestbot extends LinearOpMode {
    private DcMotor rightWheel;
    private DcMotor leftWheel;
    private Servo clawArm;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initializing");
        telemetry.update();

        rightWheel = hardwareMap.dcMotor.get("Right Wheel");
        leftWheel = hardwareMap.dcMotor.get("Left Wheel");
        clawArm = hardwareMap.servo.get("Claw Arm");

        leftWheel.setDirection(DcMotor.Direction.FORWARD);
        rightWheel.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        //Driver Presses Play
        waitForStart();
        //run
        double leftPower = 0.0;
        double rightPower = 0.0;
        double clawUpPower = 0.0;
        while (opModeIsActive()) {
            double drive = -gamepad1.left_stick_y;
            double turn = -gamepad1.right_stick_x;


            leftPower = Range.clip(drive + turn, -1, 1);
            rightPower = Range.clip(drive - turn, -1, 1);
            leftWheel.setPower(leftPower);
            rightWheel.setPower(rightPower);

            //servo
            if (gamepad1.y) {
                clawArm.setPosition(-10.0);
            } else if (gamepad1.a) {
                clawArm.setPosition(10.0);
            }
            telemetry.addData("Target Power", rightPower);
            telemetry.addData("Target Power", leftPower);
            telemetry.addData("Motor Power", rightWheel.getPower());
            telemetry.addData("Motor Power", leftWheel.getPower());
            telemetry.addData("Servo Position", clawArm.getPosition());
            telemetry.addData("runtime", runtime.toString());
            telemetry.addData("Status", "Running");
        }
        }
    }
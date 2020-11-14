package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@Autonomous(name="TestAutonomous3", group = "Linear OpMode")
public class AutonomousDriveTest extends LinearOpMode{
    DcMotor frontRightWheel;
    DcMotor frontLeftWheel;
    DcMotor backRightWheel;
    DcMotor backLeftWheel;
    private OmniDriveTrain driveTrain;
    private final AutoOmniDriveTrain.DirectionEnum direction = AutoOmniDriveTrain.DirectionEnum.NORTH;

    @Override
    public void runOpMode() throws InterruptedException {
        this.driveTrain = new OmniDriveTrain(this.hardwareMap, this.telemetry);

        this.frontRightWheel = hardwareMap.dcMotor.get("Front_Right_Wheel");
        this.frontLeftWheel = hardwareMap.dcMotor.get("Front_Left_Wheel");
        this.backLeftWheel = hardwareMap.dcMotor.get("Back_Left_Wheel");
        this.backRightWheel = hardwareMap.dcMotor.get("Back_Right_Wheel");
    }

    public void autoDrive() {

            frontRightWheel.setDirection(DcMotor.Direction.FORWARD);
            frontLeftWheel.setDirection(DcMotor.Direction.FORWARD);
            backLeftWheel.setDirection(DcMotor.Direction.REVERSE);
            backRightWheel.setDirection(DcMotor.Direction.REVERSE);

            frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            frontRightWheel.setTargetPosition(50);
            frontLeftWheel.setTargetPosition(50);
            backRightWheel.setTargetPosition(50);
            backLeftWheel.setTargetPosition(50);

            frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            waitForStart();

            frontRightWheel.setPower(.25);
            frontLeftWheel.setPower(.25);
            backRightWheel.setPower(.25);
            backLeftWheel.setPower(.25);
            while (opModeIsActive() && frontRightWheel.isBusy()) {
                telemetry.addData("FR Current Position", frontRightWheel.getCurrentPosition());
                telemetry.addData("FL Current Position", frontLeftWheel.getCurrentPosition());
                telemetry.addData("BR Current Position", backRightWheel.getCurrentPosition());
                telemetry.addData("BL Current Position", backLeftWheel.getCurrentPosition());
                telemetry.update();
                idle();
            }
            frontRightWheel.setPower(0);
            frontRightWheel.setPower(0);
            backRightWheel.setPower(0);
            backLeftWheel.setPower(0);
            resetStartTime();

//        frontRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        frontLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        backRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        backLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        }
    }




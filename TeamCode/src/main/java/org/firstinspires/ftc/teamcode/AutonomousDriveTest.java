package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import com.qualcomm.robotcore.hardware.HardwareMap;


public class AutonomousDriveTest{
    DcMotor frontRightWheel;
    DcMotor frontLeftWheel;
    DcMotor backRightWheel;
    DcMotor backLeftWheel;
    private OmniDriveTrain driveTrain;
    private final AutoOmniDriveTrain.DirectionEnum direction = AutoOmniDriveTrain.DirectionEnum.NORTH;

    public AutonomousDriveTest(HardwareMap hardwareMap, Telemetry telemetry) {
//        this.driveTrain = new OmniDriveTrain(this.hardwareMap, this.telemetry);

        this.frontRightWheel = hardwareMap.dcMotor.get("Front_Right_Wheel");
        this.frontLeftWheel = hardwareMap.dcMotor.get("Front_Left_Wheel");
        this.backLeftWheel = hardwareMap.dcMotor.get("Back_Left_Wheel");
        this.backRightWheel = hardwareMap.dcMotor.get("Back_Right_Wheel");
    }

    public void autoDrive(int distance) {

        frontRightWheel.setDirection(DcMotor.Direction.FORWARD);
        frontLeftWheel.setDirection(DcMotor.Direction.FORWARD);
        backRightWheel.setDirection(DcMotor.Direction.REVERSE);
        backLeftWheel.setDirection(DcMotor.Direction.REVERSE);


        frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRightWheel.setTargetPosition(distance);
        frontLeftWheel.setTargetPosition(distance);
        backRightWheel.setTargetPosition(distance);
        backLeftWheel.setTargetPosition(distance);

        frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    public void drive() {
        frontRightWheel.setPower(.25);
        frontLeftWheel.setPower(.25);
        backRightWheel.setPower(.25);
        backLeftWheel.setPower(.25);

        frontRightWheel.setPower(0);
        frontLeftWheel.setPower(0);
        backRightWheel.setPower(0);
        backLeftWheel.setPower(0);
    }
//        frontRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        frontLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        backRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        backLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        }





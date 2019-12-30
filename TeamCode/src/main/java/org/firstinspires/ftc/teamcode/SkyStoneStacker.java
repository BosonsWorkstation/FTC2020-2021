package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Hardware;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SkyStoneStacker {
    private static final double MOTOR_POWER = 0.5;
    private static final int HOMELEVELER = 1;
    private static final double HOMEPOSITIONER = 3;
    private static final double GRABBERHOLD = 2;
    private static final int DROPLEVELER = 2;

    private DcMotor levelerMotor;
    private Servo positioner;
    private Servo grabber;
    private int position;
    private Telemetry telemetry;

    public SkyStoneStacker(HardwareMap hardwareMap, Telemetry telemetry) {
        levelerMotor = hardwareMap.dcMotor.get("Leveler");
        levelerMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        positioner = hardwareMap.servo.get("Positioner");
        grabber = hardwareMap.servo.get("Grabber");
        this.telemetry = telemetry;
    }

    public void GoHome(){
        position = levelerMotor.getCurrentPosition();
        telemetry.addData("Encoder Position", position);
        levelerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        levelerMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        levelerMotor.setTargetPosition(HOMELEVELER);
        levelerMotor.setPower(1);
        positioner.setPosition(HOMEPOSITIONER);
    }
//    public void grabSkyStone() {
//
//        grabber.setPosition(GRABBERHOLD);
//
//    }
//    public void autoRaiseSkyStone() {
//        positioner.setPosition(-HOMEPOSITIONER);
//        levelerMotor.setTargetPosition(-HOMELEVELER);
//        levelerMotor.setPower(1);
//
//    }
//    public void autoDropSkyStone() {
//        levelerMotor.setTargetPosition(DROPLEVELER);
//        levelerMotor.setPower(1);
//        grabber.setPosition(-GRABBERHOLD);
//    }
//    public void positionSkyStone() {
//
////    }
//    public void raiseSkyStone() {
//        levelerMotor.setPower(1);
//
//    }
//    public void dropSkyStone() {
//        levelerMotor.setPower(-1);
//    }
}

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
    private static final int TICKS_PER_REV = 280;
    private static final int TRAVELANGLE = 45;
    private static final int MAX_TICKS = Math.round((TICKS_PER_REV / 360) * TRAVELANGLE * 4);
    private static final double MAX_POWER = 0.8;
    private static final double MIN_POWER = -0.2;
    private static final double POS_POWER = .2;

    public DcMotor levelerMotor;
    public DcMotor positioner;
    private Servo grabber;
    private int position;
    private Telemetry telemetry;
    private double servoPosition;
    private double positionPositioner;
    private boolean armInitialized = false;

    public SkyStoneStacker(HardwareMap hardwareMap, Telemetry telemetry) {
        levelerMotor = hardwareMap.dcMotor.get("Leveler");
//        levelerMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        positioner = hardwareMap.dcMotor.get("Positioner");
        grabber = hardwareMap.servo.get("Grabber");
//        this.initArm();
        this.telemetry = telemetry;
    }


    private void initArm(){
//        levelerMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        levelerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        positioner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        positioner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.stop();
        this.armInitialized = true;
    }

    public void GoHome(){
        position = levelerMotor.getCurrentPosition();
        telemetry.addData("Encoder Position", position);
        levelerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        levelerMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        levelerMotor.setTargetPosition(HOMELEVELER);
        levelerMotor.setPower(1);

    }

    public void close (){
        grabber.setPosition(1);
    }
    public void open (){
        grabber.setPosition(0);
    }

    public void stopPositioner() {
        positioner.setPower(0);
    }

    public void positionerRight() {
        positioner.setPower(POS_POWER);
    }


    public void positionerLeft() {
        positioner.setPower(-POS_POWER);
    }

//    }
    public void raiseArm(){
            levelerMotor.setPower(MAX_POWER);
    }


    public void lowerArm(){
            levelerMotor.setPower(MIN_POWER);
    }
    public void stop(){
        levelerMotor.setPower(0);
    }

    public void positionerStop(){
        positioner.setPower(0);
    }

}

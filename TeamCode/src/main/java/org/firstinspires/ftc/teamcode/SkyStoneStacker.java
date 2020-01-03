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
    private static final int TICKS_PER_REV = 280;
    private static final int TRAVELANGLE = 45;
    private static final int MAX_TICKS = (TICKS_PER_REV / 360) * TRAVELANGLE * 4;
    private static final double MAX_POWER = 0.25;
    private static final double MIN_POWER = -0.25;

    private DcMotor levelerMotor;
    public Servo positioner;
    private Servo grabber;
    private int position;
    private Telemetry telemetry;
    private double servoPosition;
    private double positionPositioner;

    public SkyStoneStacker(HardwareMap hardwareMap, Telemetry telemetry) {
        levelerMotor = hardwareMap.dcMotor.get("Leveler");
        levelerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        levelerMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        levelerMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
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

    public void close (){
        grabber.setPosition(1);
    }
    public void open (){
        grabber.setPosition(0);
    }
    public void grabSkyStone() {

        grabber.setPosition(GRABBERHOLD);
    }
    public void autoRaiseSkyStone() {
        positioner.setPosition(-HOMEPOSITIONER);
        levelerMotor.setTargetPosition(-HOMELEVELER);
        levelerMotor.setPower(1);

    }
    public void autoDropSkyStone() {
        levelerMotor.setTargetPosition(DROPLEVELER);
        levelerMotor.setPower(1);
        grabber.setPosition(-GRABBERHOLD);
    }

    public void positionerLeft() {
        servoPosition = positioner.getPosition();
        positionPositioner = servoPosition + 0.1;
        if(positioner.getPosition() > 0 && positioner.getPosition() < .5) {
            this.positioner.setPosition(position);
        }
    }
    public void positionerRight() {
        servoPosition = positioner.getPosition();
        positionPositioner = servoPosition - 0.1;
        if(positioner.getPosition() < 0 && positioner.getPosition() > -.5){
            this.positioner.setPosition(position);
        }
    }
    public void raiseArm(){
        levelerMotor.setPower(MAX_POWER);

        if(levelerMotor.getCurrentPosition() >= MAX_TICKS){
           this.stop();
        }

    }
    public void lowerArm(){
        levelerMotor.setPower(MIN_POWER);
        if(levelerMotor.getCurrentPosition() <= 0){
            this.stop();
        }
    }
    public void stop(){
        levelerMotor.setPower(0);
    }

}

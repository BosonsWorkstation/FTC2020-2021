package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class AutoOmniDriveTrain extends OmniDriveTrain {
    int position;
    private static final double MOTOR_POWER = 0.5;
    private static final int TICKS_PER_REVOLUTION = 280;
    private static final double DISTANCE_PER_REVOLUTION = 4 * Math.PI;
    private static final double CRAB_POWER = .2;
//    Telemetry.Item currentPositionTel;
//    Telemetry.Item targetValueTel;



    public AutoOmniDriveTrain(HardwareMap hardwareMap, Telemetry telemetry){
        super(hardwareMap,telemetry);
//        currentPositionTel = telemetry.addData("Current Position", 0);
//        targetValueTel = telemetry.addData("Target ValueL", 0);

    }


    public void initMotors(){
        this.initMotor(frontRightWheel);

//        this.initMotor(frontLeftWheel);
//
//        this.initMotor(backLeftWheel);
//
//        this.initMotor(backRightWheel);
    }

    private void initMotor(DcMotor motor) {
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

    }

    public int getTargetValue(int distance){
        int targetValue = Math.round((float)(Math.abs(distance)/DISTANCE_PER_REVOLUTION)*TICKS_PER_REVOLUTION);
//        telemetry.clear();
//        targetValueTel.setValue("%d", targetValue);
//        telemetry.update();
        return targetValue;
    }

    public void  moveDistance (int distance) throws InterruptedException {
        int direction = distance > 0 ? -1 : 1;
        int targetValue = getTargetValue(distance);
        int currentPosition = 0;
        this.setMoveMotorDirection(direction);
        boolean done = false;
        while(!done){

            frontRightWheel.setPower(.4);
            frontLeftWheel.setPower(.4);
            backRightWheel.setPower(.4);
            backLeftWheel.setPower(.4);
            Thread.sleep(5);
//            currentPositionTel.setValue("%d",currentPosition);
//            telemetry.update();
            if((direction > 0 && frontRightWheel.getCurrentPosition() < targetValue) ||
                (direction < 0 && frontRightWheel.getCurrentPosition() > targetValue)){
                done = true;
            }
        }
//        currentPositionTel.setValue("%d",currentPosition);
//        telemetry.update();

        this.stopNow();
    }

    public void







    crabbingDistance (int distance) throws InterruptedException {

        int direction = distance > 0 ? -1 : 1;
        int targetValue = getTargetValue(distance);
        int currentPosition;

        this.setCrabMotorDirections(direction);

        while(Math.abs( currentPosition = frontRightWheel.getCurrentPosition()) <  targetValue){
            frontRightWheel.setPower(.4);
            frontLeftWheel.setPower(.4);
            backRightWheel.setPower(.4);
            backLeftWheel.setPower(.4);
            Thread.sleep(5);

//            currentPositionTel.setValue("%d", currentPosition);
//            telemetry.update();
        }

//        currentPositionTel.setValue("%d",currentPosition);
//        telemetry.update();

        this.stopNow();
    }
    public void levelerControl (int power){
        if (power > 0){

        }
    }

}

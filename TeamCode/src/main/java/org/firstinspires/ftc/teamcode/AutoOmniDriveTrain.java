package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;


import org.firstinspires.ftc.robotcore.external.Telemetry;

public class AutoOmniDriveTrain extends OmniDriveTrain {
    int position;
    private static final double MOTOR_POWER = 0.5;
    private static final int TICKS_PER_REVOLUTION = 280;
    private static final double DISTANCE_PER_REVOLUTION = 4 * Math.PI;
    private static final double CRAB_POWER = .2;
//    Telemetry.Item currentPositionTel;
//    Telemetry.Item targetValueTel;


    public enum DirectionEnum{
        NORTH(90), SOUTH(-90), EAST(180), WEST(0);
        private double correction;
        DirectionEnum(double correction) {
            this.correction = correction;
        }
        public double getCorrection() {
            return correction;
        }
    }


    public AutoOmniDriveTrain(HardwareMap hardwareMap, Telemetry telemetry, DirectionEnum direction){
        super(hardwareMap,telemetry);
//        currentPositionTel = telemetry.addData("Current Position", 0);
//        targetValueTel = telemetry.addData("Target ValueL", 0);

    }


    public void initMotors(){
        this.initMotor(frontRightWheel);

        this.initMotor(frontLeftWheel);

        this.initMotor(backLeftWheel);

        this.initMotor(backRightWheel);
    }

    private void initMotor(DcMotor motor) {
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

    }

    public int getTargetValue(int distance){
        int targetValue = Math.round((float)(Math.abs(distance)/DISTANCE_PER_REVOLUTION)*TICKS_PER_REVOLUTION);
//        telemetry.clear();
////        targetValueTel.setValue("%d", targetValue);
//        telemetry.update();
        return targetValue;
    }
    public void stop(){
        frontLeftWheel.setPower(0);
        frontRightWheel.setPower(0);
        backRightWheel.setPower(0);
        backLeftWheel.setPower(0);
    }

    public void  moveDistance (int distance) throws InterruptedException {
        int direction = distance > 0 ? -1 : 1;
        int targetValue = getTargetValue(distance);
        int currentPosition = 0;
        this.setMoveMotorDirection(direction);
        boolean done = false;
//        if(direction > 0 && frontRightWheel.getCurrentPosition() < targetValue){
//            frontRightWheel.setPower(.4);
//            frontLeftWheel.setPower(.4);
//            backRightWheel.setPower(.4);
//            backLeftWheel.setPower(.4);
//            Thread.sleep(5);
//        }
//        if(direction < 0 && frontRightWheel.getCurrentPosition() > targetValue){
//            frontRightWheel.setPower(-0.4);
//            frontLeftWheel.setPower(-0.4);
//            backRightWheel.setPower(-0.4);
//            backLeftWheel.setPower(-0.4);
//            Thread.sleep(5);
//        }
        while(!done){

            frontRightWheel.setPower(.4);
            frontLeftWheel.setPower(.4);
            backRightWheel.setPower(.4);
            backLeftWheel.setPower(.4);
            Thread.sleep(5);
            if((direction > 0 && frontRightWheel.getCurrentPosition() < targetValue) ||
                (direction < 0 && frontRightWheel.getCurrentPosition() > targetValue)){
                done = true;
            }
        }
//        currentPositionTel.setValue("%d",currentPosition);
//        telemetry.update();

        this.stopNow();
    }




private void initMotorEncoder(DcMotor motor, int targetValue){

    motor.setTargetPosition(targetValue);

}

public void crabbingDistance (int distance) throws InterruptedException {

        int direction = distance > 0 ? -1 : 1;
        int targetValue = getTargetValue(distance);
        int currentPosition;

        this.setCrabMotorDirections(direction);

        this.frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.backRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.backLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);



        this.initMotorEncoder(this.frontRightWheel, targetValue);
        this.initMotorEncoder(this.frontLeftWheel, targetValue);
        this.initMotorEncoder(this.backRightWheel, targetValue);
        this.initMotorEncoder(this.backLeftWheel, targetValue);

        this.frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.backLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.backRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);



//        this.frontRightWheel.setTargetPosition(targetValue);
//        this.frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightWheel.setPower(.4);
        frontLeftWheel.setPower(.4);
        backRightWheel.setPower(.4);
        backLeftWheel.setPower(.4);
        while(this.frontRightWheel.isBusy()) {
            Thread.sleep(5);
            telemetry.addData("Current Position FR", frontRightWheel.getCurrentPosition());
            telemetry.addData("Current Position FL", frontLeftWheel.getCurrentPosition());
            telemetry.addData("Current Position BL", backLeftWheel.getCurrentPosition());
            telemetry.addData("Current Position BR", backRightWheel.getCurrentPosition());

            telemetry.addData("Target value", targetValue);
            telemetry.update();
        }


//        while(Math.abs( currentPosition = frontRightWheel.getCurrentPosition()) <  targetValue){
//
//            frontRightWheel.setPower(.4);
//            frontLeftWheel.setPower(.4);
//            backRightWheel.setPower(.4);
//            backLeftWheel.setPower(.4);
//            Thread.sleep(5);
//
////            currentPositionTel.setValue("%d", currentPosition);
//            telemetry.addData("Current Position", currentPosition);
//            telemetry.addData("Target value", targetValue);
//            telemetry.update();
//        }

//        currentPositionTel.setValue("%d",currentPosition);
        telemetry.update();

        this.stopNow();
    }
    public void levelerControl (int power){
        if (power > 0){

        }
    }

}

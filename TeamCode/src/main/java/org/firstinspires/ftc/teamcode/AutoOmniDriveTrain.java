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
    Telemetry.Item currentPositionTel;
    Telemetry.Item targetValueTel;



    public AutoOmniDriveTrain(HardwareMap hardwareMap, Telemetry telemetry){
        super(hardwareMap,telemetry);
        currentPositionTel = telemetry.addData("Current Position", 0);
        targetValueTel = telemetry.addData("Target ValueL", 0);

    }


    public void initMotors(){
        frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        frontLeftWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        backLeftWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        backRightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public int getTargetValue(int distance){
        int targetValue = Math.round((float)(Math.abs(distance)/DISTANCE_PER_REVOLUTION)*TICKS_PER_REVOLUTION);
        telemetry.clear();
        targetValueTel.setValue("%d", targetValue);
        telemetry.update();
        return targetValue;
    }

    public void  moveDistance (int distance) throws InterruptedException {
        int direction = distance > 0 ? -1 : 1;
        int targetValue = getTargetValue(distance);
        int currentPosition;
        initMotors();
        while(Math.abs( currentPosition = frontRightWheel.getCurrentPosition())< targetValue){
            this.move(0.5, direction);
            Thread.sleep(5);
            currentPositionTel.setValue("%d",currentPosition);
            telemetry.update();

        }
        currentPositionTel.setValue("%d",currentPosition);
        telemetry.update();

        this.stopNow();
    }

    public void crabbingDistance (int distance) throws InterruptedException {

        int direction = distance > 0 ? -1 : 1;
        int targetValue = getTargetValue(distance);
        int currentPosition;
        initMotors();
        while(Math.abs( currentPosition = frontRightWheel.getCurrentPosition())< targetValue){
            this.crab(0.5, direction);
            Thread.sleep(5);
            currentPositionTel.setValue("%d",currentPosition);
            telemetry.update();

        }

        currentPositionTel.setValue("%d",currentPosition);
        telemetry.update();

        this.stopNow();
    }
    public void levelerControl (int power){
        if (power > 0){

        }
    }

}

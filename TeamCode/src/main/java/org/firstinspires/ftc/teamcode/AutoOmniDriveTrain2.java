package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class AutoOmniDriveTrain2 extends AutoOmniDriveTrain{
    int position;
    private static final double MOTOR_POWER = 0.5;
    private static final int TICKS_PER_REVOLUTION = 280;
    private static final double DISTANCE_PER_REVOLUTION = 4 * Math.PI;
    private static final double CRAB_POWER = .2;

    public AutoOmniDriveTrain2(HardwareMap hardwareMap, Telemetry telemetry){
        super(hardwareMap,telemetry);
    }

    public void initMotors(){
        super.initMotors();
        this.frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void crabbingDistance(int distance) throws InterruptedException {

        int direction = distance > 0 ? -1 : 1;
        int targetValue = getTargetValue(distance);

        this.setCrabMotorDirections(direction);
        this.frontRightWheel.setTargetPosition(targetValue);
        frontRightWheel.setPower(.4);
        frontLeftWheel.setPower(.4);
        backRightWheel.setPower(.4);
        backLeftWheel.setPower(.4);
        while(this.frontRightWheel.isBusy()) {
            Thread.sleep(5);
        }

    }

}

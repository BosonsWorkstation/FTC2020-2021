package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class AutoOmniDriveTrain extends OmniDriveTrain {
    int position;
    private static final double MOTOR_POWER = 0.5;
    private static final int TICKS_PER_REVOLUTION = 280;
    private static final double DISTANCE_PER_REVOLUTION = 2 * 10 * Math.PI;
    private Telemetry telemetry;

    public AutoOmniDriveTrain(HardwareMap hardwareMap, Telemetry telemetry){
        super(hardwareMap,telemetry);
    }
    public void  moveDistance (int distance) throws InterruptedException {

        frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        int targetValue = Math.round((float)(distance/DISTANCE_PER_REVOLUTION)*TICKS_PER_REVOLUTION);
        frontRightWheel.setTargetPosition(targetValue);
        frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.move(0.5, 1);
        while(frontRightWheel.getCurrentPosition() < targetValue){
            Thread.sleep(10);
        }
//        while(frontRightWheel.getCurrentPosition() < targetValue){
//            telemetry.addData("Encoder Position", position);
//            this.move(1,3);
//            Thread.sleep(50);
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                break;
//            }
//        }
        this.stop();
    }
    public void  crabDistance (int distance) {

        frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        int targetValue = Math.round((float)(distance/DISTANCE_PER_REVOLUTION)*TICKS_PER_REVOLUTION);

        while(frontRightWheel.getCurrentPosition() > targetValue){
            telemetry.addData("Encoder Position", position);
            this.move(1,3);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                break;
            }
        }
        this.stop();
    }


}

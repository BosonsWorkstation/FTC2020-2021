package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SkyStoneIntake {

    private DcMotor leftArmMotor;
    private DcMotor rightArmMotor;
    private boolean isRunning = false;
    private Telemetry telemetry;
    private static final double MOTOR_POWER = 0.9;

    public SkyStoneIntake(HardwareMap hardwareMap, Telemetry telemetry){
        leftArmMotor = hardwareMap.dcMotor.get("Left_Arm_Motor");
        rightArmMotor = hardwareMap.dcMotor.get("Right_Arm_Motor");
//        intakeRotate = hardwareMap.servo.get("Intake");
        this.telemetry = telemetry;
        this.rightArmMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        this.leftArmMotor.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    public void spitOut(){
        this.leftArmMotor.setPower(-MOTOR_POWER);
        this.rightArmMotor.setPower(-MOTOR_POWER);
    }

    public void startCollecting () {
        this.leftArmMotor.setPower(MOTOR_POWER);
        this.rightArmMotor.setPower(MOTOR_POWER);
    }
    public void stopCollecting  () {
        this.leftArmMotor.setPower(0);
        this.rightArmMotor.setPower(0);
    }

}

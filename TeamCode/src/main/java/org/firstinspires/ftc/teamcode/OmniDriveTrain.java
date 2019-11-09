package org.firstinspires.ftc.teamcode;
import android.provider.FontRequest;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class OmniDriveTrain{
    private DcMotor backRightWheel;
    private DcMotor backLeftWheel;
    private DcMotor frontRightWheel;
    private DcMotor frontLeftWheel;

    private double lastPower = 0;
    private static final double INCREMENT = 0.1;
    private static final double MIN_DIFF = 0.2;

    private Telemetry telemetry;

    public OmniDriveTrain(HardwareMap  hardwareMap, Telemetry telemetry){
        this.backLeftWheel = hardwareMap.dcMotor.get("Back Left Wheel");
        this.backRightWheel = hardwareMap.dcMotor.get("Back Right Wheel");
        this.frontLeftWheel = hardwareMap.dcMotor.get("Front Left Wheel");
        this.frontRightWheel = hardwareMap.dcMotor.get("Front Right Wheel");
        this.telemetry = telemetry;
    }

public void stop(){
    frontRightWheel.setPower(0);
    frontLeftWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
}




    public void move(double power, int direction){

        if (direction > 0){
            telemetry.addData("Moving Forward: ", power);
            telemetry.addData("Motor Power", frontRightWheel.getPower());
            telemetry.addData("Motor Power", frontLeftWheel.getPower());
            telemetry.addData("Motor Power", backRightWheel.getPower());
            telemetry.addData("Motor Power", backLeftWheel.getPower());

            frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);

            frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);

        }

        if (direction < 0){
            frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);

            frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);


        }
        this.turnMotors(power);



    }

    public void turn(double power, int direction){

        if (direction == 1){
            //right turn
            frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);

        }
        if (direction == -1) {
            //left turn
            frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        }
        this.turnMotors(power);



    }

    public void crab(double power, int direction){

        if (direction > 0){
            telemetry.addData("Moving Forward: ", power);
            telemetry.addData("Motor Power", frontRightWheel.getPower());
            telemetry.addData("Motor Power", frontLeftWheel.getPower());
            telemetry.addData("Motor Power", backRightWheel.getPower());
            telemetry.addData("Motor Power", backLeftWheel.getPower());

            frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);

            backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);

        }

        if (direction < 0){
            frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);

            backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);


        }
        this.turnMotors(power);



    }

    /*
This function only sets the POWER of the motors, each method needs to DECLARE THE
DIRECTIONS OF THE MOTORS in order for the robot to do the intended movement
     */
    public void turnMotors(double power){

        double powerDiff = power - lastPower;
        double usePower;

        if (Math.abs(powerDiff) > MIN_DIFF) {
                usePower =  power > lastPower ? lastPower + INCREMENT : lastPower - INCREMENT;

        } else {
            usePower = power;
        }

        lastPower = usePower;

        usePower = Math.abs(usePower);
        frontRightWheel.setPower(usePower);
        frontLeftWheel.setPower(usePower);
        backRightWheel.setPower(usePower);
        backLeftWheel.setPower(usePower);

    }
}


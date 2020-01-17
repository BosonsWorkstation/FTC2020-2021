package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;


public class OmniDriveTrain{
    protected DcMotor backRightWheel;
    protected DcMotor backLeftWheel;
    protected DcMotor frontRightWheel;
    protected DcMotor frontLeftWheel;
//    protected Servo leveler;

    private BNO055IMU imu;
    private double lastPower = 0;
    private static final double INCREMENT = 0.1;
    private static final double MIN_DIFF = 0.05;
    private static final double MAX_POWER = 0.5;
    public boolean GO_SLOW = false;
    protected Telemetry telemetry;
    private Telemetry.Item leftFrontTelemetry;
    private Telemetry.Item rightFrontTelemetry;
    private Telemetry.Item leftBackTelemetry;
    private Telemetry.Item rightBackTelemetry;
    private Telemetry.Item usePowerTelemetry;

    public OmniDriveTrain(HardwareMap  hardwareMap, Telemetry telemetry){
        this.telemetry = telemetry;
        this.initializeGyro(hardwareMap,telemetry);
        this.initializeMotors(hardwareMap,telemetry);
        this.leftFrontTelemetry = telemetry.addData("LF Power", 0);
        this.rightFrontTelemetry = telemetry.addData("RF Power", 0);
        this.leftBackTelemetry = telemetry.addData("LF Power", 0);
        this.rightBackTelemetry = telemetry.addData("RB Power", 0);
        this.usePowerTelemetry = telemetry.addData("usePower", 0);
    }

    public void initializeMotors(HardwareMap hardwareMap, Telemetry telemetry){
        this.backLeftWheel = hardwareMap.dcMotor.get("Back_Left_Wheel");
        this.backRightWheel = hardwareMap.dcMotor.get("Back_Right_Wheel");
        this.frontLeftWheel = hardwareMap.dcMotor.get("Front_Left_Wheel");
        this.frontRightWheel = hardwareMap.dcMotor.get("Front_Right_Wheel");
    }

    public void initializeGyro(HardwareMap hardwareMap, Telemetry telemetry){

        this.imu = hardwareMap.get(BNO055IMU.class, "imu");
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

        parameters.mode = BNO055IMU.SensorMode.IMU;
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.loggingEnabled = false;



        imu.initialize(parameters);
    }


public void stop(){

    while (lastPower > .1) {
        turnMotors(lastPower - INCREMENT);
    }
    frontRightWheel.setPower(0);
    frontLeftWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    lastPower = 0;
}

    public void stopNow(){
        frontRightWheel.setPower(0);
        frontLeftWheel.setPower(0);
        backRightWheel.setPower(0);
        backLeftWheel.setPower(0);
        lastPower = 0;
    }


    protected void setMoveMotorDirection(int directionFB) {
        if (directionFB > 0){

            frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);

            frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);

        }

        if (directionFB < 0){
            frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);

            frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);


        }
    }


    public void move(double power, int directionFB){
        this.setMoveMotorDirection(directionFB);
//        telemetry.addData("Motor Power", frontRightWheel.getPower());
//            telemetry.addData("Motor Power", frontLeftWheel.getPower());
        this.leftFrontTelemetry.setValue("%0.3f",frontLeftWheel.getPower());
        this.rightFrontTelemetry.setValue("%0.3f",frontRightWheel.getPower());
        this.leftBackTelemetry.setValue("%0.3f", backLeftWheel.getPower());
        this.rightBackTelemetry.setValue("%0.3f", backRightWheel.getPower());
//            telemetry.addData("Motor Power", backRightWheel.getPower());
//            telemetry.addData("Motor Power", backLeftWheel.getPower());



        if(GO_SLOW){
            power = 0.2;
        }
        this.turnMotors(power);

    }

    public void setTurnDirections(int directionTurn) {
        if (directionTurn == 1){
            //right turn
            frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);

        }
        if (directionTurn == -1) {
            //left turn
            frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        }
    }

    public void turn(double power, int directionTurn){

        if (directionTurn == 1){
            //right turn
            frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);

        }
        if (directionTurn == -1) {
            //left turn
            frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        }
        if(GO_SLOW){
            power = 0.2;
        }
        this.turnMotors(power);



    }
//
//    public void toggleSlowMo(){
//        if(GO_SLOW){
//            GO_SLOW = false;
//        }else {
//            GO_SLOW = true;
//        }
//    }

    protected void setCrabMotorDirections(int directionCrab){
        if (directionCrab > 0){

            frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);

            backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);

        }

        if (directionCrab < 0){
            frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);

            backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);


        }
    }

    public void crab(double power, int directionCrab){

        this.setCrabMotorDirections(directionCrab);
//        telemetry.addData("Motor Power", frontRightWheel.getPower());
//        telemetry.addData("Motor Power", frontLeftWheel.getPower());
//        telemetry.addData("Motor Power", backRightWheel.getPower());
//        telemetry.addData("Motor Power", backLeftWheel.getPower());
        if(GO_SLOW){
            power = 0.2;
        }
        this.turnMotors(power);



    }




    public void turnMotors(double power){

        double usePower = Math.abs(power);

        double powerDiff = usePower - lastPower;

        if (Math.abs(powerDiff) > MIN_DIFF) {
            usePower =  usePower > lastPower ? lastPower + INCREMENT : lastPower - INCREMENT;
            if(usePower < 0){
                usePower = 0;
            }
        }

        if(usePower > MAX_POWER){
            usePower = MAX_POWER;
        }

        lastPower = usePower;


        frontLeftWheel.setPower(usePower);
        backRightWheel.setPower(usePower);
        backLeftWheel.setPower(usePower);
        frontRightWheel.setPower(usePower);
        usePowerTelemetry.setValue("%0.3f",usePower);

    }
//    public void moveLeveler(double levelerPower, int directionLeveler){
//        if (directionLeveler >0){
//            double useLevelerPower = Math.abs(levelerPower);
//        }
//    }
}


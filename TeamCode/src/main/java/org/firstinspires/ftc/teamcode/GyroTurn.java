package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.hardware.bosch.BNO055IMU;



@Autonomous(name = "Test OP Mode", group = "Linear Opmode")
public class GyroTurn extends LinearOpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;
    Servo clawArm;
    GyroSensor gyroSensor;
    ModernRoboticsI2cGyro gyro;

    @Override
    public void runOpMode() throws InterruptedException {

            int zAccumilated;
            int heading;
            int xval, yval, zval;

            leftMotor = hardwareMap.dcMotor.get("Left Wheel");
            rightMotor = hardwareMap.dcMotor.get("Right Wheel");
            leftMotor.setDirection(DcMotor.Direction.REVERSE);
            clawArm = hardwareMap.servo.get("Claw Arm");
            gyroSensor = hardwareMap.gyroSensor.get("BNO055IMU imu");
            gyro = (ModernRoboticsI2cGyro) gyroSensor;

            gyro.calibrate();

            waitForStart();


            while (gyro.isCalibrating()) {

                zAccumilated = gyro.getIntegratedZValue();
                heading = gyro.getHeading();

                xval = gyro.rawX();
                yval = gyro.rawY();
                zval = gyro.rawZ();

                telemetry.addData("1. heading", String.format("%03d",heading));
                telemetry.addData("2. accu", String.format("%03d", zAccumilated));
                telemetry.addData("3. X", String.format("%03d", xval));
                telemetry.addData("3. Y", String.format("%03d", yval));
                telemetry.addData("3. Z", String.format("%03d", zval));
                waitOneFullHardwareCycle();
            }






    }
}



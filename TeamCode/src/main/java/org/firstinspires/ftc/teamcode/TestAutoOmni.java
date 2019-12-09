package org.firstinspires.ftc.teamcode;
import android.graphics.drawable.GradientDrawable;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;


@Autonomous(name = "Test Auto Omni", group = "Linear Opmode")
public class TestAutoOmni extends LinearOpMode {
    private AutoOmniDriveTrain autoOmniDrive;
    private SkyStoneIntake intake;
    BNO055IMU imu;
    Orientation startOrientation;

    @Override
    public void runOpMode() throws InterruptedException {
        this.autoOmniDrive = new AutoOmniDriveTrain(this.hardwareMap, this.telemetry);
        this.intake = new SkyStoneIntake(this.hardwareMap, this.telemetry);
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

        parameters.mode = BNO055IMU.SensorMode.IMU;
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.loggingEnabled = false;

        // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
        // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
        // and named "imu".
        imu = hardwareMap.get(BNO055IMU.class, "imu");

        imu.initialize(parameters);

        telemetry.addData("Mode", "calibrating...");
        telemetry.update();

        startOrientation = imu.getAngularOrientation();

        telemetry.addData("Orientation:","x: %f; y: %f, z: %f",startOrientation.firstAngle,startOrientation.secondAngle,startOrientation.thirdAngle);
        telemetry.update();

        waitForStart();

        this.autoOmniDrive.moveDistance(20);

        this.stop();


    }
}

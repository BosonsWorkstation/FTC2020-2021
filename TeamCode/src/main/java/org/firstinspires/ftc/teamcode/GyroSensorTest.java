package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Drive Avoid Imu", group="Exercises")
//@Disabled
public class GyroSensorTest extends LinearOpMode
{
    BNO055IMU               imu;


    // called when init button is  pressed.
    @Override
    public void runOpMode() throws InterruptedException {





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

        waitForStart();

        while(opModeIsActive()){
            //Get x y z readings from imu and display on the screen
            Orientation orientation = imu.getAngularOrientation();
            float x = orientation.firstAngle;
            float y = orientation.secondAngle;
            float z = orientation.thirdAngle;

            telemetry.addData("Orientation: ","x=%f,y=%f,z=%f",x,y,z);
            telemetry.update();

            idle();
        }
    }
}
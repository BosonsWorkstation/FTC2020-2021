package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;


@Autonomous(name = "Omni Drive Test", group = "Linear Opmode")
public class OmniGyro extends LinearOpMode{
    private OmniDriveTrain driveTrain;
    private BNO055IMU imu;

    @Override
    public void runOpMode()   throws InterruptedException {
        this.driveTrain = new OmniDriveTrain(this.hardwareMap, this.telemetry);


        waitForStart();

        while (opModeIsActive()) {

            Orientation orientation = imu.getAngularOrientation();
            float x = orientation.firstAngle;
            float y = orientation.secondAngle;
            float z = orientation.thirdAngle;

            telemetry.addData("Orientation: ","x=%f,y=%f,z=%f",x,y,z);
            telemetry.update();

            idle();


            while (y < 90) {
                this.driveTrain.turn(.5,1);
                telemetry.update();
            }

            this.driveTrain.stop();


            Thread.sleep(50);

        }
    }






}


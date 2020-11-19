package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;



import android.graphics.drawable.GradientDrawable;


@TeleOp(name = "Testbot TeleOp", group = "Linear Opmode")
public class TestbotTeleOp extends LinearOpMode {
    private TestbotDrivetrain driveTrainTest;

    private static final TestbotDrivetrain.DirectionEnum direction = TestbotDrivetrain.DirectionEnum.SOUTH;


    @Override
    public void runOpMode() throws InterruptedException {
        this.driveTrainTest = new TestbotDrivetrain(this.hardwareMap, this.telemetry,direction);

//        this.blockArm = new SkyStoneStacker(this.hardwareMap, this.telemetry);


        // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
        // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
        // and named "imu".

//
//        telemetry.addData("Mode", "calibrating...");

        telemetry.update();

        waitForStart();


        while (opModeIsActive()) {


            double crabValue = 0;
            double moveValue = 0;
            double turnValue = 0;

            crabValue = -gamepad1.left_stick_x;
            moveValue = gamepad1.left_stick_y;
            turnValue = gamepad1.right_stick_x;

            if (Math.abs(moveValue) < 0.1 && Math.abs(crabValue) < 0.1 && Math.abs(crabValue) < 0.1) {
                this.driveTrainTest.stop();
            }
            while (gamepad1.a){
                this.driveTrainTest.detectRingHeight();
            }

            idle();



        }
        telemetry.update();





        telemetry.update();
        Thread.sleep(50);


    }

}



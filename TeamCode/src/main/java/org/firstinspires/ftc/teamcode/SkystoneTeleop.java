package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;



import android.graphics.drawable.GradientDrawable;


@TeleOp(name = "SkyStone Teleop", group = "Linear Opmode")
public class SkystoneTeleop extends LinearOpMode{
    private OmniDriveTrain driveTrain;
    private SkyStoneIntake intake;
    private FoundationArm foundation;
    private SkyStoneStacker stacker;

//    private SkyStoneStacker blockArm;
    BNO055IMU imu;


    private enum Heading{
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    Orientation startOrientation;

    @Override
    public void runOpMode()   throws InterruptedException {
        this.driveTrain = new OmniDriveTrain(this.hardwareMap, this.telemetry);
        this.intake = new SkyStoneIntake(this.hardwareMap, this.telemetry);
        this.foundation = new FoundationArm(this.hardwareMap, this.telemetry);
        this.stacker = new SkyStoneStacker(this.hardwareMap, this.telemetry);
//        this.blockArm = new SkyStoneStacker(this.hardwareMap, this.telemetry);
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
//
//        telemetry.addData("Mode", "calibrating...");
        telemetry.update();

        startOrientation = imu.getAngularOrientation();

        telemetry.addData("Orientation:","x: %f; y: %f, z: %f",startOrientation.firstAngle,startOrientation.secondAngle,startOrientation.thirdAngle);
        telemetry.update();
        waitForStart();



        while (opModeIsActive()) {




            double xval = 0;
            double yval = 0;

            double xval2 = gamepad1.right_stick_x;

            Heading currentHeading = this.getHeading();

//

            if(gamepad1.left_trigger > 0.1){
                telemetry.addData("RESETTING", "");
                imu.initialize(parameters);
                telemetry.clear();
                telemetry.addData("GYRO RESET $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$", "");
                telemetry.update();
            }



            if (gamepad2.right_bumper) {
                this.intake.down();
            }else if(gamepad2.left_bumper){
                this.intake.up();
            }

            if(gamepad2.dpad_up){
                this.stacker.raiseArm();
//                telemetry.addData("Moving", stacker.levelerMotor.getCurrentPosition());
//                telemetry.update();
            } else if(gamepad2.dpad_down){
                this.stacker.lowerArm();
//                telemetry.addData("Moving", stacker.levelerMotor.getCurrentPosition());
//                telemetry.update();
            } else{
                stacker.stop();
            }


            if(gamepad2.left_trigger > 0){
//                telemetry.addData("Right Bumper Pressed", "True");
//                telemetry.update();
                this.intake.startCollecting();


            }else if(gamepad2.right_trigger > 0){
                this.intake.spitOut();
            }else {
                this.intake.stopCollecting();
//                telemetry.addData("Right Bumper Pressed", "False");
//                telemetry.update();
            }

            if (gamepad2.a){
                this.foundation.foundationDown();
                this.foundation.foundationDown1();
            }
            if (gamepad2.y){
                this.foundation.foundationUp();
                this.foundation.foundationUp1();
            }

            if (gamepad2.b){
                this.stacker.close();
            }

            if (gamepad2.x){
                this.stacker.open();
            }

            if(gamepad2.dpad_left){
                    this.stacker.positionerLeft();
            }else if(gamepad2.dpad_right){
                this.stacker.positionerRight();
            }else {
                this.stacker.stopPositioner();
            }

            if(gamepad1.right_trigger > 0.5){
                this.driveTrain.GO_SLOW = true;
                telemetry.addData("Slow Mode On ==================================================================================", "");
                telemetry.update();

            }
            if(gamepad1.right_trigger <0.5){
                this.driveTrain.GO_SLOW = false;
                telemetry.addData("Slow Mode Off", "");
                telemetry.update();
            }





//            telemetry.update();
            xval = gamepad1.left_stick_x;
            yval = gamepad1.left_stick_y;

            switch (currentHeading){
                case WEST:

                    xval = -gamepad1.left_stick_y;
                    yval = gamepad1.left_stick_x;
                    break;
                case EAST:
                    xval = gamepad1.left_stick_y;
                    yval = -gamepad1.left_stick_x;
                    break;
                case NORTH:
                    xval = -gamepad1.left_stick_x;
                    yval = -gamepad1.left_stick_y;
                    break;
                default:
                    xval = gamepad1.left_stick_x;
                    yval = gamepad1.left_stick_y;

            }


            if(Math.abs(yval) < 0.1 && Math.abs(xval) < 0.1 && Math.abs(xval2) < 0.1) {
                this.driveTrain.stop();

            } else if (Math.abs(xval)>0.1 || Math.abs(yval)>0.1) {
                if ((xval != 0 && Math.abs(yval) > 0) || Math.abs(yval / xval) > 0.5) {
//                    telemetry.addData("Move Forward/back", yval);
                    int directionFB = yval > 0 ? 1 : -1;
                    this.driveTrain.move(yval, directionFB);
                } else if (Math.abs(xval) > 0) {
//                    telemetry.addData("Move Sideways", xval);
                    int directionCrab = xval > 0 ? 1 : -1;
                    this.driveTrain.crab(xval, directionCrab);

                }
            }
            if(Math.abs(xval2) > 0.1){
//                telemetry.addData("Turn", xval2);
                telemetry.update();
                int directionTurn = xval2 > 0 ? 1 : -1;
                this.driveTrain.turn(xval2, directionTurn);
            }




            idle();


            telemetry.update();
            Thread.sleep(50);

        }
    }

    public Heading getHeading(){
        Orientation currentOrientation = imu.getAngularOrientation();
//        telemetry.addData("Orientation:","x: %f; y: %f, z: %f",currentOrientation.firstAngle,currentOrientation.secondAngle,currentOrientation.thirdAngle);
        telemetry.update();

        Heading heading = Heading.NORTH;
//
//        telemetry.addData("Angle:", currentOrientation.firstAngle);
        telemetry.update();

        if(currentOrientation.firstAngle > 45 && currentOrientation.firstAngle <= 135){
            heading = Heading.EAST;
        }else if(currentOrientation.firstAngle > 135 || currentOrientation.firstAngle <= -135){
            heading = Heading.SOUTH;
        }else if(currentOrientation.firstAngle < -45 && currentOrientation.firstAngle > -135){
            heading = Heading.WEST;

        }
        //if change from start > 90 and < 180 heading is east
        //if change > 180 and < 270 south
        //if change > 270 then west
        return heading;
    }




}


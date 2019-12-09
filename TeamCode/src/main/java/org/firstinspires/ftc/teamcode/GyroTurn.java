//package org.firstinspires.ftc.teamcode;
//
//
//import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.GyroSensor;
//import com.qualcomm.hardware.bosch.BNO055IMU;
//
//
//        @TeleOp(name = "Omni Drive Test", group = "Linear Opmode")
//        public class GyroTurn extends LinearOpMode {
//            private OmniDriveTrain driveTrain;
//
////            GyroSensor gyroSensor;
//            ModernRoboticsI2cGyro gyro;
//            BNO055IMU gyroSensor;
//
//            @Override
//            public void runOpMode() throws InterruptedException {
//                this.driveTrain = new OmniDriveTrain(this.hardwareMap, this.telemetry);
//
////                int zAccumilated;
////                int heading;
////                int xval, yval, zval;
//
//                gyroSensor = hardwareMap.get(BNO055IMU.class,"imu");
//
//                parameters.mode                = BNO055IMU.SensorMode.IMU;
//                parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
//                parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
//                parameters.loggingEnabled      = false;
//
//                // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
//                // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
//                // and named "imu".
//                imu = hardwareMap.get(BNO055IMU.class, "imu");
//
//                imu.initialize(parameters);
//
//                telemetry.addData("Mode", "calibrating...");
//                telemetry.update();
//
//                // make sure the imu gyro is calibrated before continuing.
//                while (!isStopRequested() && !imu.isGyroCalibrated())
//                {
//                    sleep(50);
//                    idle();
//                }
//
//                telemetry.addData("Mode", "waiting for start");
//                telemetry.addData("imu calib status", imu.getCalibrationStatus().toString());
//                telemetry.update();
//
//                // wait for start button.
//
//                waitForStart();
//
//                telemetry.addData("Mode", "running");
//                telemetry.update();
//
//
//
//                gyro.calibrate();
//
//                waitForStart();
//
//                while (opModeIsActive()) {
//                    double xval = gamepad1.left_stick_x;
//                    double yval = gamepad1.left_stick_y;
//
//                    double xval2 = gamepad1.right_stick_x;
//                    int direction = 1;
//                    if (Math.abs(yval) < 0.1 && Math.abs(xval) < 0.1) {
//                        this.driveTrain.stop();
//
//                    } else if (Math.abs(xval) > 0.1 || Math.abs(yval) > 0.1) {
//                        if ((xval != 0 && Math.abs(yval) > 0) || Math.abs(yval / xval) > 0.5) {
//                            telemetry.addData("Move Forward/back", yval);
//                            direction = yval > 0 ? 1 : -1;
//                            this.driveTrain.move(yval, direction);
//                        } else if (Math.abs(xval) > 0) {
//                            telemetry.addData("Move Sideways", xval);
//                            direction = xval > 0 ? 1 : -1;
//                            this.driveTrain.crab(xval, direction);
//
//                        }
//                    }
//                    if (Math.abs(xval2) > 0.1) {
//                        direction = xval2 > 0 ? 1 : -1;
//                        this.driveTrain.turn(xval2, direction);
//                    }
//
//                    int zAccumilated;
//                    int heading;
////                    int xval, yval, zval;
//                    int zval;
//
//                    gyro.calibrate();
//
//                    waitForStart();
//
//
//                    while (gyro.isCalibrating()) {
//
//                        zAccumilated = gyro.getIntegratedZValue();
//                        heading = gyro.getHeading();
//
//                        xval = gyro.rawX();
//                        yval = gyro.rawY();
//                        zval = gyro.rawZ();
//
//                        telemetry.addData("1. heading", String.format("%03d", heading));
//                        telemetry.addData("2. accu", String.format("%03d", zAccumilated));
//                        telemetry.addData("3. X", String.format("%03d", xval));
//                        telemetry.addData("3. Y", String.format("%03d", yval));
//                        telemetry.addData("3. Z", String.format("%03d", zval));
//                        waitOneFullHardwareCycle();
//                    }
//
//
//                }
//            }
//        }
//
//

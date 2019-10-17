package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class AutonomousTrial {


    @Autonomous(name = "AutonomousTrial", group = "Pushbot")
    public class PushbotAutoDriveByEncoder_Linear extends LinearOpMode {

        /* Declare OpMode members. */
        private DcMotor rightWheel;
        private DcMotor leftWheel;
        private DcMotor clawArm;
        private Servo claw;


        HardwarePushbot robot = new HardwarePushbot();   // Use a Pushbot's hardware
        private ElapsedTime runtime = new ElapsedTime();

        static final double COUNTS_PER_MOTOR_REV = 1440;    // eg: TETRIX Motor Encoder
        static final double DRIVE_GEAR_REDUCTION = 2.0;     // This is < 1.0 if geared UP
        static final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
        static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
                (WHEEL_DIAMETER_INCHES * 3.1415);
        static final double DRIVE_SPEED = 0.6;
        static final double TURN_SPEED = 0.5;

        @Override
        public void runOpMode() {

            /*
             * Initialize the drive system variables.
             * The init() method of the hardware class does all the work here
             */
            robot.init(hardwareMap);

            rightWheel = hardwareMap.dcMotor.get("rightWheel");
            leftWheel = hardwareMap.dcMotor.get("leftWheel");
            clawArm = hardwareMap.dcMotor.get("clawArm");
            claw = hardwareMap.servo.get("claw");

            // Send telemetry message to signify robot waiting;
            telemetry.addData("Status", "Resetting Encoders");    //
            telemetry.update();

            robot.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            // Send telemetry message to indicate successful Encoder reset
            telemetry.addData("Path0", "Starting at %7d :%7d",
                    robot.leftDrive.getCurrentPosition(),
                    robot.rightDrive.getCurrentPosition());
            telemetry.update();



            // Wait for the game to start (driver presses PLAY)
            waitForStart();
            forwardDrive(0,1, 23);
        }


        public void forwardDrive(double turn, double speed, double revs){
            double COUNTS_PER_MOTOR_REV = revs;    // eg: TETRIX Motor Encoder
//            double DRIVE_GEAR_REDUCTION = 2.0;     // This is < 1.0 if geared UP
            double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
            double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
                    (WHEEL_DIAMETER_INCHES * 3.1415);
            double DRIVE_SPEED = speed;
                    leftWheel.setPower(speed);
                    rightWheel.setPower(speed);
            double TURN_SPEED = turn ;

        }
        public void leftTurn(double turn, double speed, double revs){
            double COUNTS_PER_MOTOR_REV = revs;    // eg: TETRIX Motor Encoder
//            double DRIVE_GEAR_REDUCTION = 2.0;     // This is < 1.0 if geared UP
            double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
            double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
                    (WHEEL_DIAMETER_INCHES * 3.1415);
            double DRIVE_SPEED = speed;
            leftWheel.setPower(speed);
            rightWheel.setPower(speed);
            double TURN_SPEED = turn ;

        }
    }
}
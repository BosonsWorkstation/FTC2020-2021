//
//package org.firstinspires.ftc.teamcode;
//
//        import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//        import com.qualcomm.robotcore.util.ElapsedTime;
//        import com.qualcomm.robotcore.util.Range;
//        import com.qualcomm.robotcore.hardware.DcMotor;
//        import com.qualcomm.robotcore.hardware.Servo;
//        import com.qualcomm.robotcore.hardware.GyroSensor;
//
//
//
//@Autonomous(name = "Test OP Mode", group = "Linear Opmode")
//public class Autonomus1 extends LinearOpMode {
//    private DcMotor rightWheel;
//    private DcMotor leftWheel;
//    private Servo clawArm;
//    private GyroSensor gyro;
//
//    private ElapsedTime runtime = new ElapsedTime();
//
//    @Override public void runOpMode(){
//        //Initialize motors
//        rightWheel = hardwareMap.dcMotor.get("Right Wheel");
//        leftWheel = hardwareMap.dcMotor.get("Left Wheel");
//        clawArm = hardwareMap.servo.get("claw arm");
//        gyro = hardwareMap.gyroSensor.get("Gyro Sensor");
//
//
//
////        rightWheel.setChannelMode(DCMotorController.RunMode.RUN_WITHOUT_ENCODERS);
////        leftWheel.setChannelMode(DCmotorController.RunMode.RUN_WITHOUT_ENCODERS);
////        clawArm.setChannelMode(DCmotorController.RunMode.RUN_WITHOUT_ENCODERS);
//
//        clawArm.setPosition(.8);
//
////        Wait for the game to start
//        waitForStart();
//
//        DriveForward(1);
//        sleep(30000);
//        turnLeft(1);
//        turnRight(1);
//        sleep(3000);
//
//        clawArmUp(1 );
//        sleep(10000);
//
//        stopDrive();
//
//
//
//    }
//
//    public void DriveForward(double power) {
//        rightWheel.setPower(power);
//        leftWheel.setPower(power);
//    }
//    public void stopDrive() {
//        DriveForward(0);
//    }
//    public void turnLeft(double power) {
//        rightWheel.setPower(power);
//        leftWheel.setPower(-power);
//    }
//    public void turnRight(double power){
//        rightWheel.setPower(power);
//        leftWheel.setPower(-power);
//    }
//
//
//    public void clawArmUp(double power) {
//        clawArm.setPosition(-0.6);
//
//
//
//
//    }
//
//
//
//
//
//
//}
//

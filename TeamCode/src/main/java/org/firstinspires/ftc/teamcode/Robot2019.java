//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//public class Robot2019 extends LinearOpMode {
//
//    OmniDriveTrain driveTrain;
//
//    @Override
//    public void runOpMode()   throws InterruptedException {
//        this.driveTrain = new OmniDriveTrain(this.hardwareMap);
//
//        waitForStart();
//        while(opModeIsActive()) {
//            double turn = -gamepad1.right_stick_x;
//            double drive = -gamepad1.left_stick_y;
//            int direction = drive > 0 ? 1 : -1;
//
//            this.driveTrain.move(drive,direction);
//            this.driveTrain.turn(turn,direction);
//        }
//
//    }
//}

package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;





@TeleOp(name = "Omni Drive Test", group = "Linear Opmode")
public class OmniTest extends LinearOpMode{
    private OmniDriveTrain driveTrain;
    @Override
    public void runOpMode()   throws InterruptedException {
        this.driveTrain = new OmniDriveTrain(this.hardwareMap, this.telemetry);



        waitForStart();

        while (opModeIsActive()) {
            double xval = gamepad1.left_stick_x;
            double yval = gamepad1.left_stick_y;

            double xval2 = gamepad1.right_stick_x;
            int direction = 1;
            if(Math.abs(yval) < 0.1 && Math.abs(xval) < 0.1) {
                this.driveTrain.stop();

            } else if (Math.abs(xval)>0.1 || Math.abs(yval)>0.1) {
                if ((xval != 0 && Math.abs(yval) > 0) || Math.abs(yval / xval) > 0.5) {
                    telemetry.addData("Move Forward/back", yval);
                    direction = yval > 0 ? 1 : -1;
                    this.driveTrain.move(yval, direction);
                } else if (Math.abs(xval) > 0) {
                    telemetry.addData("Move Sideways", xval);
                    direction = xval > 0 ? 1 : -1;
                    this.driveTrain.crab(xval, direction);

                }
            }
            if(Math.abs(xval)>0.1){
                if (xval > 0){
                    this.driveTrain.turn(xval, direction);
                }
            }
//            } else if (Math.abs(xval) > 0.1 || Math.abs(yval) > 0.1){
//                if (yval > 0) {
//                    telemetry.addData("Move  Forward/Back", yval);
//                    this.driveTrain.move(yval, 1);
//                } else if (Math.abs(yval) < 0){
//                    this.driveTrain.move(yval, -1);
//                }
//            }
            telemetry.update();
            Thread.sleep(50);

        }
    }






}


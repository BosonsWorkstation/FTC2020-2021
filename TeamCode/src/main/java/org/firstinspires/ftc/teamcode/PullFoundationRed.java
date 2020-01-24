package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name = "Pull Foundation Red", group = "Linear Opmode")
public class PullFoundationRed extends LinearOpMode {
    private AutoOmniDriveTrain2 autoOmni;
//    private SkyStoneIntake intake;
    private FoundationArm foundation;
    private static final long INITIAL_WAIT = 1000;

    public void runOpMode() throws InterruptedException {
        this.autoOmni = new AutoOmniDriveTrain2(this.hardwareMap, this.telemetry);
        this.autoOmni.initMotors();
//        this.intake = new SkyStoneIntake(this.hardwareMap, this.telemetry);
        this.foundation = new FoundationArm(this.hardwareMap, this.telemetry);

        boolean parked = false;

        waitForStart();


        while (opModeIsActive() ){



            Thread.sleep(INITIAL_WAIT);



            if(!parked) {


//                this.autoOmni.moveDistance(75);
//                Thread.sleep(1000);
//                this.foundation.foundationUp();
//                Thread.sleep(2000);
//                this.autoOmni.setTurnDirections(1);
//                this.autoOmni.backRightWheel.setPower(.4);
//                this.autoOmni.backLeftWheel.setPower(.4);
//                this.autoOmni.frontRightWheel.setPower(.4);
//                this.autoOmni.frontLeftWheel.setPower(.4);'
//                this.autoOmni.moveDistance(-20);
//                Thread.sleep(200);



                this.autoOmni.crabbingDistance(-60);
                Thread.sleep(200);
                this.foundation.foundationDown1();
                this.foundation.foundationDown();
                Thread.sleep(500);
                this.autoOmni.crabbingDistance(60);


            }

            Thread.sleep(50);
            parked = true;
        }

    }
}

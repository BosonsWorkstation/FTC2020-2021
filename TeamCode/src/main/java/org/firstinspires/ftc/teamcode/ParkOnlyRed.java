package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name = "Park Only", group = "Linear Opmode")
public class ParkOnlyRed extends LinearOpMode {
    private AutoOmniDriveTrain autoOmni;
    private SkyStoneIntake intake;
    private static final long INITIAL_WAIT = 1000;

    public void runOpMode() throws InterruptedException {
        this.autoOmni = new AutoOmniDriveTrain(this.hardwareMap, this.telemetry);
        this.autoOmni.initMotors();
        this.intake = new SkyStoneIntake(this.hardwareMap, this.telemetry);
        boolean parked = false;

        waitForStart();


        while (opModeIsActive() ){



            Thread.sleep(INITIAL_WAIT);



            if(!parked) {
//                this.intake.down();
//                Thread.sleep(1000);
//                this.intake.up();

//                this.autoOmni.crabbingDistance(-40);

                this.autoOmni.moveDistance(20);

            }

            Thread.sleep(50);
            parked = true;
        }

    }
}

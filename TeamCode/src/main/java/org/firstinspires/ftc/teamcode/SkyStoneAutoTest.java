package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.bosch.BNO055IMU;
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

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


@Autonomous(name = "SkyStone Auto Test", group = "Linear Opmode")
public class SkyStoneAutoTest extends LinearOpMode{

    private AutoOmniDriveTrain autoOmni;
    private OmniDriveTrain driveTrain;
    private SkyStoneIntake intake;
    private SkyStoneStacker blockArm;
    BNO055IMU imu;

    @Override
    public void runOpMode() throws InterruptedException {
//        this.driveTrain = new OmniDriveTrain(this.hardwareMap, this.telemetry);
//        this.intake = new SkyStoneIntake(this.hardwareMap, this.telemetry);
        this.autoOmni = new AutoOmniDriveTrain(this.hardwareMap, this.telemetry);
//        this.blockArm = new SkyStoneStacker(this.hardwareMap, this.telemetry);
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        waitForStart();
        this.autoOmni.moveDistance(20);
       while (opModeIsActive()) {

           idle();
       }

    }
}

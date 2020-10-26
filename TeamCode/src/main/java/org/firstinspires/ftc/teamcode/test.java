package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous(name="AutonomousTest", group = "LinearOpMode")
public abstract class test extends LinearOpMode {

    DcMotor test_motor;
    protected void initialize(){
        test_motor = hardwareMap.dcMotor.get("test_motor");
    }






    @Override
    public void runOpMode() throws InterruptedException
    {

        this.initialize();

        waitForStart();

            test_motor.setPower(1);
            sleep(3000);
            test_motor.setPower(0);

            telemetry.addData("test_motor", test_motor.getPower());
            telemetry.update();
         idle();
    }

}



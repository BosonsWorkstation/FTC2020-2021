package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class FoundationArm {
    public Servo foundationArm;

    public FoundationArm(HardwareMap hardwareMap, Telemetry telemetry){
        foundationArm = hardwareMap.servo.get("Foundation_Arm");

    }

    public void foundationDown(){
        foundationArm.setPosition(-.5);
    }

    public void foundationUp(){
        foundationArm.setPosition(.5);
    }


}

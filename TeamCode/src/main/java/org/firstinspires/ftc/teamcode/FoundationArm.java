package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class FoundationArm {
    public Servo foundationArm;
    public Servo foundationArm1;

    public FoundationArm(HardwareMap hardwareMap, Telemetry telemetry){
        foundationArm = hardwareMap.servo.get("Foundation_Arm");
        foundationArm1 = hardwareMap.servo.get("Foundation_Arm1");

    }

    public void foundationDown(){
        foundationArm.setPosition(1);
    }

    public void foundationUp(){
        foundationArm.setPosition(.2);
    }

    public void foundationDown1(){
        foundationArm1.setPosition(1);
    }

    public void foundationUp1(){
        foundationArm1.setPosition(.2);
    }


}

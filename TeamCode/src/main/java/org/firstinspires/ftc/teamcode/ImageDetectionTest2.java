package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.vuforia.HINT;
import com.vuforia.Vuforia;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.Axis;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@TeleOp(name = "ImageDetectionTest2", group = "LinearOpMode")

public class ImageDetectionTest2 extends LinearOpMode {

    @Override
    public void runOpMode()   throws InterruptedException {

        //see what the camera sees on the phone screen
        VuforiaLocalizer.Parameters params = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);

        params.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        params.vuforiaLicenseKey = "Ad/93Wv/////AAABmcg6QmLviUmMnbMCYrQjy3korvz10+kHAA1/XifbTNTCgiUL/mfrfkC6ag6F0Ii4pxn6CXTEOPupW6u3H/hFZpwbuHEWxmCxmsyhCg3vJRl9gQbVMehyVIO4GUAYIf3b7FeLNCj7QCLLYg4NBdYy76cf3jO1Hs7ioyOhAyPeFPag5hE1pD8WV41QN7SCJ+hDSq+uOjUfZLPUVNwz0L7YID7f5D3agcY0OEq10xaS/dtZN4mpeQg6ElehC2Yhofgj+nsQZtu9V/LRCgdEyKSxyJyvqYF2dKiXdINi0tOHQrJd9++p+nYHc2J5eieGt8vP9CLMg0PeZl/QOjw3h0BULvTO1D7VHlP/ff3kk6Mfe2Po";
        params.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES;

        VuforiaLocalizer vuforia = ClassFactory.createVuforiaLocalizer(params);

        Vuforia.setHint(HINT.HINT_MAX_SIMULTANEOUS_IMAGE_TARGETS, 4);
        VuforiaTrackables beacons = vuforia.loadTrackablesFromAsset("RelicVuMark");
    }


}

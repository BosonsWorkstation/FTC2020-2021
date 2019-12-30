package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;


@Autonomous(name="Color Sensor Test", group="Linear OpMode")
public class ColorSensorTest extends AbstractSensorTest {

    ColorSensor colorSensor;


    @Override
    void initializeSensor(){
        colorSensor = hardwareMap.colorSensor.get("Color Sensor");

    }


    boolean isYellow(int red, int green, int blue){
        return red > 240 && green > 240 && blue < 80;
    }

    @Override
    void waitForSensor() {
        colorSensor.red();
        colorSensor.green();
        colorSensor.blue();
        boolean done;
        int red = 0;
        int blue = 0;
        int green = 0;

        done = isYellow(red,green,blue);

        while (!done){

            red = colorSensor.red();
            blue = colorSensor.blue();
            green =  colorSensor.green();

            telemetry.addData("RED:", red);
            telemetry.addData("BLUE:", blue);
            telemetry.addData("GREEN:", green);
            telemetry.update();

            done = isYellow(red,green,blue);
            sleep(10);

        }


    }
}

package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
@TeleOp(name="Color Sensing Fun")
public class Color extends LinearOpMode {
    ColorSensor s1;
    DcMotor motor1;
    DcMotor motor2;
    DistanceSensor s2;
}
@Override
public void init(HardwareMap hwMap) throws InterruptedException {
    // Motors defined
    motor1 = hardwareMap.dcMotor.get("motor1");
    motor2 = hardwareMap.dcMotor.get("motor2");
    //These sensors defined
    s1 = hwMap.get(ColorSensor.class, "ColorSense");
    s2 = hwMap.get(DistanceSensor.class, "DistanceSense");
    waitForStart();
    while(opModeIsActive()) {
        // Move motor a little bit
        //Checking yellow value
        if (s1.red() > s1.blue() && s1.green() > s1.blue()) {
            //Moves motors forward
            motor1.setPower(-1.00);
            motor2.setPower(1.00);
        }
    }
    motor1.setPower(0.00);
    motor2.setPower(0.00);
}

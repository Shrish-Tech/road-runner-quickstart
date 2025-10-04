package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class TeleOpv1 extends OpMode {
    protected DcMotor leftFront;
    protected DcMotor leftBack;
    protected DcMotor rightFront;
    protected DcMotor rightBack;
    @Override
    public void init(){
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");

        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);

    }
    @Override
    public void loop(){
        double x = -gamepad1.left_stick_x;;
        double y = -gamepad1.left_stick_y;
        double z = gamepad1.right_stick_x;

        double multiplier = 1;
        if (gamepad1.left_trigger > 0.1){
            multiplier *= 0.55;
        }
        if (gamepad1.right_trigger > 0.1){
            multiplier *= 0.55;
        }

        double v1 = Range.clip(y - x + z, -multiplier, multiplier);
        double v2 = Range.clip(y + x - z, -multiplier, multiplier);
        double v3 = Range.clip(y + x + z, -multiplier, multiplier);
        double v4 = Range.clip(y - x - z, -multiplier, multiplier);

        leftFront.setPower(v1);
        rightFront.setPower(v2);
        leftBack.setPower(v3);
        rightBack.setPower(v4);


    }
}
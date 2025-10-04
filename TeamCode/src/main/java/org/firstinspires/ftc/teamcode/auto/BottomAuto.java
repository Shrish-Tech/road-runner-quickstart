package org.firstinspires.ftc.teamcode.auto;


import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name = "BottomAuto", group = "Auto")
public class BottomAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException{
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(10,101,10));
        Pose2d startPose = new Pose2d(-24, -60, Math.toRadians(90));


        waitForStart();

        // Build the Action (like a trajectory sequence)
        Action path = drive.actionBuilder(startPose)
                .lineToX(30)
                .turn(Math.toRadians(90))
                .lineToY(30)
                .turn(Math.toRadians(90))
                .lineToX(0)
                .turn(Math.toRadians(90))
                .lineToY(0)
                .turn(Math.toRadians(90))
                .build();


        if (isStopRequested()) return;

        // Run the action
        Actions.runBlocking(new SequentialAction(path));
    }
}

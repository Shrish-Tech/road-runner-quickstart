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
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(-24,-60,Math.toRadians(90)));
        Pose2d startPose = new Pose2d(-24, -60, Math.toRadians(90));


        waitForStart();

        // Build the Action (like a trajectory sequence)
        Action path = drive.actionBuilder(startPose)
                .splineToLinearHeading(new Pose2d(-24,24,Math.toRadians(-45)),135)
                //.strafeTo(new Vector2d(-24,24))
                //.turn(Math.toRadians(-135))
                //shoot
                .strafeTo(new Vector2d(-24,-36))
                .turn(Math.toRadians(-135))
                .strafeTo(new Vector2d(-60,-36))
                //intake
                .strafeTo(new Vector2d(-24, -36))
                .splineToLinearHeading(new Pose2d(-24,24,Math.toRadians(-45)),135)
                //.strafeTo(new Vector2d(-24,24))
                //.turn(Math.toRadians(-45))
                //shoot
                .build();


        if (isStopRequested()) return;

        // Run the action
        Actions.runBlocking(new SequentialAction(path));
    }
}

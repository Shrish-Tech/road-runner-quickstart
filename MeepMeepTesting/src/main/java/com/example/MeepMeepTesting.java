package com.example;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-24, -60, Math.toRadians(90)))
                .strafeTo(new Vector2d(-24,24))
                .turn(Math.toRadians(-135))
                //shoot
                .strafeTo(new Vector2d(-24,-36))
                .turn(Math.toRadians(-135))
                .strafeTo(new Vector2d(-60,-36))
                //intake
                .strafeTo(new Vector2d(-24, -36))
                .strafeTo(new Vector2d(-24,24))
                .turn(Math.toRadians(-45))
                //shoot
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
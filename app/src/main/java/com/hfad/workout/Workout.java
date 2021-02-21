package com.hfad.workout;

public class Workout {

    private String name;
    private String desc;

    public static final Workout[] workouts = {
            new Workout("The Limb Loosener",
                    "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            new Workout("Core Agony",
                    "100 pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new Workout("Strength and Lengths",
                    "500 meters run\n21 x 1.5 pood kettleball swing\n21 x pull-ups")
    };

    private Workout(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}

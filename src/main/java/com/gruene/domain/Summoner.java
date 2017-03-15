package com.gruene.domain;

public class Summoner {
    private final int level;
    private final int profilePictureId;
    private final String name;

    public Summoner(int level, int profilePictureId, String name) {
        this.level = level;
        this.profilePictureId = profilePictureId;
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public int getProfilePictureId() {
        return profilePictureId;
    }

    public String getName() {
        return name;
    }
}

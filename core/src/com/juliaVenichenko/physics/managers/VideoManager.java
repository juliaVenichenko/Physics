package com.juliaVenichenko.physics.managers;

import com.badlogic.gdx.video.VideoPlayer;
import com.badlogic.gdx.video.VideoPlayerCreator;

public class VideoManager {
    public VideoPlayer videoPlayerMechanics1;
    public VideoPlayer videoPlayerThermal1;

    public VideoManager(){
        videoPlayerMechanics1 = VideoPlayerCreator.createVideoPlayer();
        videoPlayerThermal1 = VideoPlayerCreator.createVideoPlayer();
    }
}

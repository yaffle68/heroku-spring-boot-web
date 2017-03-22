package com.heroku.demo.service;

import java.util.List;

/**
 * Created by simon.harding on 22.03.2017.
 */
public interface TimeTrackService {

    public void addTimeTrack(TimeTrackDto timeTrack);

    public List<TimeTrackDto> listTimeTracks();
}

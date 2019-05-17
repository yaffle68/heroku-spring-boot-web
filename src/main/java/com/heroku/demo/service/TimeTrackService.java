package com.heroku.demo.service;

import ch.hvv.apps.hourcalculator.data.HoursEntry;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by simon.harding on 22.03.2017.
 */
public interface TimeTrackService {

    public void addTimeTrack(TimeTrackDto timeTrack, String userName);

    public List<TimeTrackDto> listTimeTracks();

    @Transactional(readOnly = true)
    List<HoursEntry> listHoursEntries();
}

package com.heroku.demo.rest;

import com.heroku.demo.domain.TimeTrack;
import com.heroku.demo.domain.TimeTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by simon.harding on 22.03.2017.
 */
@RestController
@RequestMapping("/rest/")
public class TimeTrackController {

    @Autowired
    TimeTrackRepository timeTrackRepository;

    @GetMapping("timetracks")
    public List<TimeTrack> getTimetracks() {
        return timeTrackRepository.findAll();
    }
}

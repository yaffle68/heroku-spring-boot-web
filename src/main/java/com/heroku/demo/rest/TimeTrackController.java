package com.heroku.demo.rest;

import ch.hvv.apps.hourcalculator.data.HoursEntry;
import ch.hvv.apps.hourcalculator.data.HoursEntryList;
import com.heroku.demo.domain.TimeTrack;
import com.heroku.demo.domain.TimeTrackRepository;
import com.heroku.demo.service.MailService;
import com.heroku.demo.service.TimeTrackDto;
import com.heroku.demo.service.TimeTrackService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by simon.harding on 22.03.2017.
 */
@RestController
@RequestMapping("/rest/")
public class TimeTrackController {

    @Autowired
    TimeTrackService service;

    @Autowired
    MailService mailService;

    @ApiOperation(value = "Lists all TimeTracks",
            notes = "Lists all TimeTracks without any restrictions.",
            response = TimeTrackDto.class,
            responseContainer = "List")
    @GetMapping("timetracks")
    public List<TimeTrackDto> getTimetracks() {
        return service.listTimeTracks();
//        return timeTrackRepository.findAll();
    }

    @GetMapping("hoursentries")
    public ResponseEntity<HoursEntryList> getHoursEntries() {
        return new ResponseEntity<HoursEntryList>(service.listHoursEntries(), HttpStatus.OK);
    }

    @GetMapping("clockon")
    public ResponseEntity<String> clockOn(@RequestParam String name) {
        mailService.sendMail(name);

        return  new ResponseEntity<>("Merci, " + name + "!", HttpStatus.OK);
    }

}

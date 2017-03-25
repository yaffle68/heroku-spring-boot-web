package com.heroku.demo.service.internal;

import com.heroku.demo.domain.Status;
import com.heroku.demo.domain.TimeTrack;
import com.heroku.demo.domain.TimeTrackRepository;
import com.heroku.demo.mapping.TimeTrackMapper;
import com.heroku.demo.service.TimeTrackDto;
import com.heroku.demo.service.TimeTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by simon.harding on 22.03.2017.
 */
@Service
public class TimeTrackServiceImpl implements TimeTrackService {

    @Autowired
    TimeTrackMapper mapper;

    @Autowired
    TimeTrackRepository repository;

    @Override
    @Transactional(readOnly = false)
    public void addTimeTrack(TimeTrackDto timeTrackDto) {
        TimeTrack timeTrack = mapper.fromDto(timeTrackDto);

        // FIXME Employee from login context...
        timeTrack.setEmployee("Dummy Employee");
        timeTrack.setCreationTs(LocalDateTime.now());
        timeTrack.setStatus(Status.INITIAL);
        repository.save(timeTrack);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TimeTrackDto> listTimeTracks() {
        return mapper.toDtos(repository.findAll());
    }
}

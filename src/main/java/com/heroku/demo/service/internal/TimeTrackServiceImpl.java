package com.heroku.demo.service.internal;

import com.heroku.demo.domain.TimeTrack;
import com.heroku.demo.domain.TimeTrackRepository;
import com.heroku.demo.mapping.TimeTrackMapper;
import com.heroku.demo.service.TimeTrackDto;
import com.heroku.demo.service.TimeTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        repository.save(timeTrack);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TimeTrackDto> listTimeTracks() {
        return mapper.toDtos(repository.findAll());
    }
}

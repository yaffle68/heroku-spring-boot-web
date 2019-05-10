package com.heroku.demo.mapping;

import com.heroku.demo.domain.TimeTrack;
import com.heroku.demo.service.TimeTrackDto;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by simon.harding on 22.03.2017.
 */
@Component
public class TimeTrackMapper {

    Mapper mapper;


    @Autowired
    public TimeTrackMapper(Mapper theMapper) {
        mapper = theMapper;
    }

    public TimeTrack fromDto(final TimeTrackDto dto) {
        return mapper.map(dto,TimeTrack.class);
    }

    public TimeTrackDto toDto(final TimeTrack entity) {
        return mapper.map(entity, TimeTrackDto.class);
    }

    public List<TimeTrackDto> toDtos(List<TimeTrack> timeTracks) {
        return timeTracks.stream().map(timeTrack -> toDto(timeTrack)).collect(Collectors.toList());
    }
}

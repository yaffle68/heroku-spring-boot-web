package com.heroku.demo.mapping;

import ch.hvv.apps.hourcalculator.data.HoursEntry;
import com.heroku.demo.domain.TimeTrack;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HoursEntryMapper {

    Mapper mapper;

    @Autowired
    public HoursEntryMapper(Mapper theMapper) {
        mapper = theMapper;
    }

    public TimeTrack fromDto(final HoursEntry dto) {
        return mapper.map(dto,TimeTrack.class);
    }

    public HoursEntry toDto(final TimeTrack entity) {
        return mapper.map(entity, HoursEntry.class);
    }

    public List<HoursEntry> toDtos(List<TimeTrack> timeTracks) {
        return timeTracks.stream().map(timeTrack -> toDto(timeTrack)).collect(Collectors.toList());
    }
}

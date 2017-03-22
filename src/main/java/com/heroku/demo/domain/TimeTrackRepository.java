package com.heroku.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTrackRepository extends JpaRepository<TimeTrack, Long> {
}

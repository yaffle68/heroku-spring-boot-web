package com.heroku.demo.domain.gen;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.heroku.demo.domain.Station;
import com.heroku.demo.domain.Status;
import com.heroku.demo.domain.TimeTrack;
import com.heroku.demo.domain.TimeTrackRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Profile("dev")
public class TimeTrackFactory implements ApplicationListener<ContextRefreshedEvent> {

    private static final int MAX_EMPLOYEES = 4;
    private TimeTrackRepository timeTrackRepository;

    private Logger log = Logger.getLogger(TimeTrackFactory.class);

    private final List<String> employees;

    public TimeTrackFactory() {
        employees = generateEmployees();
    }


    @Autowired
    public void setTimeTrackRepository(TimeTrackRepository TimeTrackRepository) {
        this.timeTrackRepository = TimeTrackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        generateInitialData();

        LocalDate date = randomDate();
        LocalTime start = randomTime();
        TimeTrack one = timeTrackRepository.save(createTimeTrack("bella", Station.AVENCHES, date, start, randomEndTime(start)));
        log.info("Saved TimeTrack - id: " + one.getId());

        start = randomTime();
        TimeTrack two = timeTrackRepository.save(createTimeTrack("harry", Station.GAMPELEN, date, start, randomEndTime(start)));
        log.info("Saved TimeTrack - id:" + two.getId());
    }

    private List<String> generateEmployees() {
        List<String> employeeNames = new ArrayList<String>();
        Random random = new Random();

        int numEmployees = random.nextInt(MAX_EMPLOYEES) + 2;
        Range range = Range.closed(1, numEmployees);

        ContiguousSet<Integer> employeeNumbers = ContiguousSet.create(Range.closed(1, 6), DiscreteDomain.integers());

        for (Integer next : employeeNumbers) {
           employeeNames.add(new BigInteger(130, random).toString(32));
        }
        return employeeNames;
    }

    private void generateInitialData() {
        Random rand = new Random();
        int numEntries = rand.nextInt(5) + 1;// * 100;
        for (int i = 0; i < numEntries; i++) {
            addEntry(i);
        }
    }

    private void addEntry(int i) {
        LocalDate date = randomDate();
        LocalTime start = randomTime();
        String employee = randomEmployee();
        TimeTrack one = timeTrackRepository.save(createTimeTrack(employee, randomStation(), date, start, randomEndTime(start)));
        log.info("Saved TimeTrack - id: " + one.getId());
    }

    private String randomEmployee() {
        Random random = new Random();
        int index = random.nextInt(employees.size() -1);
        return employees.get(index);
    }

    private Station randomStation() {
        Random random = new Random();
        int index = random.nextInt(1000);
        return Station.values()[index %2];
    }


    public static TimeTrack createTimeTrack(String employee, Station station, LocalDate date, LocalTime start, LocalTime end) {
        TimeTrack newTimeTrack = new TimeTrack();
        newTimeTrack.setDate(date);
        newTimeTrack.setCreationTs(LocalDateTime.now());
        newTimeTrack.setEmployee(employee);
        newTimeTrack.setStartTs(start);
        newTimeTrack.setEndTs(end);
        newTimeTrack.setStation(station);
        newTimeTrack.setStatus(Status.INITIAL);

        return newTimeTrack;
    }

    private static int randomMark() {
        return new Random().nextInt(100);
    }

    private static LocalDate randomDate() {
        Random random = new Random();
        return LocalDate.of(2017, random.nextInt(11) + 1, random.nextInt(27) + 1);
    }

    private static LocalTime randomTime() {
        Random random = new Random();
        return LocalTime.of(random.nextInt(23), random.nextInt(59));
    }

    private static LocalTime randomEndTime(LocalTime start) {
        Random random = new Random();
        long randomHours = new Integer(random.nextInt(4)).longValue();
        long randomMinutes = new Integer(random.nextInt(59)).longValue();
        return start.plusHours(randomHours).plusMinutes(randomMinutes);
    }
}
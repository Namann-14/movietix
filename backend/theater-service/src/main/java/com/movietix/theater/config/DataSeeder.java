package com.movietix.theater.config;

import com.movietix.theater.entity.Theater;
import com.movietix.theater.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final TheaterRepository theaterRepository;

    @Override
    public void run(String... args) throws Exception {
        if (theaterRepository.count() == 0) {
            log.info("Seeding theater database...");
            List<Theater> theaters = Arrays.asList(
                Theater.builder()
                    .name("AMC Empire 25")
                    .location("Times Square, New York")
                    .seatingCapacity(250)
                    .build(),
                Theater.builder()
                    .name("IMAX Metreon 16")
                    .location("Downtown, San Francisco")
                    .seatingCapacity(300)
                    .build(),
                Theater.builder()
                    .name("Regal LA Live")
                    .location("Downtown, Los Angeles")
                    .seatingCapacity(200)
                    .build(),
                Theater.builder()
                    .name("Alamo Drafthouse Ritz")
                    .location("Austin, Texas")
                    .seatingCapacity(150)
                    .build(),
                Theater.builder()
                    .name("Chinese Theatre")
                    .location("Hollywood, California")
                    .seatingCapacity(180)
                    .build()
            );
            theaterRepository.saveAll(theaters);
            log.info("Successfully seeded {} theaters", theaters.size());
        } else {
            log.info("Theater database already contains data. Skipping seeding.");
        }
    }
}

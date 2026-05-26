package com.movietix.showtime.config;

import com.movietix.showtime.entity.Showtime;
import com.movietix.showtime.repository.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final ShowtimeRepository showtimeRepository;

    @Override
    public void run(String... args) throws Exception {
        if (showtimeRepository.count() == 0) {
            log.info("Seeding showtime database with dynamic future shows...");
            List<Showtime> showtimes = new ArrayList<>();
            LocalDate today = LocalDate.now();
            
            LocalTime[] times = {
                LocalTime.of(13, 0),  // 1:00 PM
                LocalTime.of(16, 30), // 4:30 PM
                LocalTime.of(19, 30), // 7:30 PM
                LocalTime.of(22, 0)   // 10:00 PM
            };
            
            BigDecimal[] prices = {
                BigDecimal.valueOf(12.50),
                BigDecimal.valueOf(15.00),
                BigDecimal.valueOf(18.50),
                BigDecimal.valueOf(14.00)
            };

            int[] capacities = {250, 300, 200, 150, 180}; // matches theater capacity

            for (int dayOffset = 0; dayOffset < 7; dayOffset++) {
                LocalDate date = today.plusDays(dayOffset);
                
                for (int tIdx = 0; tIdx < times.length; tIdx++) {
                    LocalTime time = times[tIdx];
                    LocalDateTime showDateTime = LocalDateTime.of(date, time);
                    BigDecimal price = prices[tIdx];
                    
                    // Movie 1 (Interstellar, ID=1) in Theater 1 (ID=1) and Theater 2 (ID=2)
                    showtimes.add(createShow(1L, 1L, showDateTime, price, capacities[0]));
                    showtimes.add(createShow(1L, 2L, showDateTime.plusMinutes(30), price.add(BigDecimal.valueOf(3.00)), capacities[1]));
                    
                    // Movie 2 (Inception, ID=2) in Theater 2 (ID=2) and Theater 3 (ID=3)
                    showtimes.add(createShow(2L, 2L, showDateTime, price.add(BigDecimal.valueOf(3.00)), capacities[1]));
                    showtimes.add(createShow(2L, 3L, showDateTime.plusMinutes(15), price, capacities[2]));
                    
                    // Movie 3 (The Dark Knight, ID=3) in Theater 3 (ID=3) and Theater 4 (ID=4)
                    showtimes.add(createShow(3L, 3L, showDateTime, price, capacities[2]));
                    showtimes.add(createShow(3L, 4L, showDateTime.plusMinutes(45), price, capacities[3]));
                    
                    // Movie 4 (Avatar, ID=4) in Theater 2 (ID=2) and Theater 5 (ID=5)
                    showtimes.add(createShow(4L, 2L, showDateTime.minusMinutes(30), price.add(BigDecimal.valueOf(4.00)), capacities[1]));
                    showtimes.add(createShow(4L, 5L, showDateTime, price, capacities[4]));
                    
                    // Movie 5 (Dune: Part Two, ID=5) in Theater 1 (ID=1) and Theater 2 (ID=2)
                    showtimes.add(createShow(5L, 1L, showDateTime.plusHours(1), price, capacities[0]));
                    showtimes.add(createShow(5L, 2L, showDateTime, price.add(BigDecimal.valueOf(3.00)), capacities[1]));
                    
                    // Movie 6 (Everything Everywhere All at Once, ID=6) in Theater 4 (ID=4)
                    if (tIdx % 2 == 0) {
                        showtimes.add(createShow(6L, 4L, showDateTime, price, capacities[3]));
                    }
                    
                    // Movie 7 (Avengers: Endgame, ID=7) in Theater 1 (ID=1) and Theater 3 (ID=3)
                    showtimes.add(createShow(7L, 1L, showDateTime, price, capacities[0]));
                    showtimes.add(createShow(7L, 3L, showDateTime.plusMinutes(30), price, capacities[2]));
                    
                    // Movie 8 (Spirited Away, ID=8) in Theater 5 (ID=5)
                    if (tIdx % 2 == 1) {
                        showtimes.add(createShow(8L, 5L, showDateTime, price.subtract(BigDecimal.valueOf(2.00)), capacities[4]));
                    }
                }
            }
            
            showtimeRepository.saveAll(showtimes);
            log.info("Successfully seeded {} showtimes", showtimes.size());
        } else {
            log.info("Showtime database already contains data. Skipping seeding.");
        }
    }

    private Showtime createShow(Long movieId, Long theaterId, LocalDateTime dateTime, BigDecimal price, int capacity) {
        return Showtime.builder()
                .movieId(movieId)
                .theaterId(theaterId)
                .showDateTime(dateTime)
                .ticketPrice(price)
                .availableSeats(capacity)
                .build();
    }
}

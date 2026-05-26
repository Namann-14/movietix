package com.movietix.movie.config;

import com.movietix.movie.entity.Movie;
import com.movietix.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        if (movieRepository.count() == 0) {
            log.info("Seeding movie database...");
            List<Movie> movies = Arrays.asList(
                Movie.builder()
                    .title("Interstellar")
                    .genre("Sci-Fi")
                    .durationInMinutes(169)
                    .releaseDate(LocalDate.of(2014, 11, 7))
                    .description("A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.")
                    .build(),
                Movie.builder()
                    .title("Inception")
                    .genre("Sci-Fi")
                    .durationInMinutes(148)
                    .releaseDate(LocalDate.of(2010, 7, 16))
                    .description("A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.")
                    .build(),
                Movie.builder()
                    .title("The Dark Knight")
                    .genre("Action")
                    .durationInMinutes(152)
                    .releaseDate(LocalDate.of(2008, 7, 18))
                    .description("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.")
                    .build(),
                Movie.builder()
                    .title("Avatar: The Way of Water")
                    .genre("Sci-Fi")
                    .durationInMinutes(192)
                    .releaseDate(LocalDate.of(2022, 12, 16))
                    .description("Jake Sully lives with his newfound family formed on the extrasolar moon Pandora. Once a familiar threat returns to finish what was previously started, Jake must work with Neytiri and the army of the Na'vi race to protect their home.")
                    .build(),
                Movie.builder()
                    .title("Dune: Part Two")
                    .genre("Sci-Fi")
                    .durationInMinutes(166)
                    .releaseDate(LocalDate.of(2024, 3, 1))
                    .description("Paul Atreides unites with Chani and the Fremen while seeking revenge against the conspirators who destroyed his family.")
                    .build(),
                Movie.builder()
                    .title("Everything Everywhere All at Once")
                    .genre("Comedy")
                    .durationInMinutes(139)
                    .releaseDate(LocalDate.of(2022, 3, 25))
                    .description("A middle-aged Chinese immigrant is swept up into an insane adventure in which she alone can save existence by exploring other universes and connecting with the lives she could have led.")
                    .build(),
                Movie.builder()
                    .title("Avengers: Endgame")
                    .genre("Action")
                    .durationInMinutes(181)
                    .releaseDate(LocalDate.of(2019, 4, 26))
                    .description("After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.")
                    .build(),
                Movie.builder()
                    .title("Spirited Away")
                    .genre("Animation")
                    .durationInMinutes(125)
                    .releaseDate(LocalDate.of(2001, 7, 20))
                    .description("During her family's move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches, and spirits, and where humans are changed into beasts.")
                    .build()
            );
            movieRepository.saveAll(movies);
            log.info("Successfully seeded {} movies", movies.size());
        } else {
            log.info("Movie database already contains data. Skipping seeding.");
        }
    }
}

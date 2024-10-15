package com.prattis.samplemoviedatabase.bootstrap;

import com.prattis.samplemoviedatabase.model.*;
import com.prattis.samplemoviedatabase.model.enums.NominationResultType;
import com.prattis.samplemoviedatabase.model.enums.SalaryType;
import com.prattis.samplemoviedatabase.service.*;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class SampleContent implements CommandLineRunner {
    
    private final ActorService actorService;
    private final CrewMemberService crewMemberService;
    private final DirectorService directorService;
    private final EpisodeService episodeService;
    private final MovieService movieService;
    private final NominationResultService nominationResultService;
    private final NominationService nominationService;
    private final ProducerService producerService;
    private final TvShowService tvShowService;
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Override
    public void run(String... args) {
        
        ////////////////////////////////////
        // Define and Persist Actors here
        ////////////////////////////////////
        
        Actor actor1 = Actor.builder()
                .name("Antony Hopkins")
                .salary(BigDecimal.valueOf(100L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Actor actor2 = Actor.builder()
                .name("Gary Oldman")
                .salary(BigDecimal.valueOf(200L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Actor actor3 = Actor.builder()
                .name("Christian Bale")
                .salary(BigDecimal.valueOf(300L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Actor actor4 = Actor.builder()
                .name("Cate Blanchett")
                .salary(BigDecimal.valueOf(250L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Actor actor5 = Actor.builder()
                .name("Robert De Niro")
                .salary(BigDecimal.valueOf(350L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Actor actor6 = Actor.builder()
                .name("Al Pacino")
                .salary(BigDecimal.valueOf(150L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Actor actor7 = Actor.builder()
                .name("Denzel Washington")
                .salary(BigDecimal.valueOf(250L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        saveActors(actor1,actor2,actor3,actor4,actor5,actor6,actor7);

        //logging for creation of actors
        List<Actor> actorList = List.of(actor1,actor2,actor3,actor4,actor5,actor6,actor7);
        logger.info("Created {} actors", actorList.size());

        ////////////////////////////////////
        // Define and Persist CrewMembers here
        ////////////////////////////////////
        
        CrewMember crewMember1 = CrewMember.builder()
                .name("Michael Camera")
                .salary(BigDecimal.valueOf(110L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        CrewMember crewMember2 = CrewMember.builder()
                .name("Jenny Microphone")
                .salary(BigDecimal.valueOf(210L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        CrewMember crewMember3 = CrewMember.builder()
                .name("John Panel")
                .salary(BigDecimal.valueOf(310L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        CrewMember crewMember4 = CrewMember.builder()
                .name("John Panel")
                .salary(BigDecimal.valueOf(120L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        CrewMember crewMember5 = CrewMember.builder()
                .name("Mary Panel")
                .salary(BigDecimal.valueOf(220L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        CrewMember crewMember6 = CrewMember.builder()
                .name("Nick Camera")
                .salary(BigDecimal.valueOf(150L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        CrewMember crewMember7 = CrewMember.builder()
                .name("Paul Music")
                .salary(BigDecimal.valueOf(250L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        saveCrewMembers(crewMember1, crewMember2, crewMember3, crewMember4, crewMember5, crewMember6, crewMember7);

        //logging for creation of crewMembers
        List<CrewMember> crewMemberList = List.of(crewMember1, crewMember2, crewMember3, crewMember4, crewMember5, crewMember6, crewMember7);
        logger.info("Created {} crewMembers", crewMemberList.size());

        ////////////////////////////////////
        // Define and Persist Directors here
        ////////////////////////////////////
        
        Director director1 = Director.builder()
                .name("Christopher Nolan")
                .salary(BigDecimal.valueOf(120L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Director director2 = Director.builder()
                .name("Zack Snyder")
                .salary(BigDecimal.valueOf(220L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Director director3 = Director.builder()
                .name("Steven Spielberg")
                .salary(BigDecimal.valueOf(320L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Director director4 = Director.builder()
                .name("Martin Scorsese")
                .salary(BigDecimal.valueOf(330L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Director director5 = Director.builder()
                .name("Quentin Tarantino")
                .salary(BigDecimal.valueOf(230L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Director director6 = Director.builder()
                .name("Sofia Coppola")
                .salary(BigDecimal.valueOf(120L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Director director7 = Director.builder()
                .name("Guillermo del Toro")
                .salary(BigDecimal.valueOf(150L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        saveDirectors(director1,director2,director3,director4,director5,director6,director7);

        //logging for creation of directors
        List<Director> directorList = List.of(director1,director2,director3,director4,director5,director6,director7);
        logger.info("Created {} directors", directorList.size());

        ////////////////////////////////////
        // Define and Persist Producers here
        ////////////////////////////////////
        
        Producer producer1 = Producer.builder()
                .name("Michael Bay")
                .salary(BigDecimal.valueOf(120L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Producer producer2 = Producer.builder()
                .name("Jerry Bruckheimer")
                .salary(BigDecimal.valueOf(220L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Producer producer3 = Producer.builder()
                .name("Dick Wolf")
                .salary(BigDecimal.valueOf(320L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Producer producer4 = Producer.builder()
                .name("Max Martin")
                .salary(BigDecimal.valueOf(310L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Producer producer5 = Producer.builder()
                .name("Brian Eno")
                .salary(BigDecimal.valueOf(330L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Producer producer6 = Producer.builder()
                .name("Rick Rubin")
                .salary(BigDecimal.valueOf(220L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        Producer producer7 = Producer.builder()
                .name("George Martin")
                .salary(BigDecimal.valueOf(120L))
                .salaryType(SalaryType.PER_EPISODE)
                .build();
        saveProducers(producer1, producer2, producer3, producer4, producer5, producer6, producer7);

        //logging for creation of producers
        List<Producer> producerList = List.of(producer1, producer2, producer3, producer4, producer5, producer6, producer7);
        logger.info("Created {} producers", producerList.size());

        ////////////////////////////////////
        // Define and Persist Movies here
        ////////////////////////////////////
        
        Movie movie1 = Movie.builder()
                .title("Star Wars: The Phantom Menace")
                .genre("Fiction")
                .director(director2)
                .actors(List.of(actor1, actor2))
                .producers(List.of(producer3, producer2))
                .crewMembers(List.of(crewMember1, crewMember2))
                .productionBudget(BigDecimal.valueOf(10000L))
                .yearOfRelease(2020)
                .build();
        Movie movie2 = Movie.builder()
                .title("The Titanic")
                .genre("Romance")
                .director(director3)
                .actors(List.of(actor2, actor3))
                .producers(List.of(producer1, producer3))
                .crewMembers(List.of(crewMember1, crewMember2, crewMember3))
                .productionBudget(BigDecimal.valueOf(20000L))
                .yearOfRelease(2021)
                .build();
        Movie movie3 = Movie.builder()
                .title("Dune 2")
                .genre("Adventure")
                .director(director1)
                .actors(List.of(actor1, actor3))
                .producers(List.of(producer1, producer2))
                .crewMembers(List.of(crewMember2, crewMember3))
                .productionBudget(BigDecimal.valueOf(30000L))
                .yearOfRelease(2022)
                .build();
        Movie movie4 = Movie.builder()
            .title("Interstellar")
            .genre("Fantasy")
            .director(director1)
            .actors(List.of(actor1, actor3))
            .producers(List.of(producer1, producer2))
            .crewMembers(List.of(crewMember2, crewMember3))
            .productionBudget(BigDecimal.valueOf(30000L))
            .yearOfRelease(2022)
            .build();
        Movie movie5 = Movie.builder()
            .title("Avatar")
            .genre("Adventure")
            .director(director1)
            .actors(List.of(actor1, actor3))
            .producers(List.of(producer1, producer2))
            .crewMembers(List.of(crewMember2, crewMember3))
            .productionBudget(BigDecimal.valueOf(30000L))
            .yearOfRelease(2022)
            .build();
        saveMovies(movie1, movie2, movie3,movie4,movie5);

        //logging for creation of movies
        List<Movie> movieList = List.of(movie1,movie2,movie3,movie4,movie5);
        logger.info("Created {} movies", movieList.size());
        
        ////////////////////////////////////
        // Define Episodes here
        ////////////////////////////////////
        
        Episode episode1 = Episode.builder()
                .minimumProductionBudget(BigDecimal.valueOf(1000L))
                .maximumProductionBudget(BigDecimal.valueOf(1500L))
                .build();
        Episode episode2 = Episode.builder()
                .minimumProductionBudget(BigDecimal.valueOf(2000L))
                .maximumProductionBudget(BigDecimal.valueOf(2500L))
                .build();
        Episode episode3 = Episode.builder()
                .minimumProductionBudget(BigDecimal.valueOf(3000L))
                .maximumProductionBudget(BigDecimal.valueOf(3500L))
                .build();
        Episode episode4 = Episode.builder()
            .minimumProductionBudget(BigDecimal.valueOf(5000L))
            .maximumProductionBudget(BigDecimal.valueOf(2500L))
            .build();
        Episode episode5 = Episode.builder()
            .minimumProductionBudget(BigDecimal.valueOf(1000L))
            .maximumProductionBudget(BigDecimal.valueOf(3500L))
            .build();
        saveEpisodes(episode1, episode2, episode3,episode4,episode5);

        //logging for creation of episodes
        List<Episode> episodeList = List.of(episode1,episode2,episode3,episode4,episode5);
        logger.info("Created {} episodes", episodeList.size());

        ////////////////////////////////////
        // Define and Persist TvShows here
        ////////////////////////////////////
        
        TvShow tvShow1 = TvShow.builder()
                .title("How I Met Your Mother")
                .genre("Rom-Com")
                .director(director2)
                .actors(List.of(actor1, actor2))
                .producers(List.of(producer3, producer2))
                .crewMembers(List.of(crewMember1))
                .startingYear(2010)
                .endingYear(2020)
                .numberOfEpisodes(1)
                .episodes(Set.of(episode2))
                .build();
        TvShow tvShow2 = TvShow.builder()
                .title("Loki")
                .genre("Fiction")
                .director(director1)
                .actors(List.of(actor1, actor2, actor3))
                .producers(List.of(producer1, producer2))
                .crewMembers(List.of(crewMember2))
                .startingYear(2020)
                .endingYear(2030)
                .numberOfEpisodes(1)
                .episodes(Set.of(episode3))
                .build();
        TvShow tvShow3 = TvShow.builder()
                .title("Game Of Thrones")
                .genre("Fantasy")
                .director(director3)
                .actors(List.of(actor1, actor3))
                .producers(List.of(producer3, producer2, producer1))
                .crewMembers(List.of(crewMember1, crewMember2, crewMember3))
                .startingYear(2030)
                .endingYear(2040)
                .numberOfEpisodes(1)
                .episodes(Set.of(episode1))
                .build();
        TvShow tvShow4 = TvShow.builder()
            .title("Friends")
            .genre("Comedy")
            .director(director3)
            .actors(List.of(actor1, actor3))
            .producers(List.of(producer3, producer2, producer1))
            .crewMembers(List.of(crewMember1, crewMember2, crewMember3))
            .startingYear(2030)
            .endingYear(2040)
            .numberOfEpisodes(1)
            .episodes(Set.of(episode1))
            .build();
        TvShow tvShow5 = TvShow.builder()
            .title("Stranger Things")
            .genre("Fantasy")
            .director(director3)
            .actors(List.of(actor1, actor3))
            .producers(List.of(producer3, producer2, producer1))
            .crewMembers(List.of(crewMember1, crewMember2, crewMember3))
            .startingYear(2030)
            .endingYear(2040)
            .numberOfEpisodes(1)
            .episodes(Set.of(episode1))
            .build();
        saveTvShows(tvShow1, tvShow2, tvShow3);

        //logging for creation of tvShows
        List<TvShow> tvShowList = List.of(tvShow1,tvShow2,tvShow3, tvShow4, tvShow5);
        logger.info("Created {} tvShows", tvShowList.size());
        
        ////////////////////////////////////
        // Define and Persist Nominations here
        ////////////////////////////////////
        
        Nomination nomination1 = Nomination.builder()
                .nominationYear(2020)
                .genre("Fantasy")
                .build();
        Nomination nomination2 = Nomination.builder()
                .nominationYear(2030)
                .genre("Rom-Com")
                .build();
        Nomination nomination3 = Nomination.builder()
                .nominationYear(2040)
                .genre("Horror")
                .build();
        Nomination nomination4 = Nomination.builder()
            .nominationYear(2010)
            .genre("Horror")
            .build();
        Nomination nomination5 = Nomination.builder()
            .nominationYear(2032)
            .genre("Horror")
            .build();
        saveNominations(nomination1, nomination2, nomination3,nomination4, nomination5);

        //logging for creation of nominations
        List<Nomination> nominationList = List.of(nomination1,nomination2,nomination3, nomination4, nomination5);
        logger.info("Created {} nominations", nominationList.size());

        ////////////////////////////////////
        // Define and Persist NominationResults here
        ////////////////////////////////////
        NominationResult nominationResult1 = NominationResult.builder()
                .nominationResultId(new NominationResultId(1, 2))
                .actor(actor1)
                .nomination(nomination2)
                .nominationResultType(NominationResultType.NOMINATED)
                .build();
        NominationResult nominationResult2 = NominationResult.builder()
                .nominationResultId(new NominationResultId(2, 3))
                .actor(actor2)
                .nomination(nomination3)
                .nominationResultType(NominationResultType.WON)
                .build();
        NominationResult nominationResult3 = NominationResult.builder()
                .nominationResultId(new NominationResultId(3, 1))
                .actor(actor3)
                .nomination(nomination1)
                .nominationResultType(NominationResultType.NOMINATED)
                .build();
        saveNominationResults(nominationResult1, nominationResult2, nominationResult3);

        //logging for creation of nominationResults
        List<NominationResult> nominationResultList = List.of(nominationResult1,nominationResult2,nominationResult3);
        logger.info("Created {} nominationResults", nominationResultList.size());
    }
    
    // Persist Actors in database
    private void saveActors(Actor... actors) {
        for (Actor actor : actors) {
            actorService.create(actor);
        }
    }
    
    // Persist CrewMembers in database
    private void saveCrewMembers(CrewMember... crewMembers) {
        for (CrewMember crewMember : crewMembers) {
            crewMemberService.create(crewMember);
        }
    }
    
    // Persist Directors in database
    private void saveDirectors(Director... directors) {
        for (Director director : directors) {
            directorService.create(director);
        }
    }
    
    // Persist Producers in database
    private void saveProducers(Producer... producers) {
        for (Producer producer : producers) {
            producerService.create(producer);
        }
    }
    
    // Persist Movies in database
    private void saveMovies(Movie... movies) {
        for (Movie movie : movies) {
            movieService.create(movie);
        }
    }
    
    // Persist Episodes in database
    private void saveEpisodes(Episode... episodes) {
        for (Episode episode : episodes) {
            episodeService.create(episode);
        }
    }
    
    // Persist TvShows in database
    private void saveTvShows(TvShow... tvShows) {
        for (TvShow tvShow : tvShows) {
            tvShowService.create(tvShow);
        }
    }
    
    // Persist Nominations in database
    private void saveNominations(Nomination... nominations) {
        for (Nomination nomination : nominations) {
            nominationService.create(nomination);
        }
    }
    
    // Persist NominationResults in database
    private void saveNominationResults(NominationResult... nominationResults) {
        for (NominationResult nominationResult : nominationResults) {
            nominationResultService.create(nominationResult);
        }
    }
}

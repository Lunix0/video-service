package ma.xproce.videoservice;

import ma.xproce.videoservice.dao.entities.Creator;
import ma.xproce.videoservice.dao.entities.Video;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ma.xproce.videoservice.dao.repositories.*;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class VideoServiceApplication {

	public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
	}
    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {

            List<Creator> creators = List.of(
                    Creator.builder().name("MrBeast").email("mrbeast@example.com").build(),
                    Creator.builder().name("PewDiePie").email("pewdiepie@example.com").build()
            );


            creatorRepository.saveAll(creators);

            // --- Création des vidéos ---
            List<Video> videos = List.of(
                    Video.builder()
                            .name("I boought everything in a Store")
                            .url("https://www.youtube.com/watch?v=mrbeast1")
                            .description("MrBeast achète tout dans un magasin !")
                            .datePublication(new Date(1998, 03, 25))
                            .creator(creators.get(0)) // MrBeast
                            .build(),

                    Video.builder()
                            .name("Minecraft Hardcore Series")
                            .url("https://www.youtube.com/watch?v=pewdiepie1")
                            .description("PewDiePie joue à Minecraft Hardcore")
                            .datePublication(new Date(1998, 03, 25))
                            .creator(creators.get(1)) // PewDiePie
                            .build()
            );


            videoRepository.saveAll(videos);

        };
    }


}

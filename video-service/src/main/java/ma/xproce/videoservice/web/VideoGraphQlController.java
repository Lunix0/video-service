package ma.xproce.videoservice.web;

import ma.xproce.videoservice.dao.entities.*;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ma.xproce.videoservice.dao.repositories.*;

import java.util.List;


@Controller
public class VideoGraphQlController {
    private final CreatorRepository creatorRepository;
    private final VideoRepository videoRepository;
    VideoGraphQlController(CreatorRepository creatorRepository, VideoRepository videoRepository){
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
    }
    @QueryMapping
    public List<Video> videoList(){
        return videoRepository.findAll();
    }
    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Creator  %s notfound",id)));
    }
    @QueryMapping
    public Video videoById(@Argument Long id) {
        return videoRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Video  %s notfound",id)));
    }

}
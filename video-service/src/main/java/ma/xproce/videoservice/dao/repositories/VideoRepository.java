package ma.xproce.videoservice.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.xproce.videoservice.dao.entities.Video;

public interface VideoRepository extends JpaRepository<Video,Integer> {
}

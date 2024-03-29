package carsawesome.repository;

import carsawesome.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByTitle(String title);
}

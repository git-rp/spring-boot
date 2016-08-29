package bookmarks;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long>
    {
	List<Bookmark> findByAccountUsername(String username);
    }

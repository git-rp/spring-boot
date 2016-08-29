package bookmarks.resource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import bookmarks.AccountController;
import bookmarks.Bookmark;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


public class BookmarkResource extends ResourceSupport
    {
	private final Bookmark bookmark;

	    public BookmarkResource(Bookmark bookmark) {
	        String username = bookmark.getAccount().getUsername();
	        this.bookmark = bookmark;
	        this.add(new Link(bookmark.getUri(), "bookmark-uri"));
	        this.add(linkTo(AccountController.class, username).withRel("bookmarks"));
	        this.add(linkTo(methodOn(AccountController.class, username).readBookmark(username, bookmark.getId())).withSelfRel());
	    }

	    public Bookmark getBookmark() {
	        return bookmark;
	    }
    }

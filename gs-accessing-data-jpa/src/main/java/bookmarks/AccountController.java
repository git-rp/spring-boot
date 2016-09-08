package bookmarks;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookmarks.exception.UserNotFoundException;
import bookmarks.hello.HelloWorld;
import bookmarks.resource.BookmarkResource;

@RestController
public class AccountController
    {
	private static final Logger log = LoggerFactory.getLogger(AccountController.class);
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	BookmarkRepository bookmarkRepository;
	@Autowired 
	HelloWorld helloWorld;

	@RequestMapping("/accounts")
	Account addAccount() {
	    Account account = new Account("bhuvi", "pass1");

	    accountRepository.save(account);
	    Bookmark bookmark = new Bookmark(account, "http://bookmark.com/1/", "desc1");
	    Bookmark bookmark1 = new Bookmark(account, "http://bookmark.com/2/", "desc2");
	    bookmarkRepository.save(bookmark);
	    bookmarkRepository.save(bookmark1);
	    helloWorld.printHelloWorld("This is demo.....");
	    return account;
	}

/*	@RequestMapping(path = "/{userId}/bookmarks", method = RequestMethod.POST)
	public ResponseEntity<?> addBookMark(@PathVariable String userId, @RequestBody Bookmark input) {
	    validateUser(userId);
	    List<Account> accountLst = accountRepository.findByUsername(userId);
	    HttpHeaders  httpHeaders=null;
	    if(accountLst !=null && accountLst.size()>0)
		{
		    Bookmark result = bookmarkRepository.save(new Bookmark(accountLst.get(0), input.getUri(),input.getDescription()));
		    httpHeaders = new HttpHeaders();
		    httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri());
		   
		}
	    return new ResponseEntity<Void>(httpHeaders,HttpStatus.CREATED);
	}
	*/
	
	@RequestMapping(method = RequestMethod.GET,path="/{userId}/bookmarks")	
	public  Resources<BookmarkResource> readBookmarks(@PathVariable String userId) {
		this.validateUser(userId);
		List<Bookmark> bookmarkLst = bookmarkRepository.findByAccountUsername(userId);
		List<BookmarkResource> bookmarkResources = new ArrayList<>(bookmarkLst.size());
		for(Bookmark bm : bookmarkLst)
		    {
			BookmarkResource bookmarkResource = new BookmarkResource(bm);
			bookmarkResources.add(bookmarkResource);
		    }
		
		return new Resources<>(bookmarkResources);
	}
	
	
	 @RequestMapping(value = "/{userId}/bookmarks/{bookmarkId}", method = RequestMethod.GET)
	    public BookmarkResource readBookmark(@PathVariable String userId, @PathVariable Long bookmarkId) {
	        this.validateUser(userId);
	        return new BookmarkResource(this.bookmarkRepository.findOne(bookmarkId));
	    }

	 
	

	private void validateUser(String userId) {
	    List<Account> lstAcc=accountRepository.findByUsername(userId);
	    log.info(" test "+lstAcc);
	    if (lstAcc.isEmpty())
		{
		    throw new UserNotFoundException(userId);
		}

	}
    }

package bookmarks.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookmarks.student.Student;

@RestController
@RequestMapping("/student")
public class StudentService
{
    public static final Logger log = LoggerFactory.getLogger(StudentService.class);
    @RequestMapping(value="/studentJson",method=RequestMethod.GET,produces="application/json")
    public Student getStudentJson()
    {
	Student st = new Student();
	st.setName("bhuvi");
	st.setAge("10");
	return st;
    }
    
    @RequestMapping(value="/studentXml",method=RequestMethod.GET,produces="application/xml")
    public Student getStudentXml()
    {
	Student st = new Student();
	st.setName("bhuvi");
	st.setAge("10");
	return st;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public Student getStudent()
    {
	Student st = new Student();
	st.setName("bhuvi");
	st.setAge("10");
	return st;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public void postStudent(@RequestBody Student student)
    {
	log.info("post Student :: student name :: "+student.getName());
    }

}

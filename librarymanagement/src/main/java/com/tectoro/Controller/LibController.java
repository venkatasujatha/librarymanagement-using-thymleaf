package com.tectoro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tectoro.model.Books;
import com.tectoro.model.Student;
import com.tectoro.repository.bookRepository;
import com.tectoro.service.serviceImpl;


@Controller
public class LibController {
	@Autowired
	serviceImpl serviceImpl;
	
	@Autowired
	bookRepository bookRepository;
	
	@GetMapping("/login")
	public String home()
	{
		return "login";
	}
	@GetMapping("/welcome")
	public String welcome(ModelMap model,@RequestParam String uname,@RequestParam String psw)
	{
	
		/*
		 * System.out.println(uname); List<Student> students=serviceImpl.get();
		 * if(students!=null) { for(int i=0;i<=students.size()-1;i++) {
		 * if((students.get(i).getEmail()==uname)&&(students.get(i).getPassword()==psw))
		 * { System.out.println("Login success!!"); model.put("uname", uname);
		 * System.out.println(uname); System.out.println(psw); return "welcome"; } else
		 * { System.out.println("invalid password!!"); model.put("error msg",
		 * "please enter the correct username and password"); } return "login"; } }
		 * return "";
		 */
		if(serviceImpl.login(uname, psw)) {
			model.put("uname", uname);
			return "welcome";
		}
		else {
			return "login";
		}
	}
			
	@PostMapping("/save")
	public String save(@ModelAttribute("student") Student student)
	{
		ModelAndView mav=new ModelAndView("student");
		
		System.out.println(student);
		 serviceImpl.save(student);
		 mav.addObject("list",serviceImpl.get());
		 return "redirect:/login";
	}
	
	@GetMapping("/register")
	public String userRegister(Model model) {
		
		Student student=new Student();
		model.addAttribute("student",student);
		
		return "studentDetails";
	}
	@PostMapping("/save1")
	public String saveBook(@ModelAttribute("books") Books books)
	{
		ModelAndView mav=new ModelAndView("books");
		
		System.out.println(books);
		 serviceImpl.save(books);
		 mav.addObject("list1",serviceImpl.get());
		 return "redirect:/login";
	}
	@GetMapping("/bookdetails")
	public String bookdetails(Model model)
	{
		Books book=new Books();
		model.addAttribute("books", book);
		return "bookdetails";
	}
	@RequestMapping("/books")
	public ModelAndView getBook(Model model)
	{
		System.out.println("su---------------------------------------");
		ModelAndView mv=new ModelAndView("bookdetails1");
		List<Books> findAll = bookRepository.findAll();
		Books book1=new Books();
		mv.addObject("books", findAll);
		return mv;
		
	}
	
	
	
	/*
	 * @RequestMapping(value ="/save",method = RequestMethod.POST) public String
	 * studentDetails(@RequestParam int rollno,@RequestParam String
	 * firstname,@RequestParam String lastname,@RequestParam String department) {
	 * System.out.println(rollno); System.out.println(firstname);
	 * System.out.println(lastname); return "login"; }
	 */
	 
}

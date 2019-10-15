package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.spring5.expression.Mvc;

import com.demo.spring.entity.Emp;

@Controller
public class EmpFormController {

	@Autowired
	private EmpRepository repo;

	@RequestMapping(path = "/regform", method = RequestMethod.GET)
	public String getTheForm(Model model) {
		Emp e = new Emp();
		model.addAttribute("emp", e);
		return "regform";
	}

	@RequestMapping(path = "/regform", method = RequestMethod.POST)
	public ModelAndView processForm(@ModelAttribute("emp") Emp emp) {
		ModelAndView mv = new ModelAndView();
		Emp e1 = repo.save(emp);
		mv.addObject("savedEmp", e1);
		mv.setViewName("success");
		return mv;
	}

	@RequestMapping(path = "/find", method = RequestMethod.POST)
	public ModelAndView processForm(@RequestParam("empId") int id) {
		System.out.println(":::::::::: " + id);
		ModelAndView mv = new ModelAndView();
		Optional<Emp> o = repo.findById(id);
		if (o.isPresent()) {
			mv.addObject("emp", o.get());
			mv.setViewName("success");
			return mv;
		} else {
			mv.setViewName("not_found");

			return mv;
		}

	}

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView();
		List<Emp> emps = repo.findAll();
		mv.setViewName("emp_list");
		mv.addObject("empList", emps);
		return mv;
	}

}

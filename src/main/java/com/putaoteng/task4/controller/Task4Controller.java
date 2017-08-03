package com.putaoteng.task4.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.putaoteng.task4.dao.ExcellentStudentDao;
import com.putaoteng.task4.dao.ProfessionDao;
import com.putaoteng.task4.model.BasicVo;
import com.putaoteng.task4.model.Profession;

@Controller
public class Task4Controller {

	@Resource(name = "excellentStudentDao")
	private ExcellentStudentDao excellentStudentDao;
	@Resource(name = "professionDao")
	private ProfessionDao professionDao;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String start() {
		return "index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage(Model model) {
		List<BasicVo> list = new ArrayList<BasicVo>();
		list = excellentStudentDao.findAll();

		model.addAttribute("excellentStudentList", list);

		return "home";
	}

	@RequestMapping(value = "/profession", method = RequestMethod.GET)
	public String professionPage(Model model) {
		List<BasicVo> list = new ArrayList<BasicVo>();
		list = professionDao.findAll();

		model.addAttribute("professionList", list);
		model.addAttribute("listLength", list.size());

		return "profession";
	}
	
	@RequestMapping(value = "/front", method = RequestMethod.GET)
	public String frontPage(Model model) {
		List<BasicVo> list = new ArrayList<BasicVo>();
		list = professionDao.findAll();
		
		Profession profession = null;
		Iterator<BasicVo> iterator = list.iterator();
        while(iterator.hasNext()){
            profession = (Profession) iterator.next();
            if (!("CSS".equals(profession.getProfession()) || "js".equals(profession.getProfession())))
            	iterator.remove();
        }
		
		model.addAttribute("professionList", list);
		model.addAttribute("listLength", list.size());
		
		return "front";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String tagTest(Model model) {
		Profession profession = (Profession) professionDao.findByPK(32L);
		long nowTime = System.currentTimeMillis();
		
		model.addAttribute("profession", profession);
		model.addAttribute("nowTime", nowTime);
		
		return "test";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloTest(Model model) {
		
		
		return "hello";
	}
}

package com.dotridge.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dotridge.bean.LaboratiesBean;
import com.dotridge.domain.Laboraties;
import com.dotridge.service.LaboratiesService;

@Controller
@RequestMapping("/labMgmnt")
public class LaboratiesController {

	@Autowired
	private LaboratiesService labService;

	@RequestMapping(value = "/getAllLaboraties")
	public String viewAllLaboraties(Model model) {
		try {
			List<LaboratiesBean> uiListLaboraties = labService.getAllLaboraties();
			model.addAttribute("uiListLaboraties", uiListLaboraties);
			return "getLaboratiesBoard";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping("/getLabRegForm")
	public String getLabRegForm(Model model) {

		LaboratiesBean labBean = new LaboratiesBean();
		model.addAttribute("labBean", labBean);
		return "getLabFormDef";

	}

	@RequestMapping(value = "/addLaboraties", method = RequestMethod.POST)

	public String addLaboraties(@ModelAttribute("labBean") LaboratiesBean labBean, Model model) {
		LaboratiesBean createBeanLab = labService.createLaboraties(labBean);

		if (createBeanLab.getLabId() > 0) {
			List<LaboratiesBean> uiListLaboraties = labService.getAllLaboraties();

			model.addAttribute("uiListLaboraties", uiListLaboraties);
			return "getLaboratiesBoard";

		} else {
			System.out.println("Failed to add");
		}
		return "getLaboratiesBoard";
	}

	@RequestMapping("/editLaboraties")
	public String editLaboraties(HttpServletRequest request, Model model) {
		String labId = request.getParameter("labId");
		LaboratiesBean uiListLaboraties = labService.getLaboratiesById(Integer.valueOf(labId));
		model.addAttribute("labBean", uiListLaboraties);
		return "editLaboratiesDef";
	}

	@RequestMapping(value = "/updateLaboraties", method = RequestMethod.POST)
	public String updateLaboraties(@ModelAttribute("labBean") LaboratiesBean labBean, Model model) {

		LaboratiesBean updateLaboraties = labService.updateLaboraties(labBean);
		if (updateLaboraties.getLabId() > 0) {
			List<LaboratiesBean> uiListLaboraties = labService.getAllLaboraties();
			model.addAttribute("uiListLaboraties", uiListLaboraties);
			return "getLaboratiesBoard";
		} else {
			System.out.println("failed to update");
		}
		return "getLaboratiesBoard";

	}

	@RequestMapping(value = "/deleteLaboraties")
	public String deleteLaboraties(HttpServletRequest request, Model model) {

		String labId = request.getParameter("labId");
		boolean deleteLaboraties = labService.deleteLaboraties(Integer.valueOf(labId));

		model.addAttribute("labBean", deleteLaboraties);
		if (deleteLaboraties) {
			List<LaboratiesBean> uiListLaboraties = labService.getAllLaboraties();
			model.addAttribute("uiListLaboraties", uiListLaboraties);
			return "getLaboratiesBoard";

		}

		return null;

	}

	@RequestMapping("/searchLaboraties")
	public String searchLaboraties(HttpServletRequest request, Model model) {

		String SearchKey = request.getParameter("searchKey");
		String SearchValue = request.getParameter("SearchValue");

		if ((SearchKey != null && !SearchKey.isEmpty()) && (SearchValue != null && !SearchValue.isEmpty())) {
			if (SearchKey.equalsIgnoreCase("firstName")) {
				List<LaboratiesBean> byName = labService.getLaboratiesByName(SearchValue);
				model.addAttribute("uiListLaboraties", byName);
				return "getLaboratiesBoard";
			}

			else if (SearchKey.equalsIgnoreCase("email")) {
				List<LaboratiesBean> byEmail = labService.getLaboratiesByEmail(SearchValue);
				model.addAttribute("uiListLaboraties", byEmail);
				return "getLaboratiesBoard";

			} else if (SearchKey.equalsIgnoreCase("phone")) {
				List<LaboratiesBean> byPhone = labService.getLaboratiesByPhone(Integer.valueOf(SearchValue));
				model.addAttribute("uiListLaboraties", byPhone);
				return "getLaboratiesBoard";
			} 
			else {
				System.out.println("Failed to Search");
			}
		}
		return null;

	}

}

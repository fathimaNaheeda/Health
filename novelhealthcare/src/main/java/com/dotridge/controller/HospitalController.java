package com.dotridge.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dotridge.bean.HospitalBean;
import com.dotridge.service.HospitalService;
import com.dotridge.util.ServiceConstraints;

@Controller
@RequestMapping("/hospitalMgmt")
public class HospitalController {
	@Autowired
	private HospitalService hospService;

	@RequestMapping(value = "/getAllHospitals")
	public String viewAllHospitals(Model model) {
		try {
			List<HospitalBean> uiHospitalList = hospService.getAllHospitals();

			int listSize = uiHospitalList.size();
			int pageBarSize = Math.round(listSize / ServiceConstraints.NUM_REC_PER_PAGE + 1);

			List pageBarList = new ArrayList(listSize);
			System.out.println(pageBarList.size());

			for (int i = 0; i < pageBarSize; i++) {
				pageBarList.add(i);
			}
			model.addAttribute("pageBarList", pageBarList);

			model.addAttribute("uiHospitalList", uiHospitalList);
			System.out.println(uiHospitalList.size());
			return "getHospitalBoard";

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;

	}

	@RequestMapping("/getHospitalRegForm")
	public String getHospitalRegForm(Model model) {

		HospitalBean hospitalBean = new HospitalBean();
		model.addAttribute("hospitalBean", hospitalBean);

		return "addHospitalFormDef";

	}

	@RequestMapping(value = "/addHospital", method = RequestMethod.POST)
	public String addHospital(@ModelAttribute("hospitalBean") HospitalBean hospitalBean, Model model) {

		System.out.println("hospital details " + hospitalBean);
		HospitalBean createHospital = hospService.createHospital(hospitalBean);
		if (createHospital.getHospitalId() > 0) {
			List<HospitalBean> uiHospitalList = hospService.getAllHospitals();
			model.addAttribute("uiHospitalList", uiHospitalList);
			return "getHospitalBoard";
		} else {
			System.out.println("Hospital failed to add");
		}
		return "getHospitalBoard";

	}

	@RequestMapping("/editHospital")
	public String editHospital(HttpServletRequest request, Model model) {
		String hospId = request.getParameter("hospId");
		HospitalBean hospitalBean = hospService.getHospitalById(Integer.valueOf(hospId));
		model.addAttribute("hospBean", hospitalBean);
		return "editHospitalDef";

	}

	@RequestMapping("/updateHospital")
	public String updateHospital(@ModelAttribute("hospBean") HospitalBean hospitalBean, Model model) {
		HospitalBean updateHospital = hospService.updateHospital(hospitalBean);
		if (updateHospital.getHospitalId() > 0) {
			List<HospitalBean> uiHospitalList = hospService.getAllHospitals();
			model.addAttribute("uiHospitalList", uiHospitalList);
			return "getHospitalBoard";
		} else {
			System.out.println("Hospital failed to add");
		}
		return "getHospitalBoard";

	}

	@RequestMapping("/deleteHospital")
	public String deleteHospital(HttpServletRequest request, Model model) {
		String hospId = request.getParameter("hospId");
		Boolean hospitalBol = hospService.deleteHospital(Integer.valueOf(hospId));
		model.addAttribute("hospBean", hospitalBol);
		if (hospitalBol) {
			List<HospitalBean> uiHospitalList = hospService.getAllHospitals();
			model.addAttribute("uiHospitalList", uiHospitalList);
			return "getHospitalBoard";
		}
		return null;
	}

	@RequestMapping("/searchHospitals")
	public String searchHospitals(HttpServletRequest request, Model model) {

		String SearchKey = request.getParameter("searchKey");
		String SearchValue = request.getParameter("searchValue");
		System.out.println(SearchKey);
		System.out.println(SearchValue);
		if (SearchKey != null && !SearchKey.isEmpty() && (SearchValue != null && !SearchValue.isEmpty())) {
			if (SearchKey.equalsIgnoreCase("hospitalName")) {
				List<HospitalBean> uiHospitalList = hospService.getHospitalByName(SearchValue);
				model.addAttribute("uiHospitalList", uiHospitalList);
			}
			return "getHospitalBoard";
		} else {
			System.out.println("no data found");
		}
		return null;
	}

	@RequestMapping(value = "/getAllHospitalsPaging")
	public String getAllHospitalsByPaging(HttpServletRequest request, Model model) {

		String CurrentPage = request.getParameter("currentPage");
		int Cpage = Integer.valueOf(CurrentPage);
		int NumOfRcrdsPerPage = ServiceConstraints.NUM_REC_PER_PAGE;
		List<HospitalBean> byPagianation = hospService.getAllHospitalsByPagination(Cpage, NumOfRcrdsPerPage);
		model.addAttribute("uiHospitalList", byPagianation);

		List<HospitalBean> uiHospitalList = hospService.getAllHospitals();

		int listSize = uiHospitalList.size();
		int pageBarSize = Math.round(listSize / ServiceConstraints.NUM_REC_PER_PAGE + 1);

		List pageBarList = new ArrayList(listSize);
		System.out.println(pageBarList.size());

		for (int i = 0; i < pageBarSize; i++) {
			pageBarList.add(i);
		}
		model.addAttribute("pageBarList", pageBarList);

		return "getHospitalBoard";
	}
}

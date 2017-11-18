package com.dotridge.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dotridge.bean.AdminBean;
import com.dotridge.bean.HospitalBean;
import com.dotridge.service.AdminService;
import com.dotridge.service.HospitalService;
import com.dotridge.util.ServiceConstraints;

@Controller
@RequestMapping("/adminMgmt")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private HospitalService hospService;

	@RequestMapping(value = "/getAllAdmins")
	public String viewAllAdmins(Model model) {
		try {
			List<AdminBean> uiadminList = adminService.getAllAdmins();
			// System.out.println(uiadminList);

			model.addAttribute("uiAdminList", uiadminList);
			// System.out.println(uiadminList.size());
			return "getAdminBoard";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/getAdminRegForm")
	public String getAdminRegForm(Model model) {
		AdminBean adminBean = new AdminBean();
		List<HospitalBean> allHospitals = hospService.getAllHospitals();
		Set<String> allHospitalsSet = new HashSet<String>();
		for (HospitalBean hospBean : allHospitals) {
			allHospitalsSet.add(hospBean.getHospitalName());
		}
		model.addAttribute("allHospitalsSet", allHospitalsSet);
		model.addAttribute("adminBean", adminBean);
		return "getAdminRegFormDef";

	}

	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public String addAdmin(@ModelAttribute("adminbean") AdminBean adminBean, Model model) {

		System.out.println("admin details" + adminBean.toString());

		AdminBean createAdmin = adminService.createAdmin(adminBean);
		if (createAdmin.getAdminId() > 0) {
			List<AdminBean> allAdmins = adminService.getAllAdmins();
			model.addAttribute("uiAdminList", allAdmins);
			return "getAdminBoard";
		} else
			System.out.println("failed to add");

		return "getAdminBoard";

	}

	@RequestMapping("/editAdmin")
	public String editAdmin(HttpServletRequest request, Model model) {
		String adminId = request.getParameter("adminId");
		AdminBean adminBean = adminService.getAdminById(Integer.valueOf(adminId));

		model.addAttribute("adminBean", adminBean);

		List<HospitalBean> hospitals = hospService.getAllHospitals();

		List<String> hospitalsList = new ArrayList<String>();
		for (HospitalBean hospBean : hospitals) {
			hospitalsList.add(hospBean.getHospitalName());
		}
		model.addAttribute("hospitalsList", hospitalsList);

		return "getEditFormDef";

	}

	@RequestMapping(value = "/udpateAdmin", method = RequestMethod.POST)
	public String updateAdmin(@ModelAttribute("adminbean") AdminBean adminBean, Model model) {

		AdminBean updateAdmin = adminService.updateAdmin(adminBean);
		if (updateAdmin.getAdminId() > 0) {
			List<AdminBean> admins = adminService.getAllAdmins();
			model.addAttribute("uiAdminList", admins);

			return "getAdminBoard";
		} else
			System.out.println("failed to update");
		return "getAdminBoard";

	}

	@RequestMapping("/deleteAdmiin")
	public String deleteAdmin(HttpServletRequest request, Model model) {

		String adminId = request.getParameter("adminId");
		boolean deleteAdmin = adminService.deleteAdmin(Integer.valueOf(adminId));
		model.addAttribute("adminBean", deleteAdmin);

		if (deleteAdmin) {
			List<AdminBean> allAdmins = adminService.getAllAdmins();
			model.addAttribute("uiAdminList", allAdmins);
			return "getAdminBoard";
		}

		return null;

	}

	@RequestMapping("/searchAdmins")
	public String searchAdmin(HttpServletRequest request, Model model) {

		String SearchKey = request.getParameter("searchKey");
		String SearchValue = request.getParameter("searchValue");
		if ((SearchKey != null && !SearchKey.isEmpty()) && SearchValue != null && !SearchValue.isEmpty()) {
			if (SearchKey.equalsIgnoreCase("firstName")) {
				List<AdminBean> byName = adminService.getAdminByName(SearchValue);
				model.addAttribute("uiAdminList", byName);
				return "getAdminBoard";

			} else if (SearchKey.equalsIgnoreCase("email")) {
				List<AdminBean> adminByEmail = adminService.getAdminByEmail(SearchValue);
				model.addAttribute("uiAdminList", adminByEmail);
				return "getAdminBoard";

			}else if (SearchKey.equalsIgnoreCase("phone")) {
				List<AdminBean> adminByPhone= adminService.getAdminByPhone(Integer.valueOf(SearchValue));
				model.addAttribute("uiAdminList", adminByPhone);
				return "getAdminBoard";
				}

			else {
				System.out.println("no data found");

			}

		}
		return null;
	}
}

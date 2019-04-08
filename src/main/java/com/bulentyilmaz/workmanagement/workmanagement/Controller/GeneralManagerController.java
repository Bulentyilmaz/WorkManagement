package com.bulentyilmaz.workmanagement.workmanagement.Controller;

import com.bulentyilmaz.workmanagement.workmanagement.Model.DepartmanManager;
import com.bulentyilmaz.workmanagement.workmanagement.Model.Employees;
import com.bulentyilmaz.workmanagement.workmanagement.Model.GeneralManager;
import com.bulentyilmaz.workmanagement.workmanagement.Repository.DepartmanManagerRepository;
import com.bulentyilmaz.workmanagement.workmanagement.Repository.EmployeesRepository;
import com.bulentyilmaz.workmanagement.workmanagement.Repository.GeneralManagerRepository;
import com.bulentyilmaz.workmanagement.workmanagement.Repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("manager")
@Controller
public class GeneralManagerController {

    private String loginError = "Epostanız veya şifreniz hatalı";

    private String errorMessage;

    private String errorMessageGeneral;

    private DepartmanManagerRepository departmanManagerRepository;
    private GeneralManagerRepository generalManagerRepository;
    private EmployeesRepository employeesRepository;
    private TasksRepository tasksRepository;

    @Autowired
    public GeneralManagerController(DepartmanManagerRepository departmanManagerRepository, GeneralManagerRepository generalManagerRepository, EmployeesRepository employeesRepository, TasksRepository tasksRepository) {
        this.departmanManagerRepository = departmanManagerRepository;
        this.generalManagerRepository = generalManagerRepository;
        this.employeesRepository = employeesRepository;
        this.tasksRepository = tasksRepository;
    }




    @RequestMapping(value = "/")
    public String GMlogin() {
        return "generalManagerLogin";
    }




    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("generalmanager") GeneralManager generalManager, Model model, HttpSession session) {
        System.out.println(generalManager.getEmail() + generalManager.getPassword());
        GeneralManager sessionGeneral = generalManagerRepository.findByEmailAndPassword(generalManager.getEmail(), generalManager.getPassword());
        if (sessionGeneral == null) {
            System.out.println("YOK!");
            model.addAttribute("loginError", loginError);
            session.removeAttribute("generalmanager");
            session.removeAttribute("departmanmanager");
            return "generalManagerLogin";
        }

        session.removeAttribute("departmanmanager");
        session.setAttribute("generalmanager", sessionGeneral);

        return "redirect:/manager/panel";


    }


    @RequestMapping("/panel")
    public String getPanel(Model model, HttpSession session)
    {
        GeneralManager generalManager = (GeneralManager) session.getAttribute("generalmanager");
        if(generalManager == null)
            return "generalManagerLogin";

        System.out.println(generalManager.getName());
        System.out.println(generalManager.getEmail());
        List<DepartmanManager> departmanManagerList = departmanManagerRepository.findAll();
        model.addAttribute("departmanmanagers", departmanManagerList);
        return "gmanager";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(Model model,HttpSession session)
    {
        session.removeAttribute("generalManager");
        return "home";
    }
    @RequestMapping(value ="/gmanager")
    public String getPanel(){

        return "redirect:/manager/panel";
    }




    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String getCreate(Model model, HttpSession session)
    {
        GeneralManager generalManager = (GeneralManager) session.getAttribute("generalmanager");
        if(generalManager == null)
            return "redirect:/manager/panel";

        DepartmanManager departmanForm = new DepartmanManager();
        GeneralManager generalForm = new GeneralManager();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        model.addAttribute("today",format.format(today));
        model.addAttribute("departmanmanagerform", departmanForm);
        model.addAttribute("generalmanagerform", generalForm);
        return "adddepartman";
    }













    @RequestMapping(value = {"/create/departmanmanager"}, method = RequestMethod.POST)
    public String agencyCreate(Model model, @ModelAttribute("departmanForm") DepartmanManager departmanManager,HttpSession session) {
        GeneralManager generalManager= (GeneralManager) session.getAttribute("generalmanager");
        if(generalManager == null)
            return "generalManagerLogin";

        String name = departmanManager.getName();
        String email = departmanManager.getEmail();
        String password = departmanManager.getPassword();
        String birthday = departmanManager.getBirthday();
        String departman = departmanManager.getDepartman();
        int age = departmanManager.getAge();

        if(departmanManagerRepository.findByName(name)!= null || departmanManagerRepository.findByEmail(email)!= null) {

            errorMessage = "Bu departman Yöneticisi mevcut";

            model.addAttribute("errorMessage", errorMessage);
            DepartmanManager departmanManagerform = new DepartmanManager();
            GeneralManager generalManagerform = new GeneralManager();
            model.addAttribute("departmanManagerform", departmanManagerform);
            model.addAttribute("generalManagerform", generalManagerform);
            return "adddepartman";
        }
        departmanManagerRepository.save(departmanManager);
        return "redirect:/manager/panel";
    }










    @RequestMapping(value = {"/create/generalmanager"}, method = RequestMethod.POST)
    public String adminCreate(Model model, @ModelAttribute("generalmanagerform") GeneralManager generalmanagerform,HttpSession session)
    {
        GeneralManager generalManager = (GeneralManager) session.getAttribute("generalmanager");
        if(generalManager == null)
            return "generalManagerLogin";

        String name = generalmanagerform.getName();
        String email = generalmanagerform.getEmail();
        String password = generalmanagerform.getPassword();
        String birthday= generalManager.getBirthday();
        int age = generalManager.getAge();

        if(generalManagerRepository.findByEmail(email)!= null || generalManagerRepository.findByName(name)!= null)
        {
            errorMessageGeneral = "Bu Yönetici mevcut";
            model.addAttribute("errorMessageGeneral", errorMessageGeneral);
            DepartmanManager departmanManagerForm = new DepartmanManager();
            GeneralManager generalManagerForm = new GeneralManager();
            model.addAttribute("departmanform", departmanManagerForm);
            model.addAttribute("generalManagerform", generalManagerForm);
            return "adddepartman";
        }
        generalManagerRepository.save(generalmanagerform);
        return "redirect:/manager/panel";
    }





    @RequestMapping(value = {"/employees"}, method= RequestMethod.GET)
    public String getCostumers(Model model,HttpSession session)
    {
        GeneralManager generalManager = (GeneralManager) session.getAttribute("generalmanager");
        if(generalManager == null)
            return "generalManagerLogin";

        List<Employees> employees = employeesRepository.findAll();
        model.addAttribute("employees",employees);
        return "gmanageremployees";
    }







}
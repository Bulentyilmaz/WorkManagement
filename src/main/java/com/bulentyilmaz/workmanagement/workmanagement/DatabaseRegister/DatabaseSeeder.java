package com.bulentyilmaz.workmanagement.workmanagement.DatabaseRegister;


import com.bulentyilmaz.workmanagement.workmanagement.Model.DepartmanManager;
import com.bulentyilmaz.workmanagement.workmanagement.Model.Employees;
import com.bulentyilmaz.workmanagement.workmanagement.Model.GeneralManager;
import com.bulentyilmaz.workmanagement.workmanagement.Model.Tasks;
import com.bulentyilmaz.workmanagement.workmanagement.Repository.DepartmanManagerRepository;
import com.bulentyilmaz.workmanagement.workmanagement.Repository.EmployeesRepository;
import com.bulentyilmaz.workmanagement.workmanagement.Repository.GeneralManagerRepository;
import com.bulentyilmaz.workmanagement.workmanagement.Repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private DepartmanManagerRepository departmanManagerRepository;
    private GeneralManagerRepository generalManagerRepository;
    private EmployeesRepository employeesRepository;
    private  TasksRepository tasksRepository;

    @Autowired
    public DatabaseSeeder(DepartmanManagerRepository departmanManagerRepository, GeneralManagerRepository generalManagerRepository, EmployeesRepository employeesRepository,TasksRepository tasksRepository) {
        this.departmanManagerRepository = departmanManagerRepository;
        this.generalManagerRepository = generalManagerRepository;
        this.employeesRepository = employeesRepository;
        this.tasksRepository=tasksRepository;

    }



    @Override
    public void run(String... args) throws Exception {


        GeneralManager generalManager = new GeneralManager("Bulent","blnt.ylmz025@gmail.com","admin","03.03.1996",22);
        generalManagerRepository.save(generalManager);

        ArrayList<Tasks> tasks = new ArrayList<Tasks>();

        ArrayList<DepartmanManager> departmanManagers = new ArrayList<DepartmanManager>();


        DepartmanManager Finance = new DepartmanManager("Miray","mirayerten@gmail.com","mryrtn","03.03.1997",21,"Finans");
        Employees financeEmp1= new Employees("ali","ali@gmail.com","ali","05.06.1995",23,"Finance");
        Employees financeEmp2= new Employees("ahmet","ahmet@gmail.com","ahmet","05.06.1991",27,"Finance");
        Tasks financetasks1= new Tasks("Finance","07.08.2018","Bütce raporu");
        Tasks financetasks2= new Tasks("Finance","07.08.2018","Bütce yıllık genel bilgi");

        tasks.add(financetasks1);
        tasks.add(financetasks2);

        List empFinance= new ArrayList<>();
        empFinance.add(financeEmp1);
        empFinance.add(financeEmp2);
        Finance.setEmployees(empFinance);
        departmanManagers.add(Finance);

        DepartmanManager Marketing = new DepartmanManager("Berk","berk.taspinar@hotmail.com","brktspnr","08.07.1995",23,"Pazarlama");
        Employees markettingEmp1=new Employees("Cuma","cuma@hotmail.com","persembe","01.02.1990",28,"Marketting");
        Employees markettingEmp2=new Employees("Hatice","hatice@hotmail.com","hatice","09.05.1990",28,"Marketting");
        Tasks markettingtask= new Tasks("Marketting","07.08.2018","PazarlamaBilgileri");

        tasks.add(markettingtask);

        List employMarket= new ArrayList();

        employMarket.add(markettingEmp1);
        employMarket.add(markettingEmp2);
        Marketing.setEmployees(employMarket);
        departmanManagers.add(Marketing);


        DepartmanManager HumanSources= new DepartmanManager("Erdost","erdostgunduz@gmail.com","akdeniz","06.07.1994",24,"İnsan Kaynakları");
        Employees humansourcesEmp1=new Employees("Murat","murat131@gmail.com","sahin","02.10.2000",18,"HumanSources");
        Employees humansourcesEmp2=new Employees("Fatih","fatih@gmail.com","fatih","02.10.1996",22,"HumanSources");
        Tasks humansourcestask= new Tasks("Human Sources","05.08.2018","Alinin işe alım bilgileri");

       tasks.add(humansourcestask);

        List empHumanSource = new ArrayList();
        empHumanSource.add(humansourcesEmp1);
        empHumanSource.add(humansourcesEmp2);
        HumanSources.setEmployees(empHumanSource);
        departmanManagers.add(HumanSources);


        DepartmanManager Law = new DepartmanManager("Mete","mete@gmail.com","baron","01.06.1985",33,"Hukuk");
        Employees lawEmp1=new Employees("Nuran","nuran@gmail.com","nuran","02.10.2000",18,"LAw");
        Employees lawEmp2=new Employees("Recep","recep@gmail.com","recep","02.10.1996",22,"Law");
        Tasks Lawtask= new Tasks("Law","04.05.2018","Cezalı kullanıcılar");

        tasks.add(Lawtask);


        List empLaw= new ArrayList();
        empLaw.add(lawEmp1);
        empLaw.add(lawEmp2);
        Law.setEmployees(empLaw);

        departmanManagers.add(Law);



        DepartmanManager Operation =new DepartmanManager("Bugra","bugra@gmail.com","papyon","05.04.1989",29,"Operasyon");
        Employees OperationEmp1=new Employees("Cemile","cemile@gmail.com","Cemile","05.11.1990",28,"Operation");
        Employees OperationEmp2=new Employees("Halil","halil@gmail.com","Halil","03.04.1992",26,"Operation");
        Tasks operationsTask = new Tasks("Operation ","07.06.2017","Müsteri Geri Donus raporu");

        tasks.add(operationsTask);


        List empOperation= new ArrayList();
        empOperation.add(OperationEmp1);
        empOperation.add(OperationEmp2);
        Operation.setEmployees(empOperation);
        departmanManagers.add(Operation);



        DepartmanManager CustomerService = new DepartmanManager("Hakan","hakanakgul@gmail.com","akgul","03.03.1991",27,"Müşteri Hizm.") ;
        Employees CustomerServiceEmp1=new Employees("Ece","ece@gmail.com","ece","05.11.1990",28,"CustomerService");
        Employees CustomerServiceEmp2=new Employees("Arda","arda@gmail.com","arda","03.04.1992",26,"CustomerService");
        Tasks customertask= new Tasks("CustomerService","07.06.2018","Müsteri Kayıtlari");

       tasks.add(customertask);

        List empCustomerService = new ArrayList();
        empCustomerService.add(CustomerServiceEmp1);
        empCustomerService.add(CustomerServiceEmp2);
        CustomerService.setEmployees(empCustomerService);
        departmanManagers.add(CustomerService);


        DepartmanManager InformationTech = new DepartmanManager("Hilal","hilalaksu@gmail.com","aksu","09.08.1998",20,"Bilgi Tekn.");

        Employees InformationTechEmp1=new Employees("Özgür","ozgur@gmail.com","ozgur","05.11.1980",38,"InformationTech");
        Employees InformationTechEmp2=new Employees("Kagan","kagan@gmail.com","kagan","03.04.1982",36,"InformationTech");

        Tasks ittask=new Tasks("IT","06.05.2018","Son müşteri dataları");

        tasks.add(ittask);

        List empIt=new ArrayList();
        empIt.add(InformationTechEmp1);
        empIt.add(InformationTechEmp2);
        InformationTech.setEmployees(empIt);


        departmanManagers.add(InformationTech);
        tasksRepository.saveAll(tasks);
        departmanManagerRepository.saveAll(departmanManagers);




    }
}

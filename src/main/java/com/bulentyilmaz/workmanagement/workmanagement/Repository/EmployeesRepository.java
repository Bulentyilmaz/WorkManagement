package com.bulentyilmaz.workmanagement.workmanagement.Repository;


import com.bulentyilmaz.workmanagement.workmanagement.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Long> {


    Employees findByEmailAndPassword(String email,String  password);

    Employees findByName(String name);

    Employees findByEmail(String email);

    Employees findByPassword(String  password);

    Employees findByAge(int age);

    Employees findByDepartman(String departman);

   Employees findByBirthday(Date birthday);


}


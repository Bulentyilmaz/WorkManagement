package com.bulentyilmaz.workmanagement.workmanagement.Repository;

import com.bulentyilmaz.workmanagement.workmanagement.Model.DepartmanManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DepartmanManagerRepository extends JpaRepository<DepartmanManager,Long>{

    DepartmanManager findByEmailAndPassword(String email,String password);

    DepartmanManager findByEmail(String email);

    DepartmanManager findByPassword(String  password);

    DepartmanManager findByBirthday(Date birthday);

    DepartmanManager findByAge(int age);

    DepartmanManager findByName(String name);

    DepartmanManager findByDepartman(String  departman);



}

package com.bulentyilmaz.workmanagement.workmanagement.Repository;


import com.bulentyilmaz.workmanagement.workmanagement.Model.GeneralManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface GeneralManagerRepository extends JpaRepository<GeneralManager,Long> {

    GeneralManager findByEmailAndPassword(String email,String  password);

    GeneralManager findByEmail(String email);

    GeneralManager findByName(String name);

    GeneralManager findByBirthday(Date birthday);

    GeneralManager findByAge(int age);

    GeneralManager findByPassword(String  password);
}

package com.bulentyilmaz.workmanagement.workmanagement.Repository;


import com.bulentyilmaz.workmanagement.workmanagement.Model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TasksRepository extends JpaRepository<Tasks,Long> {



    Tasks findByType(String type);

    Tasks findByWorkStartDate(String workStartDate);

    Tasks findByWorkFinishDate(String workfinishdate);

    Tasks findByWorkInfo(String workInfo);


}




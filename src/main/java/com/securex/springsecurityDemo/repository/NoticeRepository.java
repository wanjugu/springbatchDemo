package com.securex.springsecurityDemo.repository;

import com.securex.springsecurityDemo.entities.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
//    @Query(value = "FROM Notice n WHERE GETDATE() BETWEEN n.noticBegDt AND n.noticEndDt")
//    List<Notice> findAllActiveNotices();

    @Query(value = "FROM Notice")
    List<Notice> findAllActiveNotices();



}

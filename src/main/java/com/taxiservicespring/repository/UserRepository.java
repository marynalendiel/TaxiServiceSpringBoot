package com.taxiservicespring.repository;

import com.taxiservicespring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.login = ?1")
    User findByLogin(String login);

    @Modifying
    @Query("update User u set u.discount = :discount where u.id = :id")
    void updateDiscount(@Param(value = "id") int id, @Param(value = "discount") int discount);
}
package com.resultsDeclaration.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.resultsDeclaration.Entities.EpollUsers;

public interface UsersRepository extends JpaRepository<EpollUsers, Integer> {

    EpollUsers findByEmail(String email);

}
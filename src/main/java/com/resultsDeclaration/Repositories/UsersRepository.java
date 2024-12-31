package com.resultsDeclaration.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.resultsDeclaration.Entities.EpollUser;

public interface UsersRepository extends JpaRepository<EpollUser, Integer> {

    EpollUser findByEmail(String email);

}
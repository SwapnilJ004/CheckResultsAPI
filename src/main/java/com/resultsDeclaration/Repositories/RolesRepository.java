package com.resultsDeclaration.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.resultsDeclaration.Entities.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
    
}
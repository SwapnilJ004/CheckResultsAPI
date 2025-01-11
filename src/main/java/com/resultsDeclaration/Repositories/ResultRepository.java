package com.resultsDeclaration.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resultsDeclaration.Entities.Result;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
    List<Result> findByElectionId(int electionId);
}
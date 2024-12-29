package com.resultsDeclaration.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resultsDeclaration.Entities.Result;
import com.resultsDeclaration.Repositories.ResultRepository;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public List<Result> getResultsByElectionId(int votingId) {
        return resultRepository.findByElectionId(votingId);
    }
}
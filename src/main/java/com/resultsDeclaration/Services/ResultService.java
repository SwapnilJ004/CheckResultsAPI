package com.resultsDeclaration.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.resultsDeclaration.Entities.Result;
import com.resultsDeclaration.Exceptions.NoSuchElectionIdExistsException;
import com.resultsDeclaration.Repositories.ResultRepository;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public List<Result> getResultsByElectionId(int electionId) {
        List<Result> results = resultRepository.findByElectionId(electionId);
    
        if (results == null || results.isEmpty()) {
            throw new NoSuchElectionIdExistsException("No election exists for Id: " + electionId);
        }
        
        System.out.println("Reached here");
        return results;
    }   
}
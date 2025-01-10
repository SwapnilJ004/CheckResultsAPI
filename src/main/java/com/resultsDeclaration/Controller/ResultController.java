package com.resultsDeclaration.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.resultsDeclaration.Entities.Result;
import com.resultsDeclaration.Exceptions.NoSuchElectionIdExistsException;
import com.resultsDeclaration.Services.ResultService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ResultController {
    @Autowired
    private ResultService resultService;

   @GetMapping("/results/{electionId}")
    public ResponseEntity<?> getResultsByElectionId(@PathVariable int electionId) {
        try {
            System.out.println("Controller control");
            List<Result> results = resultService.getResultsByElectionId(electionId);
            return ResponseEntity.ok(results);
        } catch (NoSuchElectionIdExistsException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}

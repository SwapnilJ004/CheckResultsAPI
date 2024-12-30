package com.resultsDeclaration.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.resultsDeclaration.Entities.Result;
import com.resultsDeclaration.Services.ResultService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @GetMapping("/results/{electionId}")
    public ResponseEntity<List<Result>> getResultsByElectionId(@PathVariable int electionId) {
        List<Result> results = resultService.getResultsByElectionId(electionId);
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(results);
    }
}

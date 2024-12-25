package Controller;
import Entities.Result;
import Services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @GetMapping("/results/{votingId}")
    public ResponseEntity<List<Result>> getResultsByVotingId(@PathVariable int votingId) {
    	System.out.println("Reached here");
        List<Result> results = resultService.getResultsByVotingId(votingId);
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(results);
    }
}

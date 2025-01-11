package com.resultsDeclaration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resultsDeclaration.Entities.Election;
import com.resultsDeclaration.Responses.ElectionResponse;
import com.resultsDeclaration.Responses.PositionResponse;
import com.resultsDeclaration.Responses.ResultResponse;
import com.resultsDeclaration.Services.ElectionService;
import com.resultsDeclaration.Services.PositionService;
import com.resultsDeclaration.Services.ResultService;

@RestController
@RequestMapping("/results")
public class ResultsController {

    @Autowired
    private ElectionService electionService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private ResultService resultService;

    @GetMapping("/{election_id}")
    public ResponseEntity<ElectionResponse> getResultsByElection(@PathVariable("election_id") Integer electionId) {
        Election election = electionService.getElectionById(electionId);
        if (election == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        ElectionResponse electionResponse = new ElectionResponse();
        electionResponse.setElectionId(election.getElectionId());
        electionResponse.setElectionTitle(election.getElectionTitle());
        electionResponse.setCreatedAt(election.getCreatedAt());

        List<PositionResponse> positionResponses = positionService.getPositionsByElectionId(electionId)
                .stream()
                .map(position -> {
                    PositionResponse positionResponse = new PositionResponse();
                    positionResponse.setPositionId(position.getPositionId());
                    positionResponse.setPositionName(position.getPositionName());

                    List<ResultResponse> results = resultService.getResultsByPositionId(position.getPositionId())
                            .stream()
                            .map(result -> {
                                ResultResponse resultResponse = new ResultResponse();
                                resultResponse.setWinnerId(result.getWinner().getUserId());
                                resultResponse.setWinnerName(result.getWinner().getUsername());
                                resultResponse.setVoteCount(result.getVoteCount());
                                return resultResponse;
                            }).toList();

                    positionResponse.setResults(results);
                    return positionResponse;
                }).toList();

        electionResponse.setPositions(positionResponses);

        return ResponseEntity.ok(electionResponse);
    }
}

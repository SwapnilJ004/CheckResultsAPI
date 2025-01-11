package com.resultsDeclaration.Responses;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

public class ElectionResponse {
    private int electionId;

    private String electionTitle;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private List<PositionResponse> positions;

    public void setElectionId(int electionId) {
        this.electionId = electionId;
    }

    public void setElectionTitle(String electionTitle) {
        this.electionTitle = electionTitle;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getElectionTitle(){
        return electionTitle;
    }
    
    public int getElectionId(){
        return electionId;
    }
    
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setPositions(List<PositionResponse> positions) {
        this.positions = positions;
    }

    public List<PositionResponse> getPositions() {
        return positions;
    }
}


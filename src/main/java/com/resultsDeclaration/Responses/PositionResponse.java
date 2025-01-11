package com.resultsDeclaration.Responses;

import java.util.List;

public class PositionResponse {
    private int positionId;
    private String positionName;
    private List<ResultResponse> results;

    public int getPositionId() {
        return positionId;
    }
    
    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }
    
    public String getPositionName() {
        return positionName;
    }
    
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
    
    public void setResults(List<ResultResponse> results) {
        this.results = results;
    }

    public List<ResultResponse> getResults() {
        return results;
    }

    // Getters and setters
}

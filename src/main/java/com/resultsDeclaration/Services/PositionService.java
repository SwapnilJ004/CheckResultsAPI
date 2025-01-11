package com.resultsDeclaration.Services;

import java.util.List;

import com.resultsDeclaration.Entities.Position;

public interface PositionService {
    List<Position> getPositionsByElectionId(int electionId);
}

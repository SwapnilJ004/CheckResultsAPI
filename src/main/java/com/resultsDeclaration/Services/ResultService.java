package com.resultsDeclaration.Services;

import java.util.List;

import com.resultsDeclaration.Entities.Result;

public interface ResultService {
    List<Result> getResultsByPositionId(int positionId);
}

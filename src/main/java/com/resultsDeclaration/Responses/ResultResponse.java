package com.resultsDeclaration.Responses;

import com.resultsDeclaration.Entities.EpollUser;

public class ResultResponse {
    private EpollUser winner;
    private String winnerName;
    private int vote_count;

    public EpollUser getWinner() {
        return winner;
    }
    
    public void setWinner(EpollUser winner) {
        this.winner = winner;
    }
    
    public void setWinnerId(int winnerId) {
        this.winner.setUserId(winnerId);
    }
    
    public String getWinnerName() {
        return winnerName;
    }
    
    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }
    
    public int getVoteCount() {
        return vote_count;
    }
    
    public void setVoteCount(int voteCount) {
        this.vote_count = voteCount;
    }    
    
    // Getters and setters
}

package com.resultsDeclaration.Entities;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private int resultId;

    @Column(name = "election_id")
    private int electionId;

    @Column(name = "winner_id")
    private int winnerId;

    @Column(name = "votes_count")
    private int voteCount;

    @Column(name = "percentage")
    private int percentage;

    @Column(name = "result_created_at", updatable = false)
    private LocalDateTime resultCreatedAt;

    @Column(name = "result_updated_at")
    private LocalDateTime resultUpdatedAt;

    // Getters and Setters
    public int getResultId() { return resultId; }
    public void setResultId(int resultId) { this.resultId = resultId; }

    public int getElectionId() { return electionId; }
    public void setVotingId(int electionId) { this.electionId = electionId; }

    public int getWinnerId() { return winnerId; }
    public void setCandidateId(int winnerId) { this.winnerId = winnerId; }

    public int getVoteCount() { return voteCount; }
    public void setVoteCount(int voteCount) { this.voteCount = voteCount; }

    public int getPercentage() { return percentage; }
    public void setPercentage(int percentage) { this.percentage = percentage; }

    public LocalDateTime getResultCreatedAt() { return resultCreatedAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.resultCreatedAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return resultUpdatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.resultUpdatedAt = updatedAt; }
}
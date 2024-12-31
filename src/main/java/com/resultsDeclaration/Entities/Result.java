package com.resultsDeclaration.Entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private int resultId;

    @OneToOne
    @JoinColumn(name = "election_id", referencedColumnName = "election_id", nullable = false)
    private Election election;

    @ManyToOne
    @JoinColumn(name = "winner_id", referencedColumnName = "user_id", nullable = false)
    private EpollUser winner;

    @Column(name = "votes_count")
    private int voteCount;

    @Column(name = "percentage")
    private int percentage;

    @Column(name = "result_created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime resultCreatedAt;

    @Column(name = "result_updated_at")
    @UpdateTimestamp
    private LocalDateTime resultUpdatedAt;

    // Getters and Setters
    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public EpollUser getWinner() {
        return winner;
    }

    public void setWinner(EpollUser winner) {
        this.winner = winner;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public LocalDateTime getResultCreatedAt() {
        return resultCreatedAt;
    }

    public void setResultCreatedAt(LocalDateTime resultCreatedAt) {
        this.resultCreatedAt = resultCreatedAt;
    }

    public LocalDateTime getResultUpdatedAt() {
        return resultUpdatedAt;
    }

    public void setResultUpdatedAt(LocalDateTime resultUpdatedAt) {
        this.resultUpdatedAt = resultUpdatedAt;
    }
}

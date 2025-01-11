package com.resultsDeclaration.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "positions")
public class Position {

    @Id
    private int positionId;

    @Column(nullable = false)
    private String positionName;

    @ManyToOne
    @JoinColumn(name = "election_id", nullable = false)
    private Election election;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Result> results;

    // Constructors
    public Position() {
    }

    public Position(int positionId, String positionName, Election election) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.election = election;
    }

    // Getters and Setters
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

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    // toString for debugging
    @Override
    public String toString() {
        return "Position{" +
                "positionId='" + positionId + '\'' +
                ", positionName='" + positionName + '\'' +
                ", election=" + (election != null ? election.getElectionId() : "null") +
                '}';
    }
}

package com.ladder.model;

import com.ladder.exception.NotMatchSizeException;

public class Result {

    private final Players players;
    private final Rewards rewards;

    private Result(Players players, Rewards rewards) {
        this.players = players;
        this.rewards = rewards;
    }

    public static Result of(Players players, Rewards rewards) {
        int countOfPlayers = players.countOfPlayers();
        int countOfRewards = rewards.countOfRewards();
        if (countOfPlayers != countOfRewards) {
            throw new NotMatchSizeException(players.countOfPlayers(), rewards.countOfRewards());
        }

        return new Result(players, rewards);
    }

    Reward findByReward(Position position) {
        return rewards.findByPosition(position);
    }

    Player findByPlayer(Position position) {
        return players.findByPosition(position);
    }

    int countOfPlayers() {
        return players.countOfPlayers();
    }

    public Players getPlayers() {
        return players;
    }
}
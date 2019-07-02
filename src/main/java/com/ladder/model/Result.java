package com.ladder.model;

public class Result {

    private final Players players;
    private final Rewards rewards;

    private Result(Players players, Rewards rewards) {
        this.players = players;
        this.rewards = rewards;
    }

    public static Result of(Players players, Rewards rewards) {
        if(players.countOfPlayers() != rewards.countOfRewards()){
            throw new IllegalArgumentException("플레이어와 보상의 개수는 일치해야합니다. (플레이어 개수: %d, 보상의 개수: %d)");
        }
        return new Result(players, rewards);
    }

    Reward findByReward(Position position) {
        return rewards.findByPosition(position);
    }

    Player findByPlayer(int position) {
        return players.findByPosition(position);
    }

    int countOfPlayers() {
        return players.countOfPlayers();
    }

    public Players getPlayers() {
        return players;
    }
}
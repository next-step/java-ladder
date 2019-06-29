package com.ladder.model;

import com.ladder.exception.PlayersLessMinimumException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Players {

    public static final int MIN_NUMBER_OF_PLAYERS = 2;
    private static final String SEPARATOR_OF_NAMES = ",";

    private List<Player> players;

    private Players(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public static Players of(String inputOfNames) {
        String[] names = inputOfNames.split(SEPARATOR_OF_NAMES);
        if (names.length < MIN_NUMBER_OF_PLAYERS) {
            throw new PlayersLessMinimumException();
        }
        return Arrays.stream(names)
                .map(Player::of)
                .collect(collectingAndThen(toList(), Players::new));
    }

    public int countOfPlayers() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}

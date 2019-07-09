package com.jaeyeonling.ladder.domain;

import com.jaeyeonling.ladder.domain.ladder.LadderReword;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class GameResult {

    static final String FINISH_CHARACTER = "all";

    private final Map<String, LadderReword> rewordOfUsername;

    private GameResult(final Map<String, LadderReword> rewordOfUsername) {
        this.rewordOfUsername = new HashMap<>(rewordOfUsername);
    }

    public static GameResult of(final Map<String, LadderReword> rewordOfUsername) {
        return new GameResult(rewordOfUsername);
    }

    public boolean isShowAll(final String usernameOfWantReword) {
        return FINISH_CHARACTER.equalsIgnoreCase(usernameOfWantReword);
    }

    public LadderReword findMatchingReword(final String usernameOfMatchReword) {
        return rewordOfUsername.get(usernameOfMatchReword);
    }

    public Stream<Map.Entry<String, LadderReword>> stream() {
        return rewordOfUsername.entrySet()
                .stream();
    }
}

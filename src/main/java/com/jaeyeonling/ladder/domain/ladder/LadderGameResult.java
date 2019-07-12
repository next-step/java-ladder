package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.reword.LadderReword;
import com.jaeyeonling.ladder.domain.user.Username;
import com.jaeyeonling.ladder.exception.NotFoundUserException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class LadderGameResult {

    static final String FINISH_CHARACTER = "all";

    private final Map<Username, LadderReword> rewordOfUsername;

    private LadderGameResult(final Map<Username, LadderReword> rewordOfUsername) {
        this.rewordOfUsername = new HashMap<>(rewordOfUsername);
    }

    static LadderGameResult of(final Map<Username, LadderReword> rewordOfUsername) {
        return new LadderGameResult(rewordOfUsername);
    }

    public boolean isShowAll(final String usernameOfWantReword) {
        return FINISH_CHARACTER.equalsIgnoreCase(usernameOfWantReword);
    }

    public LadderReword findRewordBy(final Username username) {
        return Optional.ofNullable(rewordOfUsername.get(username))
                .orElseThrow(() -> new NotFoundUserException(username));
    }

    public Stream<Map.Entry<Username, LadderReword>> stream() {
        return rewordOfUsername.entrySet()
                .stream();
    }
}
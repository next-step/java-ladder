package com.jaeyeonling.ladder2.domain.ladder;

import com.jaeyeonling.ladder2.domain.reword.LadderReword;
import com.jaeyeonling.ladder2.domain.user.Username;
import com.jaeyeonling.ladder2.exception.NotFoundUserException;
import com.jaeyeonling.ladder2.view.StringVisualizable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LadderGameResult implements StringVisualizable {

    private static final String MATCHING_RESULT_FORMAT = "%s : %s";
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

    public String visualize(final Username username) {
        final LadderReword ladderReword = Optional.ofNullable(rewordOfUsername.get(username))
                .orElseThrow(() -> new NotFoundUserException(username));

        return format(username, ladderReword);
    }

    @Override
    public String visualize() {
        return rewordOfUsername.entrySet()
                .stream()
                .map(this::visualize)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String visualize(final Map.Entry<Username, LadderReword> entry) {
        return format(entry.getKey(), entry.getValue());
    }

    private String format(final Username username,
                          final LadderReword ladderReword) {
        return String.format(MATCHING_RESULT_FORMAT, username.visualize(), ladderReword.visualize());
    }
}
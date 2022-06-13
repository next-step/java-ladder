package ladder.domain;

import nextstep.optional.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private List<User> users;
    private List<LadderLine> lines;
    private List<String> results;

    public LadderGame(List<User> gameContributors) {
        users = gameContributors;
    }
}

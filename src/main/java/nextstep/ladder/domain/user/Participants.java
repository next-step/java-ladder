package nextstep.ladder.domain.user;

import nextstep.ladder.domain.ladder.Ladder;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Participants {

    private static final String USER_NAME_DELIMITER = ",";
    private static final String OUTPUT_NAME_DELIMITER = " ";

    private final List<UserName> userNames;

    private Participants(List<UserName> userNames) {
        this.userNames = userNames;
    }

    public static Participants of(String input) {
        return new Participants(
                Arrays.stream(input.split(USER_NAME_DELIMITER))
                        .map(UserName::add)
                        .collect(Collectors.toUnmodifiableList()));
    }

    public int count() {
        return userNames.size();
    }

    public Map<UserName, Position> climb(Ladder ladder) {
        return userNames.stream()
                .collect(Collectors.toMap(
                        o -> o,
                        userName -> ladder.leafPosition(userPosition(userName)),
                        (x, y) -> x, LinkedHashMap::new));
    }

    private Position userPosition(UserName userName) {
        return new Position(userNames.indexOf(userName));
    }

    @Override
    public String toString() {
        return String.join(OUTPUT_NAME_DELIMITER, getFormattedUserNames());
    }

    private List<String> getFormattedUserNames() {
        return userNames.stream()
                .map(UserName::formattedName)
                .collect(Collectors.toUnmodifiableList());
    }
}

package nextstep.ladder.domain.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final String USER_NAME_DELIMITER = ",";

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

    public List<String> getUserNames() {
        return userNames.stream()
                .map(UserName::formattedName)
                .collect(Collectors.toUnmodifiableList());
    }

}

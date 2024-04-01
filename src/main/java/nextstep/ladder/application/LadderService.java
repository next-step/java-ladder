package nextstep.ladder.application;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LineGenerator;
import nextstep.ladder.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public class LadderService {
    private final LineGenerator lineGenerator;

    public LadderService(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public Ladder makeLadder(int height, int numberOfUser) {
        return new Ladder(height, numberOfUser-1, lineGenerator);
    }

    public List<User> makeUser(List<String> userNames) {
        assertNotDuplicateName(userNames);

        return userNames.stream().map(User::new).collect(Collectors.toUnmodifiableList());
    }

    private void assertNotDuplicateName(List<String> userNames) {
        String message = "[서비스] 중복된 유저 이름이 있습니다.";

        if (userNames.stream().distinct().count() != userNames.size()) {
            throw new IllegalArgumentException(message);
        }
    }
}

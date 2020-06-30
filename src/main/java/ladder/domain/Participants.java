package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<User> participants;

    private Participants(List<User> users) {
        participants = Collections.unmodifiableList(users);
    }

    public static Participants of(List<String> names) {
        List<User> users = names.stream().map(User::of).collect(Collectors.toList());
        return new Participants(users);
    }

    public int getStartPosition(User user) {
        int index = participants.indexOf(user);
        if (index == -1) {
            throw new IllegalArgumentException("입력하신 사용자는 사다리 게임 참가자가 아닙니다.");
        }
        return index;
    }

    public User get(int startPosition) {
        if (startPosition < 0 || startPosition > participants.size()) {
            throw new IllegalArgumentException("입력된 startPosition은 사디리 올바른 statPosition이 아닙니다.");
        }
        return participants.get(startPosition);
    }

    public List<User> getUserAll() {
        return participants;
    }

    public int size() {
        return participants.size();
    }
}

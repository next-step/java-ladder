package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Participants {

    private final List<User> participants;

    private Participants(List<User> users, Ladder ladder) {
        if(!ladder.equalStartPositionCount(users.size())) {
            throw new IllegalArgumentException("사용자의 수와 사다리의 StatPosition 수가 다릅니다.");
        }
        participants = Collections.unmodifiableList(users);
    }

    public static Participants of(List<User> users, Ladder ladder) {
        return new Participants(users, ladder);
    }

    public int getStartPosition(User user) {
        int startPosition = 0;
        for (User participant : participants) {
            if(participant.equals(user)) {
                return startPosition;
            }
            startPosition++;
        }
        throw new IllegalArgumentException("입력하신 사용자는 사다리 게임 참가자가 아닙니다.");
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

}

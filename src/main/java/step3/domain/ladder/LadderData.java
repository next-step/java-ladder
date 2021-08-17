package step3.domain.ladder;

import java.util.List;

public class LadderData {
    private final List<String> names;

    private final int height;

    private static final int MAX_NAME_LENGTH = 5;

    private static final int MIN_HEIGHT = 1;

    private static final int MIN_PARTICIPANTS = 1;

    private LadderData(List<String> names, int height) {
        this.names = names;
        this.height = height;
    }

    public static LadderData of(List<String> names, int height) {
        validateNames(names);
        validateHeight(height);
        return new LadderData(names, height);
    }

    private static void validateNames(List<String> names) {
        for (String name : names) {
            validateNamesLength(name);
        }

        if (lessThanMinParticipants(names.size())) {
            throw new RuntimeException("참여자는 최소 1명 이상이여야 합니다.");
        }
    }

    private static void validateNamesLength(String name) {
        if (moreThanMaxNameLength(name.length())) {
            throw new RuntimeException("이름의 글자는 최대 5자리를 넘을 수 없습니다.");
        }
    }

    private static boolean moreThanMaxNameLength(int size) {
        return size > MAX_NAME_LENGTH;
    }

    private static boolean lessThanMinParticipants(int size) {
        return size < MIN_PARTICIPANTS;
    }

    private static void validateHeight(int height) {
        if (heightIsNotAvailable(height)) {
            throw new RuntimeException("사다리의 높이는 양수여야 합니다.");
        }
    }

    private static boolean heightIsNotAvailable(int height) {
        return height < MIN_HEIGHT;
    }

    public Ladder createLadder() {
        return Ladder.create(names, height);
    }
}

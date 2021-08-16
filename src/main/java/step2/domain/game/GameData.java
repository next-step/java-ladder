package step2.domain.game;

import step2.domain.ladder.Ladder;

import java.util.List;

public class GameData {
    private final List<String> names;

    private final int height;

    private static final int MAX_PARTICIPANTS = 5;

    private GameData(List<String> names, int height) {
        this.names = names;
        this.height = height;
    }

    public static GameData of(List<String> names, int height) {
        validateNames(names);
        validateHeight(height);
        return new GameData(names, height);
    }

    private static void validateNames(List<String> names) {
        if (moreThanMaxParticipants(names.size())) {
            throw new RuntimeException("최대 참여자는 5명을 넘을 수 없습니다.");
        }

        if (lessThanMinParticipants(names.size())) {
            throw new RuntimeException("참여자는 최소 1명 이상이여야 합니다.");
        }
    }

    private static boolean moreThanMaxParticipants(int size) {
        return size > MAX_PARTICIPANTS;
    }

    private static boolean lessThanMinParticipants(int size) {
        return size <= 0;
    }

    private static void validateHeight(int height) {
        if (heightIsNotAvailable(height)) {
            throw new RuntimeException("사다리의 높이는 양수여야 합니다.");
        }
    }

    private static boolean heightIsNotAvailable(int height) {
        return height <= 0;
    }

    public Ladder createLadder() {
        return Ladder.create(names, height);
    }
}

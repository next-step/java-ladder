package laddergame.utils;

public class Validation {

    private static final int MIN_PERSON = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_DEPTH = 1;

    private Validation() {
    }

    public static void lengthOfDepth(final int depth) {
        if (depth < MIN_DEPTH){
            throw new IllegalArgumentException("사다리의 깊이는 1이상이어야 합니다.");
        }
    }

    public static void lengthOfName(final int length) {
        if (length > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자여야 합니다.");
        }
    }

    public static void countOfParticipants(final int countOfPeople) {
        if (countOfPeople <= MIN_PERSON) {
            throw new IllegalArgumentException("참여 인원은 두 명 이상이어야 합니다.");
        }
    }
}

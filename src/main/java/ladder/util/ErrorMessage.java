package ladder.util;

public class ErrorMessage {

    private static final String CHECK_INPUT_NAMES = "참여할 사람의 이름을 확인해주세요";
    private static final String CHECK_NAME_LENGTH = "이름의 길이는 5를 넘지 못합니다.";
    private static final String CHECK_INPUT_LADDER_HEIGHT = "최소 사다리 갯수는 1개입니다.";
    private static final String CHECK_COUNT_OF_PERSON = "최소 참가인원은 2명입니다.";
    private static final String CHECK_WINNNG_SIZE = "당첨결과 크기와 참여 명단의 크기가 같아야 합니다.";
    private static final String CHECK_INPUT_WINNING = "당첨 결결과 입력을 확인해주세요";
    private static final String CHECK_DIRECTION = "사다리 방향이 양쪽 다 true일 수가 없습니다.";
    private static final String CHECK_POINT_INDEX = "Point의 idnex은 음수가 될 수 없습니다.";
    private static final String CHECK_NULL_DIRECTION = "Point의 direction은 null일수가 없습니다.";
    private static final String CHECK_MOVE_NEGATIVE = "index가 0일때 왼쪽으로 이동하면 에러를 던진다.";

    private static final String CHECK_SEARCH_NAME = "결과를 보고 싶은 사람이 이름이 존재하지 않습니다.";

    private ErrorMessage() {
    }

    public static String getCheckInputNames() {
        return CHECK_INPUT_NAMES;
    }

    public static String getCheckNameLength() {
        return CHECK_NAME_LENGTH;
    }

    public static String getCheckInputLadderHeight() {
        return CHECK_INPUT_LADDER_HEIGHT;
    }

    public static String getCheckCountOfPerson() {
        return CHECK_COUNT_OF_PERSON;
    }


    public static String getCheckNullDirection() {
        return CHECK_NULL_DIRECTION;
    }

    public static String getCheckWinnngSize() {
        return CHECK_WINNNG_SIZE;
    }

    public static String getCheckInputWinning() {
        return CHECK_INPUT_WINNING;
    }

    public static String getCheckDirection() {
        return CHECK_DIRECTION;
    }

    public static String getCheckPointIndex() {
        return CHECK_POINT_INDEX;
    }

    public static String getCheckMoveNegative() {
        return CHECK_MOVE_NEGATIVE;
    }

    public static String getCheckSearchName() {
        return CHECK_SEARCH_NAME;
    }
}
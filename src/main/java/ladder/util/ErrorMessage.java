package ladder.util;

public class ErrorMessage {

    private static String CHECK_INPUT_NAMES = "참여할 사람의 이름을 확인해주세요";
    private static String CHECK_NAME_LENGTH = "이름의 길이는 5를 넘지 못합니다.";
    private static String CHECK_INPUT_LADDER_HEIGHT = "최소 사다리 갯수는 1개입니다.";

    private ErrorMessage(){
    }

    public static String getCheckNameLength() {
        return CHECK_NAME_LENGTH;
    }

    public static String getCheckInputNames() {
        return CHECK_INPUT_NAMES;
    }

    public static String getCheckInputLadderHeight() {
        return CHECK_INPUT_LADDER_HEIGHT;
    }
}

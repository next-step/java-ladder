package ladder.util;

public class ErrorMessage {

    private static final String CHECK_INPUT_NAMES = "참여할 사람의 이름을 확인해주세요";
    private static final String CHECK_NAME_LENGTH = "이름의 길이는 5를 넘지 못합니다.";
    private static final String CHECK_INPUT_LADDER_HEIGHT = "최소 사다리 갯수는 1개입니다.";
    private static final String CHECK_COUNT_OF_PERSON = "최소 참가인원은 2명입니다.";
    private static final String CHECK_PERSONS_INIT = "psersons 객체 초기화 시 list사이즈가 같아야 합니다.";
    private static final String CHECK_WINNNG_SIZE = "당첨결과 크기와 참여 명단의 크기가 같아야 합니다.";
    private static final String CHECK_INPUT_WINNING = "당첨 결결과 입력을 확인해주세요";

    private ErrorMessage(){
    }

    public static String getCheckCountOfPerson() {
        return CHECK_COUNT_OF_PERSON;
    }

    public static String getCheckNameLength() {
        return CHECK_NAME_LENGTH;
    }

    public static String getCheckInputNames() {
        return CHECK_INPUT_NAMES;
    }

    public static String getCheckPersonsInit() {
        return CHECK_PERSONS_INIT;
    }

    public static String getCheckWinnngSize() {
        return CHECK_WINNNG_SIZE;
    }

    public static String getCheckInputWinning() {
        return CHECK_INPUT_WINNING;
    }

    public static String getCheckInputLadderHeight() {
        return CHECK_INPUT_LADDER_HEIGHT;
    }
}

package nextstep.step3.resource;

public class LadderStringResource {
    public static final String BAR = "|";
    public static final String LINE = "-----";
    public static final String NO_LINE = "     ";

    public static final String LADDER_RESULT_TEXT = "사다리 결과";
    public static final String PLAY_RESULT_TEXT = "실행 결과";

    public static final String GET_USER_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String GET_LADDER_HEIGHT_MSG = "최대 사다리 높이는 몇 개인가요?";
    public static final String GET_PLAY_RESULT_MSG = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

    public static final String LADDER_HEIGHT_EXCEPTION_TEXT = "사다리의 높이는 1 이상이어야 합니다.";
    public static final String USER_NAME_EXCEPTION_TEXT = "참여할 사람의 이름은 최대 5자 입니다.";

    public static final String PLAY_RESULT_LENGTH_EXCEPTION = "실행결과의 갯수는 참여할 사람의 수와 같아야 합니다.";
    public static final String PLAY_RESULT_BLANK_EXCEPTION = "실행결과에 빈값은 없어야합니다.";
    public static final String GET_USER_NAME_FOR_RESULT = "결과를 보고 싶은 사람은?";
    public static final String USER_NAME_FOR_RESULT_EXCEPTION = "존재하지 않는 유저 이름입니다.";
}

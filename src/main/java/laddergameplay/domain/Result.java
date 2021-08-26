package laddergameplay.domain;

public class Result {
    public static final int MAX_LENGTH_OF_NAME = 5;
    public static final int ZERO_LENGTH_OF_NAME = 0;
    public static final String LENGTH_OF_NAME_EXCEPTION_MESSAGE = "참여자 이름 양식 오류. 최대 " + MAX_LENGTH_OF_NAME + "자";
    public static final String EMPTY_STRING_EXCEPTION_MESSAGE = "참여자 이름 양식 오류. 빈 값 미허용";

    private final String name;

    public Result(String name) {
        this.name = name;
    }

}

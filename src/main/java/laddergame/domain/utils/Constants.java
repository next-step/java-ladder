package laddergame.domain.utils;

public class Constants {

    // input
    public static String INPUT_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static String INPUT_MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static String PLAYER_NAME_SEPERATOR = ",";

    // result
    public static String RESULT = "실행결과";
    public static String LADDER_VERTICAL = "|";
    public static String LADDER_CONNECTION = "-----";
    public static String LADDER_BLANK_SPACE = "     ";
    public static String PLAYER_BLANK_SPACE = "   ";

    // numbers
    public static int LADDER_VERTICAL_COUNT(int playerCount) {
        return playerCount - 1;
    }

    public static int LAST_ELEMENT_INDEX(int size) {
        return size - 1;
    }

    public static int PLAYER_NAME_LENGTH_LIMIT = 5;
}

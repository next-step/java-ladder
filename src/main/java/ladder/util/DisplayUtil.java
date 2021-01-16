package ladder.util;

public class DisplayUtil {

    private final static String REQUIRE_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String REQURE_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private final static String EXECUTE_RESULT = "실행 결과";

    public static void requireNames() {
        print(REQUIRE_NAMES);
    }

    public static void requireLadderHeight() {
        print(REQURE_LADDER_HEIGHT);
    }

    public static void ladderResult() {
        print(EXECUTE_RESULT);
    }

    private static void print(String context){
        System.out.println(context);
    }
}

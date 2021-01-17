package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class DisplayUtil {

    private final static String REQUIRE_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String REQURE_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private final static String EXECUTE_RESULT = "실행 결과";
    private final static String EMPTY_POINT = "     ";
    private final static String EXIST_POINT = "-----";
    private final static int paddingSize = 5;

    public static void requireNames() {
        print(REQUIRE_NAMES);
    }

    public static void requireLadderHeight() {
        print(REQURE_LADDER_HEIGHT);
    }

    public static void ladderResult(Ladder ladder) {
        print(EXECUTE_RESULT);
        List<Name> names = ladder.participateNames();
        String collect = names.stream()
                .map((name) -> padLeft(name.getName(), paddingSize)).collect(Collectors.joining());
        print(collect);

        List<Line> lines = ladder.resultLadder();
        lines.stream()
                .map((line)->toStringLine(line,names.size()))
                .forEach(System.out::println);
    }
    private static String toStringLine(Line line, int size){
        String strLine = line.resultLine().stream()
                .map((point) -> {
                            if (point == true) {
                                return EMPTY_POINT;
                            }
                            return EXIST_POINT;
                        }
                ).collect(Collectors.joining("|"));
        return "|" + strLine + "|";
    }

    public static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }

    private static void print(String context){
        System.out.println(context);
    }
}

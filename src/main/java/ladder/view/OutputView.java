package ladder.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String PERSON_NAME_DELIMITER = " ";
    private static final int PERSON_NAME_LENGTH_MAX = 5;

    public static void inputPersonName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void resultGuide() {
        System.out.println("실행결과");
    }

    public static void outputPersonNames(List<String> names) {
        System.out.println(names.stream()
                .map(OutputView::outputPersonName)
                .collect(Collectors.joining(PERSON_NAME_DELIMITER)));
    }

    protected static String outputPersonName(String name) {
        if (name.length() < PERSON_NAME_LENGTH_MAX) {
            return String.format("%4s ", name);
        }
        return name;
    }

    public static void outputLadderLines(String ladderLines) {
        System.out.println(ladderLines);
    }
}

package ladder.view.output;

import java.util.List;
import java.util.stream.Collectors;

public class LadderCreateOutputView {

    public static final String PERSON_NAME_DELIMITER = " ";
    private static final int PERSON_NAME_LENGTH_MAX = 5;

    public static void inputPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void inputPeopleException() {
        System.out.println("사람 이름 입력이 잘못됐습니다 다시 이력해주세요.");
    }

    public static void inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }


    public static void inputLadderHeightException() {
        System.out.println("사다리 높이 입력이 잘못됐습니다 다시 입력해주세요.");
    }

    public static void result(List<String> persons, String ladderLine) {
        ladderResultGuide();
        outputPersonNames(persons);
        outputLadderLines(ladderLine);
    }

    public static void ladderResultGuide() {
        System.out.println("사다리 결과");
    }

    public static void outputPersonNames(List<String> names) {
        System.out.println(names.stream()
                .map(LadderCreateOutputView::outputPersonName)
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

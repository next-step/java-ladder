package ladder.view.output;

import java.util.List;
import java.util.stream.Collectors;

import static ladder.util.LadderConst.*;

public class LadderGameCreateOutputView {

    public static void inputPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(" + PERSON_NAME_SEPARATOR + ")로 구분하세요)");
    }

    public static void inputPeopleException() {
        System.out.println("사람 이름 입력이 잘못됐습니다 다시 이력해주세요.");
    }

    public static void inputPlayResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(" + INPUT_RESULT_SEPARATOR + ")로 구분하세요)");
    }

    public static void inputPlayResultException() {
        System.out.println("사다리 게임 실행 결과 입력이 잘못됐습니다 다시 입력해주세요.");
    }

    public static void inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }


    public static void inputLadderHeightException() {
        System.out.println("사다리 높이 입력이 잘못됐습니다 다시 입력해주세요.");
    }

    public static void result(List<String> persons, String ladderLine, List<String> results) {
        ladderResultGuide();
        outputPersonNames(persons);
        outputLadderLines(ladderLine);
        outputResults(results);
    }

    private static void outputResults(List<String> results) {
        System.out.println(results.stream()
                .map(LadderGameCreateOutputView::translateResultOutputFormat)
                .collect(Collectors.joining(RESULT_DELIMITER)));
    }

    private static String translateResultOutputFormat(String result) {
        return String.format("%-5s", result);
    }

    public static void ladderResultGuide() {
        System.out.println("사다리 결과");
    }

    public static void outputPersonNames(List<String> names) {
        System.out.println(names.stream()
                .map(LadderGameCreateOutputView::outputPersonName)
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

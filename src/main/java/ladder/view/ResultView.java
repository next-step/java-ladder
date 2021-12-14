package ladder.view;

import ladder.Ladder;
import ladder.Line;
import ladder.Point;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ladder.view.InputViewUtil.userInput;

public class ResultView {
    public static final String VERTICAL_LINE = "|     ";
    public static final String VERTICAL_LINE_WITH_FOOTHOLD = "|-----";
    public static final String NEW_LINE = "\n";
    private static final String END_CONDITION = "all";

    private final List<String> userList;
    private final List<String> resultList;
    private final Ladder ladder;

    public ResultView(List<String> userList, List<String> resultList, Ladder ladder) {
        this.userList = userList;
        this.resultList = resultList;
        this.ladder = ladder;
    }

    public void visualizeLadderGame() {
        List<String> result = new ArrayList<>();

        // Print User List
        result.add(userList.stream()
                .map(InputViewUtil::StringPadding)
                .collect(Collectors.joining()));

        // Print Ladder
        for (Line line : ladder.getLines()) {
            drawLine(result, line);
        }

        // Print Result
        result.add(resultList.stream()
                .map(InputViewUtil::StringPadding)
                .collect(Collectors.joining()));

        System.out.println(String.join(NEW_LINE, result));
    }

    private void drawLine(List<String> result, Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Point point : line.getPoints()) {
            drawPoint(stringBuilder, point);
        }
        result.add(stringBuilder.toString());
    }

    private void drawPoint(StringBuilder stringBuilder, Point point) {
        if (point.isCurr()) {
            stringBuilder.append(VERTICAL_LINE_WITH_FOOTHOLD);
            return;
        }

        stringBuilder.append(VERTICAL_LINE);
    }

    public void showResult() {
        Map<String, String> results = generateResults();

        while (true) {
            System.out.println("결과를 보고 싶은 사람은?");
            String target = userInput();

            System.out.println("실행 결과");

            if (target.equals(END_CONDITION)) {
                results.keySet().stream()
                        .map(key -> key + " : " + results.get(key))
                        .forEach(System.out::println);
                break;
            }

            if (results.containsKey(target)) {
                System.out.println(target + " : " + results.get(target));
                continue;
            }

            System.out.println("해당 사용자가 없습니다.");
        }
    }

    private Map<String, String> generateResults() {
        Map<String, String> results = new LinkedHashMap<>();

        for (int i = 0; i < userList.size(); i++) {
            String user = userList.get(i);
            String result = resultList.get(ladder.singleResult(i));
            results.put(user, result);
        }

        return results;
    }
}

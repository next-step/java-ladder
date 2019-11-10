package nextstep.ladder;

import nextstep.InputTool;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameView {

    private static final String NAME_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_GAME_RESULT = "실행결과";
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final String EMPTY = "";

    private final InputTool inputTool;

    public LadderGameView() {
        this.inputTool = new InputTool();
    }

    public List<String> getNames() {
        showText(NAME_QUESTION);

        String[] texts = splitBy(COMMA, inputTool.readLine());
        return Arrays
                .stream(texts)
                .collect(Collectors.toList());
    }

    public int getHeight() {
        showText(LADDER_HEIGHT);

        return inputTool.readLineToInt();
    }

    public void showResult(List<Participant> participants, List<Line> lines) {
        showText(LADDER_GAME_RESULT);
        showParticipants(participants);

        for (Line line : lines) {
            showText(line.toString());
        }
    }

    private void showParticipants(List<Participant> participants) {
        String participantsText = participants
                .stream()
                .map(Participant::getName)
                .reduce((name1, name2) -> name1 + " " + name2)
                .get();

        showText(participantsText);
    }

    private String[] splitBy(String regex, String text) {
        return removeBlank(text).split(regex);
    }

    private String removeBlank(String text) {
        return text.replace(BLANK, EMPTY);
    }

    public void showText(String text) {
        System.out.println(text);
    }
}

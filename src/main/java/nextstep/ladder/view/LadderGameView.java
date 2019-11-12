package nextstep.ladder.view;

import nextstep.InputTool;
import nextstep.ladder.domain.ImmutableList;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Point;

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

    private static final String INVALID_PARTICIPANT_ERROR_MSG = "입력된 참여자의 정보가 올바르지 않습니다.";

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

    public void showResult(ImmutableList<Participant> participants, ImmutableList<Line> lines) {
        showText(LADDER_GAME_RESULT);
        showParticipants(participants.get());

        for (Line line : lines.get()) {
            showLine(line);
        }
    }

    private void showLine(Line line) {
        StringBuilder sb = new StringBuilder();
        for (Point point : line.getPoints()) {
            sb.append(point.toString());
        }

        showText(sb.toString());
    }

    private void showParticipants(List<Participant> participants) {
        String participantsText = participants
                .stream()
                .map(Participant::getName)
                .reduce((name1, name2) -> name1 + " " + name2)
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PARTICIPANT_ERROR_MSG));

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

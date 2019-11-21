package nextstep.ladder.view;

import nextstep.InputTool;
import nextstep.ladder.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameView {

    private static final String NAME_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_QUESTION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_GAME_RESULT = "실행결과";
    private static final String PARTICIPANT_RESULT_QUESTION = "결과를 보고 싶은 사람은?";
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final String EMPTY = "";
    private static final String POINT_FORMAT = "|%s";
    private static final String POINT_LINE = "-----";
    private static final String POINT_EMPTY = "     ";
    private static final String GAME_RESULT_FORMAT = "%s : %s";
    private static final String GAME_RESULT_TITLE = "실행결과";

    private static final String INVALID_RESULT_ERROR_MSG = "입력된 결과 정보가 올바르지 않습니다.";
    private static final String INVALID_PARTICIPANT_ERROR_MSG = "입력된 참여자의 정보가 올바르지 않습니다.";

    private final InputTool inputTool;

    public LadderGameView() {
        this.inputTool = new InputTool();
    }

    public List<String> getNames() {
        return getTexts(NAME_QUESTION);
    }

    public int getHeight() {
        showText(LADDER_HEIGHT);

        return inputTool.readLineToInt();
    }

    public void showLines(Game ladderGame) {
        showText(LADDER_GAME_RESULT);
        showParticipants(ladderGame.getParticipants());

        for (Line line : ladderGame.getLines()) {
            showLine(line);
        }

        showInputResults(ladderGame.getLineResults());
    }

    private void showLine(Line line) {
        StringBuilder sb = new StringBuilder();
        for (Point point : line.getPoints()) {
            sb.append(getPointText(point));
        }

        showText(sb.toString());
    }

    private String getPointText(Point point) {
        return String.format(POINT_FORMAT, point.hasLine() ? POINT_LINE : POINT_EMPTY);
    }

    private void showParticipants(List<Participant> participants) {
        String participantsText = participants
                .stream()
                .map(Participant::getName)
                .reduce((name1, name2) -> name1 + " " + name2)
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PARTICIPANT_ERROR_MSG));

        showText(participantsText);
    }

    private void showInputResults(List<String> results) {
        String resultsText = results
                .stream()
                .reduce((result1, result2) -> result1 + " " + result2)
                .orElseThrow(() -> new IllegalArgumentException(INVALID_RESULT_ERROR_MSG));

        showText(resultsText);
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

    public List<String> getTexts(String question) {
        showText(question);

        String[] texts = splitBy(COMMA, inputTool.readLine());
        return Arrays
                .stream(texts)
                .collect(Collectors.toList());
    }

    public List<String> getLineResults() {
        return getTexts(RESULT_QUESTION);
    }

    public String getTargetParticipant() {
        showText(PARTICIPANT_RESULT_QUESTION);
        return inputTool.readLine();
    }

    public void showGameResults(GameResults gameResults) {
        showText(GAME_RESULT_TITLE);

        for (GameResult result : gameResults.getValue()) {
            showText(String.format(GAME_RESULT_FORMAT, result.getName(), result.getScore()));
        }
    }
}

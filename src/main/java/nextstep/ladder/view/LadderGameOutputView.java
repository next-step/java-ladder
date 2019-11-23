package nextstep.ladder.view;

import nextstep.ladder.domain.game.Game;
import nextstep.ladder.domain.game.GameResult;
import nextstep.ladder.domain.game.GameResults;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.participant.Participant;
import nextstep.ladder.domain.point.Point;

import java.util.List;

public class LadderGameOutputView {

    private static final String LADDER_GAME_RESULT = "실행결과";
    private static final String POINT_FORMAT = "|%s";
    private static final String POINT_LINE = "-----";
    private static final String POINT_EMPTY = "     ";
    private static final String GAME_RESULT_FORMAT = "%s : %s";
    private static final String GAME_RESULT_TITLE = "실행결과";

    private static final String INVALID_RESULT_ERROR_MSG = "입력된 결과 정보가 올바르지 않습니다.";
    private static final String INVALID_PARTICIPANT_ERROR_MSG = "입력된 참여자의 정보가 올바르지 않습니다.";

    private BaseView baseView = new BaseView();

    public void showLines(Game ladderGame) {
        baseView.showText(LADDER_GAME_RESULT);
        showParticipants(ladderGame.getParticipants());

        for (Line line : ladderGame.getLines()) {
            showLine(line);
        }

        showInputResults(ladderGame.getLadderResults());
    }

    private void showLine(Line line) {
        StringBuilder sb = new StringBuilder();
        for (Point point : line.getPoints()) {
            sb.append(getPointText(point));
        }

        baseView.showText(sb.toString());
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

        baseView.showText(participantsText);
    }

    private void showInputResults(List<String> results) {
        String resultsText = results
                .stream()
                .reduce((result1, result2) -> result1 + " " + result2)
                .orElseThrow(() -> new IllegalArgumentException(INVALID_RESULT_ERROR_MSG));

        baseView.showText(resultsText);
    }

    public void showGameResults(GameResults gameResults) {
        baseView.showText(GAME_RESULT_TITLE);

        for (GameResult result : gameResults.getValue()) {
            baseView.showText(String.format(GAME_RESULT_FORMAT, result.getName(), result.getScore()));
        }
    }

    public void showErrorText(Exception exception) {
        baseView.showText(exception.getMessage());
    }
}

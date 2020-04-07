package nextstep.ladder.view;

import nextstep.ladder.ViewUtils;
import nextstep.ladder.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String WHOS_RESULT = "결과를 보고 싶은 사람은?";
    private static final String LADDER_GAME_RESULT = "실행 결과";
    private static final String POINT_FORMAT = "|%s";
    private static final String POINT_LINE = "-----";
    private static final String POINT_EMPTY = "     ";
    private static final String LADDER_END = "|";
    private static final int SPACE_PER_POINT = 6;
    private static final String SPACE = " ";
    private static final String GAME_RESULT_FORMAT = "%s : %s";
    private ViewUtils viewUtils;

    public OutputView() {
        this.viewUtils = new ViewUtils();
    }

    public void showLadder(LadderGame ladderGame) {
        List<Participant> participants = ladderGame.getParticipants();
        Ladder ladder = ladderGame.getLadder();

        viewUtils.printLine(LADDER_RESULT);
        showPersons(participants);

        for(Line line : ladder.getValue()) {
            showLine(line);
        }

        showLadderResults(ladderGame.getLadderResults());
    }

    private void showLine(Line line) {
        StringBuilder builder = new StringBuilder();

        builder.append(POINT_EMPTY);
        for(Point point : line.getValue()) {
            builder.append(getPointText(point));
        }
        builder.append(LADDER_END);

        viewUtils.printLine(builder.toString());
    }

    private String getPointText(Point point) {
        return String.format(POINT_FORMAT, point.hasLine() ? POINT_LINE : POINT_EMPTY);
    }

    private void showPersons(List<Participant> participants) {
        StringBuilder builder = new StringBuilder();

        for(Participant participant : participants) {
            builder = appendLadderSources(participant.getName(), builder);
        }

        viewUtils.printLine(builder.toString());
    }

    private void showLadderResults(LadderResults ladderResults) {
        StringBuilder builder = new StringBuilder();

        for(String ladderResult : ladderResults.getValue()) {
            builder = appendLadderSources(ladderResult, builder);
        }

        viewUtils.printLine(builder.toString());
    }

    private StringBuilder appendLadderSources(String name, StringBuilder builder) {
        int length = name.length();
        int spaceCount = SPACE_PER_POINT - length;

        builder = appendSpaces(builder, spaceCount);
        builder.append(name);

        return builder;
    }

    private StringBuilder appendSpaces(StringBuilder builder, int spaceCount) {
        for(int i = 0; i < spaceCount; i++) {
            builder.append(SPACE);
        }
        return builder;
    }

    public void showGameResults(GameResults gameResults) {
        viewUtils.printLine(WHOS_RESULT);
        String inputText = viewUtils.readLine();
        List<String> participantNames = Arrays.asList(inputText.split(InputView.DELIMITER_COMMA));

        List<String> resultTexts = participantNames.stream()
                .map(name -> {return String.format(GAME_RESULT_FORMAT, name, gameResults.getResult(name));})
                .collect(Collectors.toList());

        resultTexts.forEach(text -> System.out.println(text));
    }
}

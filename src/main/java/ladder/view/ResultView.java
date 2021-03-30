package ladder.view;

import ladder.entity.game.Game;
import ladder.entity.game.GameResult;
import ladder.entity.ladderMap.LadderMap;
import ladder.entity.ladderMap.Line;
import ladder.entity.ladderMap.Link;
import ladder.entity.participant.Participant;
import ladder.entity.participant.ParticipantList;
import ladder.entity.resultCase.ResultCase;
import ladder.entity.resultCase.ResultCaseList;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static final char BLANK = ' ';
    private static final String VERTICAL_ADDED = "     |";
    private static final char HORIZONTAL = '-';

    private static final int DIVIDER = 6;
    private static final int VERTICAL_INDEX = 5;
    private static final int MINIMUM_LENGTH = 5;

    public void printGameMap(Game game) {
        System.out.println("사다리 결과");

        LadderMap ladderMap = game.ladderMap();
        String parsedNames = parsedNames(ladderMap.participantList());
        System.out.println(parsedNames);

        printLadderMap(ladderMap.lines());

        String parsedResults = parsedResults(game.resultList());
        System.out.println(parsedResults);
    }

    private String parsedResults(ResultCaseList resultCaseList) {
        StringBuilder parsedResults = new StringBuilder();
        for (ResultCase resultcase : resultCaseList.resultCases()) {
            parsedResults.append(parsedResult(resultcase));
        }
        return String.valueOf(parsedResults);
    }

    private String parsedResult(ResultCase result) {
        int resultLength = result.result().length();
        StringBuilder parsedResult = new StringBuilder();
        parsedResult.append(BLANK);
        for (int count = 0; count < MINIMUM_LENGTH - resultLength; count++) {
            parsedResult.append(BLANK);
        }
        parsedResult.append(result.result());
        return String.valueOf(parsedResult);
    }

    private void printLadderMap(List<Line> lines) {
        for (Line line : lines) {
            String verticalLineAdded = addVerticalLines(line);
            String horizontalLineAdded = addHorizontalLines(verticalLineAdded, line);
            System.out.println(horizontalLineAdded);
        }
    }

    private String addHorizontalLines(String verticalLineAdded, Line line) {
        StringBuilder horizontalLineAdded = new StringBuilder(verticalLineAdded);
        for (Link link : line.links()) {
            horizontalLineAdded = mightAddHorizontalLine(horizontalLineAdded, link);
        }
        return String.valueOf(horizontalLineAdded);
    }

    private StringBuilder mightAddHorizontalLine(StringBuilder toAddHorizontalLine, Link link){
        if(link.goesLeft()){
            return addHorizontalLine(toAddHorizontalLine, link);
        }
        return toAddHorizontalLine;
    }

    private StringBuilder addHorizontalLine(StringBuilder toAddHorizontalLine, Link link) {
        for (int count = 0; count < VERTICAL_INDEX; count++) {
            toAddHorizontalLine.setCharAt(link.from().index() * DIVIDER + count, HORIZONTAL);
        }
        return toAddHorizontalLine;
    }

    private String addVerticalLines(Line line) {
        StringBuilder verticalLineAdded = new StringBuilder();
        for (int count = 0; count < line.points().size(); count++) {
            verticalLineAdded.append(VERTICAL_ADDED);
        }
        return String.valueOf(verticalLineAdded);
    }

    private String parsedNames(ParticipantList participantList) {
        StringBuilder parsedNames = new StringBuilder();
        for (Participant participant : participantList.participants()) {
            parsedNames.append(parsedName(participant));
        }
        return String.valueOf(parsedNames);
    }

    private String parsedName(Participant participant) {
        int participantNameLength = participant.name().length();
        StringBuilder parsedName = new StringBuilder();
        parsedName.append(BLANK);
        if (participantNameLength == MINIMUM_LENGTH) {
            parsedName.append(participant.name());
            return String.valueOf(parsedName);
        }
        for (int count = 0; count < MINIMUM_LENGTH - participantNameLength; count++) {
            parsedName.append(BLANK);
        }
        parsedName.append(participant.name());
        return String.valueOf(parsedName);
    }

    public void printResult(ResultCase result) {
        System.out.println("실행 결과");
        System.out.println(result.result());
    }

    public void printAllResults(GameResult gameResult) {
        System.out.println("실행 결과");
        for (Map.Entry<Participant, ResultCase> entry : gameResult.result().entrySet()) {
            System.out.printf("%s : %s%n", entry.getKey().name(), entry.getValue().result());
        }
    }
}

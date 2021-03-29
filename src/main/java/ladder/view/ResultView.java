package ladder.view;

import ladder.domain.game.Game;
import ladder.domain.game.GameResult;
import ladder.domain.participant.Participant;
import ladder.domain.participant.ParticipantList;
import ladder.domain.ladderMap.Line;
import ladder.domain.ladderMap.Link;
import ladder.domain.ladderMap.Plane;
import ladder.domain.result.Result;
import ladder.domain.result.ResultList;

import java.util.Map;

public class ResultView {

    private static final String BLANK = " ";
    private static final String VERTICAL_ADDED = "     |";
    private static final char HORIZONTAL = '-';

    private static final int DIVIDER = 6;
    private static final int VERTICAL_INDEX = 5;

    public void printGameMap(Game game) {
        System.out.println("사다리 결과");

        String parsedNames = parsedNames(game.ladderMap().participantList());
        System.out.println(parsedNames);

        printPlane(game.ladderMap().plane());

        String parsedResults = parsedResults(game.resultList());
        System.out.println(parsedResults);
    }

    private String parsedResults(ResultList resultList) {
        StringBuilder parsedResults = new StringBuilder();
        for (Result result : resultList.resultList()) {
            parsedResults.append(parsedResult(result));
        }
        return String.valueOf(parsedResults);
    }

    private String parsedResult(Result result) {
        int resultLength = result.result().length();
        StringBuilder parsedResult = new StringBuilder();
        parsedResult.append(BLANK);
        for (int count = 0; count < Participant.MAX_LENGTH - resultLength; count++) {
            parsedResult.append(BLANK);
        }
        parsedResult.append(result.result());
        return String.valueOf(parsedResult);
    }

    private void printPlane(Plane plane) {
        for (Line line : plane.lines()) {
            String verticalLineAdded = addVerticalLines(line);
            String horizontalLineAdded = addHorizontalLines(verticalLineAdded, line);
            System.out.println(horizontalLineAdded);
        }
    }

    private String addHorizontalLines(String verticalLineAdded, Line line) {
        StringBuilder horizontalLineAdded = new StringBuilder(verticalLineAdded);
        for (Link link : line.links()) {
            horizontalLineAdded = addHorizontalLine(horizontalLineAdded, link);
        }
        return String.valueOf(horizontalLineAdded);
    }

    private StringBuilder addHorizontalLine(StringBuilder toAddHorizontalLine, Link link) {
        for (int count = 0; count < VERTICAL_INDEX; count++) {
            toAddHorizontalLine.setCharAt(DIVIDER + link.from() * DIVIDER + count, HORIZONTAL);
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
        if (participantNameLength == Participant.MAX_LENGTH) {
            parsedName.append(participant.name());
            return String.valueOf(parsedName);
        }
        for (int count = 0; count < Participant.MAX_LENGTH - participantNameLength; count++) {
            parsedName.append(BLANK);
        }
        parsedName.append(participant.name());
        return String.valueOf(parsedName);
    }

    public void printResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public void printAllResults(GameResult gameResult) {
        System.out.println("실행 결과");
        for(Map.Entry<String, String> entry: gameResult.result().entrySet()){
            System.out.printf("%s : %s%n", entry.getKey(), entry.getValue());
        }
    }
}

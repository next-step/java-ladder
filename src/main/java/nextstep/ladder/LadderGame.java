package nextstep.ladder;

import nextstep.ladder.domain.LadderGameInfo;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Result;
import nextstep.ladder.dto.LadderRequestDto;
import nextstep.ladder.dto.LadderResponseDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private static final String DELIMITER = ",";
    private static final int FIRST_LINE = 0;

    public static LadderResponseDto run(LadderRequestDto ladderRequestDto) {
        List<Person> persons = namesToPersons(ladderRequestDto.getNames());
        List<Result> results = resultStringsToResult(ladderRequestDto.getResults());
        List<LadderLine> ladderLines = personsToLadderLines(persons, ladderRequestDto.getHeight());

        return new LadderResponseDto(ladderLines, new LadderGameInfo(persons, results));
    }

    private static List<Result> resultStringsToResult(String results) {
        return Arrays.asList(results.split(DELIMITER)).stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    private static List<LadderLine> personsToLadderLines(List<Person> persons, int heightOfLadder) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for(int i = 0; i < heightOfLadder; i++) {
            ladderLines.add(LadderLine.of(persons.size()));
        }
        return ladderLines;
    }

    private static List<Person> namesToPersons(String names) {
        return Arrays.asList(names.split(DELIMITER)).stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public static List<Integer> findResult(List<LadderLine> ladderLines, List<Integer> linePositions) {
        List<Integer> resultPositions = new ArrayList<>();
        for (int linePosition : linePositions) {
            int nextLinePosition = getNextLinePosition(ladderLines, linePosition);
            resultPositions.add(nextLinePosition);
        }
        return resultPositions;
    }

    private static int getNextLinePosition(List<LadderLine> ladderLines, int linePosition) {
        int nextLinePosition = ladderLines.get(FIRST_LINE).move(linePosition);
        for(int i = 1; i < ladderLines.size(); i++) {
            nextLinePosition = ladderLines.get(i).move(nextLinePosition);
        }
        return nextLinePosition;
    }
}

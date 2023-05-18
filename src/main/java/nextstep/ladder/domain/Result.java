package nextstep.ladder.domain;

import java.util.Iterator;
import java.util.List;

import static nextstep.ladder.utils.Util.convertArrayToList;

public class Result implements Iterable<String> {

    public static final String DELIMITER = ",";
    public static final String ALL = "all";
    public static final String COLON = " : ";
    public static final String LINE_BREAK = "\n";
    private final List<String> results;

    public static Result of(Participants participants, String resultList) {
        String[] splitResults = resultList.split(DELIMITER);
        validateIfHasSameNum(participants, splitResults);
        return new Result(convertArrayToList(splitResults));
    }

    private static void validateIfHasSameNum(Participants participants, String[] splitResults) {
        if (participants.isNotSameNum(splitResults.length)) {
            throw new IllegalArgumentException("참여자 수와 같은 결과 수를 입력하셔야 합니다.");
        }
    }

    private Result(List<String> results) {
        this.results = List.copyOf(results);
    }

    @Override
    public Iterator<String> iterator() {
        return results.iterator();
    }

    public String gameResult(Participants participants, String name, List<Line> ladder) {;
        if (name.equals(ALL)) {
            return makeAllResult(participants, ladder);
        }

        validateName(participants, name);
        int index = calculateIndexOfResult(participants, name, ladder);
        return results.get(index);
    }

    private String makeAllResult(Participants participants, List<Line> ladder) {
        StringBuilder result = new StringBuilder();
        participants.forEach(participant -> {
            int index = calculateIndexOfResult(participants, participant, ladder);
            result.append(participant).append(COLON).append(results.get(index)).append(LINE_BREAK);
        });
        return result.toString();
    }

    private void validateName(Participants participants, String name) {
        participants.contains(name);
    }

    private int calculateIndexOfResult(Participants participants, String name, List<Line> ladder) {
        int index = participants.indexOf(name);
        int maxIndex = participants.maxIndex();

        for (Line line : ladder) {
            index = calculateIndex(index, maxIndex, line);
        }
        return index;
    }

    private int calculateIndex(int index, int maxIndex, Line line) {
        if (checkIndexLine(index, maxIndex, line)) {
            index++;
            return index;
        }
        if (checkPreviousIndexLine(index, line)) {
            index--;
        }
        return index;
    }

    private static boolean checkPreviousIndexLine(int index, Line line) {
        return index - 1 >= 0 && line.get(index - 1);
    }

    private static boolean checkIndexLine(int index, int maxIndex, Line line) {
        return index != maxIndex && line.get(index);
    }
}
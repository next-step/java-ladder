package nextstep.ladder.view;

import nextstep.ladder.dto.LadderElementsDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultConsoleOutput {

    private static final String RESULT = "\n실행 결과\n";
    private static final int SINGLE = 1;

    public static void print(final LadderElementsDto players, final List<String> results) {
        System.out.println(getResult(players, results));
    }

    private static String getResult(final LadderElementsDto players, final List<String> results) {
        if (results.size() == SINGLE) {
            return results.stream()
                    .collect(Collectors.joining("\n", RESULT, ""));
        }
        return IntStream.range(0, results.size())
                .mapToObj(i -> players.getElement(i) + " : " + results.get(i))
                .collect(Collectors.joining("\n", RESULT, ""));
    }
}

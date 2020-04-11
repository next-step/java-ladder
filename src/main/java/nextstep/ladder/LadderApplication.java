package nextstep.ladder;

import nextstep.ladder.domain.Person;
import nextstep.ladder.dto.LadderRequestDto;
import nextstep.ladder.dto.LadderResponseDto;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderApplication {
    private static final String PRINT_ALL = "all";
    private static final String DEFAULT = "";

    public static void main(String[] args) {
        LadderRequestDto ladderRequestDto = InputView.inputParameters();
        LadderResponseDto ladderResponseDto = LadderGame.run(ladderRequestDto);
        ResultView.printLadder(ladderResponseDto);
        String name = DEFAULT;
        while (!name.equals(PRINT_ALL)) {
            name = InputView.inputResultName();
            List<Integer> linePositions = getPrintedPeoplePositions(ladderResponseDto.getLadderGameInfo().getPersons(), name);
            ResultView.printOutput(LadderGame.findResult(ladderResponseDto.getLadderLines(), linePositions),
                    name, ladderResponseDto);
        }
    }

    private static List<Integer> getPrintedPeoplePositions(List<Person> persons, String name) {
        if (name.equals(PRINT_ALL)) {
            return IntStream.range(0, persons.size()).boxed()
                    .collect(Collectors.toList());
        }
        return Collections.singletonList(persons.indexOf(new Person(name)));
    }
}

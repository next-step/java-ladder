package nextstep.ladder;

import nextstep.ladder.domain.Person;
import nextstep.ladder.dto.LadderRequestDto;
import nextstep.ladder.dto.LadderResponseDto;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderApplication {
    private static final String PRINT_ALL = "all";
    private static final String DEFAULT = "";

    public static void main(String[] args) {
        LadderRequestDto ladderRequestDto = InputView.inputParameters();
        LadderResponseDto ladderResponseDto = LadderGame.makeLadder(ladderRequestDto);
        ResultView.printLadder(ladderResponseDto);
        String name = DEFAULT;
        while (!name.equals(PRINT_ALL)) {
            name = InputView.inputResultName();
            List<String> names = getPrintedPeopleNames(ladderResponseDto.getLadderGameInfo().getPersons(), name);
            ResultView.printOutput(LadderGame.findResult(ladderResponseDto.getLadder(), names),
                    names, ladderResponseDto);
        }
    }

    private static List<String> getPrintedPeopleNames(List<Person> persons, String name) {
        if (name.equals(PRINT_ALL)) {
            return persons.stream()
                    .map(Person::getName)
                    .collect(Collectors.toList());
        }
        return Collections.singletonList(name);
    }

}

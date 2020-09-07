package ladder.domain;

import ladder.view.PrintResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private List<GamePerson> people;
    private Ladder ladder;

    private LadderGame(List<GamePerson> people, Ladder ladder) {
        this.people = people;
        this.ladder = ladder;
    }

    public static LadderGame of(String namesValue, int ladderHeight) {
        List<GamePerson> people = Arrays.stream(StringSplit.splitWithDelimiter(namesValue))
                .map(GamePerson::new)
                .collect(Collectors.toList());
        return new LadderGame(people, Ladder.of(new LadderHeight(ladderHeight), people.size()));
    }

    public void game() {
        PrintResult.printNames(people);
        PrintResult.makeLadder(ladder.getLines());
    }

    public List getNames() {
        return people;
    }
}

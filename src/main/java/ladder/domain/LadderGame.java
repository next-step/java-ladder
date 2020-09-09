package ladder.domain;

import ladder.view.PrintResult;

import java.util.Arrays;
import java.util.Collections;
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

    public static LadderGame of2(List<GamePerson> people, Ladder ladder) {
        return new LadderGame(people, ladder);
    }


    public void game(String resultValue) {
        PrintResult.printNames(people);
        PrintResult.makeLadder(ladder);
        List<String> gameReult = Arrays.stream(StringSplit.splitWithDelimiter(resultValue))
                .collect(Collectors.toList());
        PrintResult.printResults(gameReult);
        LadderResult ladderResult = new LadderResult(gameReult, this);
        ladderResult.result();

    }

    public List<GamePerson> getPeople() {
        return Collections.unmodifiableList(people);
    }

    public Ladder getLadder() {
        return ladder;
    }
}

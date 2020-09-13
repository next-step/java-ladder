package refactor.domain;


import refactor.util.StringSplitUtil;
import refactor.view.PrintResult;
import refactor.view.ResultView;

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
        List<GamePerson> people = Arrays.stream(StringSplitUtil.splitWithDelimiter(namesValue))
                .map(GamePerson::new)
                .collect(Collectors.toList());
        return new LadderGame(people, Ladder.init(ladderHeight, people.size()));
    }

    public static LadderGame of(List<GamePerson> people, Ladder ladder) {
        return new LadderGame(people,ladder);
    }

    public void game(String resultValue) {
        List<String> gameReult = Arrays.stream(StringSplitUtil.splitWithDelimiter(resultValue))
                .collect(Collectors.toList());
        LadderResult ladderResult = new LadderResult(gameReult, this);
        ResultView resultView = new ResultView(ladderResult);
        resultView.reuslt();

    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<GamePerson> getPeople() {
        return people;
    }
}

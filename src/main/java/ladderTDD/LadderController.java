package ladderTDD;

import ladderTDD.domain.Ladder;
import ladderTDD.domain.LadderResult;
import ladderTDD.domain.Result;
import ladderTDD.domain.levels.LadderLevel;
import ladderTDD.domain.levels.Level;
import ladderTDD.player.People;
import ladderTDD.player.Person;
import ladderTDD.view.InputView;
import ladderTDD.view.ResultView;

import java.util.HashMap;
import java.util.Map;

public class LadderController {
    public static void main(String[] args) {
        People people = InputView.getPersonNames();
        LadderResult ladderResult = new LadderResult(InputView.getResult(), people);
        Level level = Level.valueByHeight(InputView.getLadderHeight());
        LadderLevel ladderLevel = LadderLevel.of(level);

        Ladder ladder = Ladder.initLadder(ladderLevel, people);

        ResultView.showLadder(people, ladder);
        Result result = ladderResult.getResultForPerson(InputView.getWantPeopleForResult(), ladder);
        ResultView.showResult(result);

        InputView.getWantPeopleForResult();
        Map<Person, Result> resultMap = new HashMap<>();

        for (Person p : people.getPeople()) {
            resultMap.put(p, ladderResult.getResultForPerson(p, ladder));
        }

        ResultView.showAllResult(resultMap);
    }

}

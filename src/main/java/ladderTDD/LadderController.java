package ladderTDD;

import ladderTDD.domain.Ladder;
import ladderTDD.domain.LadderResult;
import ladderTDD.domain.Result;
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
        Ladder ladder = Ladder.initLadder(InputView.getLadderHeight(), people);

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

package ladder;

import ladder.domain.*;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.People;
import ladder.domain.player.Person;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderController {

    public static void main(String[] args) {
        People people= InputView.getPersonNames();
        LadderResult ladderResult = new LadderResult(InputView.getResult(), people);
        Ladder ladder = InputView.getLadderHeight();
        ladder.generateLadder(people);
        ResultView.showLadder(people, ladder);

        Person person = InputView.getWantPeopleForResult();
        Result result = ladderResult.getResultForPerson(person, ladder);
        ResultView.showResult(result);

        InputView.getWantPeopleForResult();
        Map<Person, Result> resultMap = new HashMap<>();

        for (Person p : people.getPeople()) {
            resultMap.put(p, ladderResult.getResultForPerson(p, ladder));
        }

        ResultView.showAllResult(resultMap);
    }

}

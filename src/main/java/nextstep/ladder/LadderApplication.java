package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderReward;
import nextstep.ladder.domain.MatchingReward;
import nextstep.ladder.domain.Person;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.Output;

public class LadderApplication {

    private static final Input input = new Input();
    private static final Output output = new Output();
    public static void main(String[] args) {

        Person persons = new Person(input.joinPerson());
        LadderReward results = new LadderReward(input.runResult());
        Ladder ladder = new Ladder(persons.size(), input.ladderHeight());

        output.ladderResult(persons, ladder, results);

        String person = input.resultWantPerson();

        MatchingReward match = results.runReward(ladder.play());
        match.line(persons, results);

        output.finalResult(match, person);
    }
}

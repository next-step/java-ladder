package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Person;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.Output;

public class LadderApplication {
    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();
        Person persons = new Person(input.joinPerson());
        LadderResult results = new LadderResult(input.runResult());
        int height = input.ladderHeight();
        System.out.println();
        Ladder ladder = new Ladder(persons.size(), height);
        output.personName(persons);
        output.ladderResult(ladder);
        output.runResult(results);
        String person = input.resultWantPerson();
        ladder.play();
        output.finalResult(persons, results, person);
    }
}

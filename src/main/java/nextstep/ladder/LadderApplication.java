package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Person;
import nextstep.ladder.service.RunResultSave;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.Output;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();
//        List<String> persons = input.joinPerson();
        Person persons = new Person(input.joinPerson());
        List<String> results = input.runResult();
        int height = input.ladderHeight();
        System.out.println();
        Ladder ladder = new Ladder(persons.size(), height);
        output.personName(persons);
        output.ladderResult(ladder);
        output.runResult(results);
        String person = input.resultWantPerson();
        new RunResultSave().runResult(ladder, persons, results, person);

    }
}

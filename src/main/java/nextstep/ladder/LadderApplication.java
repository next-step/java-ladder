package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.Output;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();
        List<String> persons = input.joinPerson();
        int height = input.ladderHeight();
        Ladder ladder = new Ladder(persons.size(), height);
        output.personName(persons);
        output.result(ladder);
    }
}

package reladder.controller;

import reladder.domain.DefaultLadderGenerator;
import reladder.domain.Ladder;
import reladder.domain.People;
import reladder.domain.Results;

public class LadderController {

    public Ladder execute(String names, int height, String result) {
        People people = new People(names);
        Results results = new Results(result);

        Ladder ladder = new DefaultLadderGenerator().generate(height, people.size());

        return ladder;
    }
}

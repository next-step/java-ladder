package reladder.controller;

import ladder.view.ResultView;
import reladder.domain.DefaultLadderGenerator;
import reladder.domain.Ladder;
import reladder.domain.People;

public class LadderController {

    public Ladder execute(String names, int height, String result) {
        People people = new People(names);

        Ladder ladder = new DefaultLadderGenerator().generate(height, people.size());

        return ladder;
    }
}

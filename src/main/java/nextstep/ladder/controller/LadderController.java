package nextstep.ladder.controller;

import java.util.List;
import nextstep.ladder.domain.Participant;

public class LadderController {
    public void run(List<String> names, int height) {
        for (String name : names) {
            Participant participant = new Participant(name);
        }


    }
}

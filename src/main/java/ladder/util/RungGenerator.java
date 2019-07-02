package ladder.util;

import ladder.model.Rung;

import java.util.ArrayList;
import java.util.List;

public class RungGenerator {
    public static Rung generate() {
        return new Rung(true);
    }

    public static List<Rung> generate(int countOfPlayers) {
        List<Rung> rungs = new ArrayList<>();
        for(int i = 0; i < countOfPlayers; i++) {
            rungs.add(generate());
        }
        return rungs;
    }
}

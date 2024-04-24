package nextstep.ladder.service;

import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RunResultSaveTest {

    @Test
    void runResult() {

        int height = 5;
        Ladder ladder = new Ladder(4, height);
        List<String> persons = new ArrayList<>(List.of("pobi", "honux", "crong", "jk"));
        List<String> results = new ArrayList<>(List.of("꽝","5000","꽝","3000"));

        RunResultSave resultSave = new RunResultSave();
        resultSave.runResult(ladder, persons, results, "pobi");
    }
}
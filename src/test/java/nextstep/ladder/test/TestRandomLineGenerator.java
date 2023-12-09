package nextstep.ladder.test;

import nextstep.ladder.model.RandomLineGenerator;

public class TestRandomLineGenerator extends RandomLineGenerator {

    @Override
    public Boolean randomStep() {
        return false;
    }

    public TestRandomLineGenerator() {
        super();
    }
}

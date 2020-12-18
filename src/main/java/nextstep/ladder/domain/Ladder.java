package nextstep.ladder.domain;

import nextstep.ladder.domain.laddergenerator.DefaultGenerator;
import nextstep.ladder.domain.laddergenerator.LadderGenerator;

public class Ladder {

    private final Members members;
    private final Height height;
    private Links links;

    public Ladder(Members members, Height height) {
        this.members = members;
        this.height = height;
    }

    public void generateLadderWith(LadderGenerator ladderGenerator) {
        links = ladderGenerator.generate(members, height);
    }

    public Links getLinks() {
        return this.links;
    }
}

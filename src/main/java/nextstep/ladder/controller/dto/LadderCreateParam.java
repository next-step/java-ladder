package nextstep.ladder.controller.dto;

import nextstep.ladder.controller.People;

public class LadderCreateParam {
    private final People people;
    private final Integer heightOfLadder;

    public LadderCreateParam(People people, Integer heightOfLadder) {
        this.people = people;
        this.heightOfLadder = heightOfLadder;
    }

    public static LadderCreateParam of(People people, Integer heightOfLadder) {
        return new LadderCreateParam(people, heightOfLadder);
    }

    public Integer getHeightOfLadder() {
        return heightOfLadder;
    }

    public Integer getCountOfPerson() {
        return people.count();
    }
}

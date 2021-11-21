package nextstep.refactor_ladder.controller.dto;

import nextstep.refactor_ladder.domain.value.Person;

import java.util.List;

public class LadderCreateParam {
    private final Integer sizeOfPerson;
    private final Integer heightOfLadder;

    public LadderCreateParam(List<Person> people, Integer heightOfLadder) {
        this.sizeOfPerson = people.size();
        this.heightOfLadder = heightOfLadder;
    }

    public static LadderCreateParam of(List<Person> people, Integer heightOfLadder) {
        return new LadderCreateParam(people, heightOfLadder);
    }

    public Integer getSizeOfPerson() {
        return sizeOfPerson;
    }

    public Integer getHeightOfLadder() {
        return heightOfLadder;
    }
}

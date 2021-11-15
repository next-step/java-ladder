package nextstep.ladder.controller.dto;

import nextstep.ladder.doamin.value.Person;

import java.util.List;

public class LadderCreateParam {
    private final List<Person> people;
    private final Integer heightOfLadder;

    public LadderCreateParam(List<Person> people, Integer heightOfLadder) {
        this.people = people;
        this.heightOfLadder = heightOfLadder;
    }

    public static LadderCreateParam of(List<Person> people, Integer heightOfLadder) {
        return new LadderCreateParam(people, heightOfLadder);
    }

    public Integer getHeightOfLadder() {
        return heightOfLadder;
    }

    public Integer getCountOfPerson() {
        return people.size();
    }
}

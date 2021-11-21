package nextstep.refactor_ladder.controller.dto;

public class LadderCreateParam {
    private final Integer sizeOfPerson;
    private final Integer heightOfLadder;

    public LadderCreateParam(Integer sizeOfPerson, Integer heightOfLadder) {
        this.sizeOfPerson = sizeOfPerson;
        this.heightOfLadder = heightOfLadder;
    }

    public static LadderCreateParam of(Integer sizeOfPerson, Integer heightOfLadder) {
        return new LadderCreateParam(sizeOfPerson, heightOfLadder);
    }

    public Integer getSizeOfPerson() {
        return sizeOfPerson;
    }

    public Integer getHeightOfLadder() {
        return heightOfLadder;
    }
}

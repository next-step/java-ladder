package nextstep.laddergame.domain.dto;

import nextstep.laddergame.domain.Gift;
import nextstep.laddergame.domain.Person;

public class ResultDTO {
    private String name;
    private String gift;

    private ResultDTO(Person person, Gift gift) {
        this.name = person.getName();
        this.gift = gift.getName();
    }

    public static ResultDTO of(Person person, Gift gift) {
        return new ResultDTO(person, gift);
    }

    public String getName() {
        return name;
    }

    public String getGift() {
        return gift;
    }
}

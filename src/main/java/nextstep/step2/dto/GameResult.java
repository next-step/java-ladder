package nextstep.step2.dto;

import nextstep.step2.vo.Gift;
import nextstep.step2.vo.Name;

import java.util.Objects;

public class GameResult {

    private final Name name;
    private final Gift gift;

    public GameResult(Name name, Gift gift) {
        this.name = name;
        this.gift = gift;
    }

    public Name getName() {
        return name;
    }

    public Gift getGift() {
        return gift;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameResult that = (GameResult) o;
        return Objects.equals(name, that.name) && Objects.equals(gift, that.gift);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gift);
    }
}

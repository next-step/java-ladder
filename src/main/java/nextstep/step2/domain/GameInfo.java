package nextstep.step2.domain;

import nextstep.step2.vo.Gift;
import nextstep.step2.vo.Gifts;
import nextstep.step2.vo.Name;
import nextstep.step2.vo.Names;

import java.util.Objects;
import java.util.Optional;

public class GameInfo {
    private static final String NOT_EQUAL_SIZE_MESSAGE = "참가자와 당첨선물의 갯수는 같아야 합니다.";

    private final Names names;
    private final Gifts gifts;

    private GameInfo(Names names, Gifts gifts) {
        this.names = names;
        this.gifts = gifts;
    }

    public static GameInfo of(Names names, Gifts gifts) {
        if (names.size() != gifts.size()) {
            throw new IllegalArgumentException(NOT_EQUAL_SIZE_MESSAGE);
        }
        return new GameInfo(names, gifts);
    }

    public Optional<Point> findStartPoint(Name name) {
        if (!names.contains(name)) {
            return Optional.empty();
        }

        return Optional.of(Point.of(names.indexOf(name)));
    }

    public Gift findGiftWithPoint(Point point) {
        return gifts.getGift(point.getValue());
    }

    public Names getNames() {
        return names;
    }

    public Gifts getGifts() {
        return gifts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameInfo gameInfo = (GameInfo) o;
        return Objects.equals(names, gameInfo.names) && Objects.equals(gifts, gameInfo.gifts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names, gifts);
    }
}

package nextstep.ladder.fixture;

import nextstep.ladder.domain.element.Pillar;
import nextstep.ladder.domain.strategy.LineCreateStrategy;

public class Fixture {

    public static final LineCreateStrategy CREATE_STRATEGY = () -> true;
    public static final LineCreateStrategy NOT_CREATE_STRATEGY = () -> false;

    public static final Pillar RIGHT_LINE_PILLAR = Pillar.makeStart(CREATE_STRATEGY);
    public static final Pillar LEFT_LINE_PILLAR = Pillar.makeStart(CREATE_STRATEGY).makeMiddle(CREATE_STRATEGY);
    public static final Pillar NONE_LINE_PILLAR = Pillar.makeStart(NOT_CREATE_STRATEGY);

}

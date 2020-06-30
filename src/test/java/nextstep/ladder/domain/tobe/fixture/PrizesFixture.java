package nextstep.ladder.domain.tobe.fixture;

import nextstep.ladder.domain.Prize;
import nextstep.ladder.domain.Prizes;

import java.util.Arrays;

public class PrizesFixture {
    public static Prizes TestPrizes = new Prizes(
            Arrays.asList(
                    new Prize("꽝"),
                    new Prize("5000"),
                    new Prize("꽝"),
                    new Prize("3000")));
}

package nextstep.ladder.factory;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.generator.NonConsecutiveFlagGenerator;

public class LadderFactory {

    public static Ladder ladder(int height, int width, NonConsecutiveFlagGenerator generator) {
        return new Ladder(width, LadderDataConverter.convert(height, width, generator));
    }

}

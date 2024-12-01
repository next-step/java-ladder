package nextstep.ladder.factory;

import nextstep.ladder.domain.LadderImpl;
import nextstep.ladder.generator.NonConsecutiveFlagGenerator;
import nextstep.ladder.domain.Ladder;

public class LadderFactory {

    public static Ladder ladder(int height, int width, NonConsecutiveFlagGenerator generator) {
        return new LadderImpl(width, LadderDataConverter.convert(height, width, generator));
    }

}

package nextstep.ladder.domain;

import java.util.List;

public interface LineGenerator {
    List<Bridge> generateBridges(Integer numbersOfPeople);
}

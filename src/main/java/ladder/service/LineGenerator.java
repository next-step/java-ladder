package ladder.service;

import ladder.model.HorizontalLine;
import ladder.model.LadderLength;

import java.util.List;


public interface LineGenerator {

    List<HorizontalLine> generate(int numberOfUser, LadderLength length);
}

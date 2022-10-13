package ladder.domain;

import java.util.List;


public interface LineGenerator {

    List<HorizontalLine> generate(int numberOfUser, LadderLength length);
}

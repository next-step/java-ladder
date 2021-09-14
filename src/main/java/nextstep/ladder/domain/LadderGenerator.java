package nextstep.ladder.domain;

import java.util.List;

public interface LadderGenerator {

    List<Line> generate(int height, int width);
}

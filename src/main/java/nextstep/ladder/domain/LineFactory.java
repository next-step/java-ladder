package nextstep.ladder.domain;

import java.util.List;

public interface LineFactory {

    List<Line> generateLines(PointFactory pointFactory);
}

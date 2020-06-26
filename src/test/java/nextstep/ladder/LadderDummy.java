package nextstep.ladder;

import ladder.domain.Ladder;
import ladder.domain.Layer;
import ladder.domain.Point;
import ladder.domain.Prizes;
import org.assertj.core.util.Lists;
import java.util.List;

public class LadderDummy {
    public Ladder ladder;
    public Prizes prizes;

    public LadderDummy(){
        Point topPoint1 = Point.of(0, false, true);
        Point topPoint2 = Point.of(1, true, false);
        Point topPoint3 = Point.of(2, false, false);

        Point bottomPoint1 = Point.of(0, false, false);
        Point bottomPoint2 = Point.of(1, false, true);
        Point bottomPoint3 = Point.of(2, true, false);

        Layer top = Layer.of(Lists.list(topPoint1, topPoint2, topPoint3));
        Layer bottom = Layer.of(Lists.list(bottomPoint1, bottomPoint2, bottomPoint3));

        List<Layer> layers = Lists.list(top, bottom);
        ladder = Ladder.of(layers);
        prizes = Prizes.of("보상1, 보상2, 보상3");
    }
}

package nextstep.ladder2.domain.builder;

import java.util.List;
import nextstep.ladder2.domain.NxLine;

public interface LadderBuilder {
    List<NxLine> build(int height, int countOfPerson);
}

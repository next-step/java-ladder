package nextstep.ladder.domain.laddergenerator;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Links;
import nextstep.ladder.domain.Members;

public interface LadderGenerator {

    Links generate(Members members, Height height);
}

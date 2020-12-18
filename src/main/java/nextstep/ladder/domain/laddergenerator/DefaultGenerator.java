package nextstep.ladder.domain.laddergenerator;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Links;
import nextstep.ladder.domain.Members;

public class DefaultGenerator implements LadderGenerator {

    @Override
    public Links generate(Members members, Height height) {
        int x = members.getNumberOfMembers() - 1;
        int y = height.getHeight();

        Links links = new Links(x, y);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                links.markOn(i, j);
            }
        }

        return links;
    }
}

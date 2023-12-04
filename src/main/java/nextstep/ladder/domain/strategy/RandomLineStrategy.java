package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.Brace;
import nextstep.ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class RandomLineStrategy implements LineStrategy {
    @Override
    public Line createLine(int personCount) {
        List<Brace> createdBraces = new ArrayList<>();
        Brace brace = createFirstBrace(createdBraces);
        brace = createMiddleBraces(personCount, brace, createdBraces);
        createLastBrace(brace, createdBraces);

        return new Line(createdBraces);
    }

    private Brace createFirstBrace(List<Brace> createdBraces) {
        Brace brace = Brace.first();
        createdBraces.add(brace);
        return brace;
    }

    private Brace createMiddleBraces(int personCount, Brace brace, List<Brace> createdBraces) {
        for (int index = 1; index <= personCount - 2; index++) {
            brace = brace.next();
            createdBraces.add(brace);
        }
        return brace;
    }

    private void createLastBrace(Brace brace, List<Brace> createdBraces) {
        brace = brace.last();
        createdBraces.add(brace);
    }
}

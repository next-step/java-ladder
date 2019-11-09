package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {
    private static final int LINK_MIN_COUNT = 1;
    private final LinkGenerationStrategy linkGenerationStrategy;

    public LadderMaker(final LinkGenerationStrategy linkGenerationStrategy) {
        this.linkGenerationStrategy = linkGenerationStrategy;
    }

    public Ladder makeLadder(final int countOfLine, final int countOfRow) {
        final List<LadderRow> ladderRows = new ArrayList<>();

        for (int i = 0; i < countOfLine; i++) {
            final LadderRow ladderRow = makeLadderRow(countOfLine, countOfRow);
            ladderRows.add(ladderRow);
        }

        return new Ladder(new LadderRows(ladderRows));
    }

    private LadderRow makeLadderRow(int countOfLine, int countOfRow) {
        final List<Line> lines = new ArrayList<>();
        for (int i = 0; i < countOfLine; i++) {
            lines.add(new Line());
        }

        final List<Link> links = new ArrayList<>();
        boolean enableToGenerate = false;
        for (int i = 0; i < countOfRow; i++) {
            enableToGenerate = linkGenerationStrategy.isEnableToGenerate(enableToGenerate);
            links.add(new Link(enableToGenerate));
        }

        return new LadderRow(new Lines(lines), new Links(links));
    }
}

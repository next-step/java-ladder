package ladder.domain.core.line.name;

import java.util.List;
import java.util.stream.Stream;

import ladder.domain.core.line.Line;
import ladder.ui.result.DisplayResult;
import ladder.ui.result.NamesDisplayResult;

import static java.util.stream.Collectors.toList;
import static ladder.domain.core.line.name.Name.verifyBlankName;
import static ladder.domain.core.line.name.LadderResultLine.LadderResulNames.ladderResulNames;

public class LadderResultLine implements Line {
    private final LadderResulNames names;

    LadderResultLine(LadderResulNames names) {
        this.names = names;
    }

    public static LadderResultLine of(String ladderResults) {
        return new LadderResultLine(ladderResulNames(ladderResults));
    }

    @Override
    public String getResult(int index) {
        return names.get(index);
    }

    @Override
    public int getWidth() {
        return names.getCount();
    }

    @Override
    public DisplayResult toDisplayResult() {
        return new NamesDisplayResult(names);
    }

    static class LadderResulNames extends Names<LadderResult> {
        private static final String SEPARATOR = ",";

        LadderResulNames(List<LadderResult> names) {
            super(names);
        }

        static LadderResulNames ladderResulNames(String ladderResults) {
            verifyBlankName(ladderResults);

            List<LadderResult> ladderResultList = Stream.of(ladderResults.split(SEPARATOR))
                                                      .map(LadderResult::new)
                                                      .collect(toList())
                ;
            return new LadderResulNames(ladderResultList);
        }
    }
}

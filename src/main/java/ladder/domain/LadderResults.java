package ladder.domain;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static ladder.domain.LadderMessage.BLANK_TEXT_MESSAGE;

public class LadderResults implements Iterable<LadderResult>, Printable {

    public static final String LADDER_RESULT_DELIMITER = ",";

    private final List<LadderResult> ladderResults;

    private LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public static LadderResults fromText(String text) {
        checkArgument(StringUtils.isNotBlank(text), BLANK_TEXT_MESSAGE);

        String[] names = text.split(LADDER_RESULT_DELIMITER);

        List<LadderResult> ladderResults = new ArrayList<>();
        for (String name : names) {
            ladderResults.add(new LadderResult(name.trim()));
        }
        return new LadderResults(ladderResults);
    }

    public int size() {
        return ladderResults.size();
    }

    @Nonnull
    @Override
    public Iterator<LadderResult> iterator() {
        return ladderResults.iterator();
    }

    @Override
    public String print() {
        return ladderResults.stream()
                .map(LadderResult::print)
                .collect(Collectors.joining(" "));
    }
}

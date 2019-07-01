package ladder.domain;

import ladder.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    private static final String RESULTS_DELIMITER = ",";
    private List<LadderResult> ladderResults;

    public LadderResults(String results, int participantSize) {

        if (StringUtils.isBlank(results)) {
            throw new IllegalArgumentException("실행결과가 빈 값입니다.");
        }

        this.ladderResults = StringUtils.split(results, RESULTS_DELIMITER)
                .stream()
                .map(LadderResult::new)
                .collect(Collectors.toList());

        if (this.ladderResults.size() != participantSize) {
            throw new IllegalArgumentException("참가자 수와 결과 수가 일치하지 않습니다. 참가자 수=" + participantSize + ", 결과 수=" + this.ladderResults.size());
        }
    }

    public List<LadderResult> getLadderResults() {

        return ladderResults;
    }
}

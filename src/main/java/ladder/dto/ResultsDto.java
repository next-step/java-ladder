package ladder.dto;

import ladder.domain.LadderMembers;
import ladder.domain.LadderResult;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsDto {
    private final List<ResultDto> values;

    public ResultsDto(LadderMembers members, List<LadderResult> ladderResults) {
        this.values = create(members, ladderResults);
    }

    private List<ResultDto> create(LadderMembers members, List<LadderResult> results) {
        return results.stream()
                .map(result -> new ResultDto(members.findByMember(result.memberIndex()).name(), result.result()))
                .collect(Collectors.toList());
    }

    public List<ResultDto> values() {
        return values;
    }
}

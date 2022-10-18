package nextstep.ladder.dto;

import nextstep.ladder.domain.LadderWinningResult;
import nextstep.ladder.domain.ParticipationNames;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderWinningResultDto {

    private final Map<String, String> ladderResultDto;

    public LadderWinningResultDto(final Map<String, String> ladderResultDto) {

        this.ladderResultDto = ladderResultDto;
    }

    public static LadderWinningResultDto of(final LadderWinningResult ladderWinningResult
            , final ParticipationNames participationNames, final List<String> resultNames) {

        return new LadderWinningResultDto(collect(ladderWinningResult, participationNames, resultNames));
    }

    public Map<String, String> getLadderResultDto() {

        return ladderResultDto;
    }

    public static Map<String, String> collect(final LadderWinningResult ladderWinningResult
            , final ParticipationNames participationNames, final List<String> resultNames) {

        final Map<String, String> ladderResultDto = new HashMap<>();
        final Map<Integer, Integer> ladderResult = ladderWinningResult.getLadderResult();
        for (Map.Entry<Integer, Integer> entry : ladderResult.entrySet()) {
            ladderResultDto.put(participationNames.getName().get(entry.getKey()), resultNames.get(entry.getValue()));
        }
        return ladderResultDto;
    }
}

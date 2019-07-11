package ladder.domain;

import ladder.dto.LadderCreateRequestDto;
import ladder.dto.LadderCreateResponseDto;
import ladder.dto.LadderResultRequestDto;
import ladder.dto.LadderResultResponseDto;

public interface LadderService {
    LadderCreateResponseDto createLadder(LadderCreateRequestDto ladderCreateRequestDto);
    LadderResultResponseDto startLadder(LadderResultRequestDto ladderResultRequestDto);
}

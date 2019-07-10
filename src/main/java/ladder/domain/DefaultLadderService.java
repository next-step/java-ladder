package ladder.domain;

import ladder.common.Csv;
import ladder.domain.ladderline.LadderLines;
import ladder.domain.user.LadderPlayer;
import ladder.domain.user.LadderResult;
import ladder.domain.user.LadderUsers;
import ladder.domain.user.Username;
import ladder.dto.LadderCreateRequestDto;
import ladder.dto.LadderCreateResponseDto;
import ladder.dto.LadderResultRequestDto;
import ladder.dto.LadderResultResponseDto;

public class DefaultLadderService implements LadderService {

    private final LadderLineFactory ladderLineFactory;

    private LadderLines ladderLines;
    private LadderUsers ladderUsers;
    private Csv ladderResult;

    public DefaultLadderService(LadderLineFactory ladderLineFactory) {
        this.ladderLineFactory = ladderLineFactory;
    }

    @Override
    public LadderCreateResponseDto createLadder(LadderCreateRequestDto ladderCreateRequestDto) {
        ladderUsers = LadderUsers.of(ladderCreateRequestDto.getLadderUsers().getCsv());
        ladderResult = ladderCreateRequestDto.getLadderResults();
        ladderLines = ladderLineFactory.create(ladderUsers.getCountOfUsers(), ladderCreateRequestDto.getLadderHeight());
        return LadderCreateResponseDto.of(ladderUsers, ladderLines, ladderResult);
    }

    @Override
    public LadderResultResponseDto startLadder(LadderResultRequestDto ladderResultRequestDto) {
        Username resultUsername = Username.of(ladderResultRequestDto.getResultUsername());
        LadderPlayer ladderPlayer = LadderPlayer.of(ladderLines, ladderUsers, ladderResult);
        return LadderResultResponseDto.of(ladderPlayer.start(resultUsername));
    }
}

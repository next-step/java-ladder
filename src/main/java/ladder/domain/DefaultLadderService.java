package ladder.domain;

import ladder.common.Csv;
import ladder.domain.ladderline.LadderLines;
import ladder.domain.user.LadderPlayer;
import ladder.domain.user.LadderUsers;
import ladder.domain.user.Username;
import ladder.dto.LadderCreateRequestDto;
import ladder.dto.LadderCreateResponseDto;
import ladder.dto.LadderResultRequestDto;
import ladder.dto.LadderResultResponseDto;

public class DefaultLadderService implements LadderService {

    private final LadderLineFactory ladderLineFactory;

    private LadderPlayer ladderPlayer;

    public DefaultLadderService(LadderLineFactory ladderLineFactory) {
        this.ladderLineFactory = ladderLineFactory;
    }

    @Override
    public LadderCreateResponseDto createLadder(LadderCreateRequestDto ladderCreateRequestDto) {
        LadderUsers ladderUsers = LadderUsers.of(ladderCreateRequestDto.getLadderUsers().getCsv());
        Csv ladderResult = ladderCreateRequestDto.getLadderResults();
        LadderLines ladderLines = ladderLineFactory.create(ladderUsers.getCountOfUsers(), ladderCreateRequestDto.getLadderHeight());
        ladderPlayer = LadderPlayer.of(ladderLines, ladderUsers, ladderResult);

        return LadderCreateResponseDto.of(ladderUsers, ladderLines, ladderResult);
    }

    @Override
    public LadderResultResponseDto startLadder(LadderResultRequestDto ladderResultRequestDto) {
        Username resultUsername = Username.of(ladderResultRequestDto.getResultUsername());
        return LadderResultResponseDto.of(ladderPlayer.start(resultUsername));
    }
}

package nextstep.ladder.ui;

import nextstep.ladder.domain.ladder.DirectionStrategy;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderMaterial;
import nextstep.ladder.domain.ladderGame.LadderGame;
import nextstep.ladder.domain.ladderGame.LadderGameInfo;
import nextstep.ladder.domain.ladderGame.LadderGameResult;
import nextstep.ladder.dto.LadderRequest;
import nextstep.ladder.dto.LadderResponse;

import java.util.Random;

public class LadderController {

    public LadderResponse run(final LadderRequest ladderRequest) {
        DirectionStrategy directionStrategy = () -> {
            Random random = new Random();
            return random.nextBoolean();
        };
        LadderMaterial ladderMaterial = ladderRequest.toLadderMaterial(directionStrategy);
        LadderGameInfo ladderGameInfo = ladderRequest.toLadderGameInfo();

        Ladder ladder = Ladder.from(ladderMaterial);
        LadderGame ladderGame = LadderGame.of(ladder, ladderGameInfo);
        LadderGameResult ladderGameResult = ladderGame.play();
        return new LadderResponse(ladder, ladderGameInfo, ladderGameResult);
    }
}

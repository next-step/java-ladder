package nextstep.ladder.domain;

import nextstep.ladder.dto.LadderGameResult;

public interface LadderGame {

    static LadderGame newLadderGame(LadderGameMaterials ladderGameMaterials) {
        return null;
    }

    LadderGameResult exec();
}

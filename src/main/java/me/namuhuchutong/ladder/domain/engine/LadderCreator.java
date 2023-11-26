package me.namuhuchutong.ladder.domain.engine;

import me.namuhuchutong.ladder.domain.engine.dto.UserInputInformation;

public interface LadderCreator {

    Ladder createLadder(UserInputInformation userInputInformation);
}

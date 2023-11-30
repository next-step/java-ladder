package me.namuhuchutong.ladder.domain.implement;

import me.namuhuchutong.ladder.domain.engine.*;
import me.namuhuchutong.ladder.domain.engine.Ladder;
import me.namuhuchutong.ladder.domain.engine.dto.UserInputInformation;

import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toUnmodifiableList;

public class LadderGameCreator implements LadderCreator {

    private final LineCreator lineCreator;

    public LadderGameCreator(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    @Override
    public Ladder createLadder(UserInputInformation information) {
        Names names = Names.from(information.getInputNames());
        Rows rows = Stream.generate(() -> lineCreator.createLine(names.size()))
                             .limit(information.getLadderHeight())
                             .collect(collectingAndThen(toUnmodifiableList(),
                                                        Rows::new));
        Results results = Results.from(information.getInputResults());
        return new LadderGame(rows, names, results);
    }
}

package com.fineroot.ladder.domain;

import com.fineroot.ladder.engine.Ladder;
import com.fineroot.ladder.engine.LadderCreator;
import com.fineroot.ladder.engine.LineCreator;
import com.fineroot.ladder.utils.RandomUtils;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyLadderCreator implements LadderCreator {

    private final LineCreator lineCreator;

    public MyLadderCreator(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    @Override
    public Ladder create(int countOfUsers, int countOfHeight) {
        return new MyLadder(Stream.generate(() ->
                        lineCreator.create(
                                RandomUtils.getBooleanArray(countOfUsers - 1)))
                .limit(countOfHeight).collect(Collectors.toList()), countOfUsers);
    }
}

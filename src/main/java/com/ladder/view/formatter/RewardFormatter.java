package com.ladder.view.formatter;

import com.ladder.model.Reward;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.ladder.view.formatter.LadderFormatter.LADDER_OF_EMPTY;

public class RewardFormatter implements Formatter<Reward> {

    public static final String PRINT_OF_EMPTY = " ";

    @Override
    public String format(Reward reward) {
        String name = reward.getReward();
        int startPoint = LADDER_OF_EMPTY.length() - name.length();

        return IntStream.rangeClosed(0, startPoint)
                .mapToObj((num) -> PRINT_OF_EMPTY)
                .collect(Collectors.joining())
                .concat(name);
    }
}
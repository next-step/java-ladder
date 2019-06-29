package com.ladder.view.formatter;

import com.ladder.model.Player;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.ladder.view.formatter.LadderFormatter.LADDER_OF_EMPTY;

public class PlayerFormatter implements Formatter<Player> {

    public static final String PRINT_OF_EMPTY = " ";

    @Override
    public String format(Player player) {
        String name = player.getName();
        int startPoint = LADDER_OF_EMPTY.length() - name.length();

        return IntStream.rangeClosed(0, startPoint)
                .mapToObj((num) -> PRINT_OF_EMPTY)
                .collect(Collectors.joining())
                .concat(name);
    }
}

package ladder.formatter;

import ladder.domain.Player;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.utility.NameConstants.BLANK_TO_FILL_THE_NAME_SPACE;
import static ladder.utility.NameConstants.SPACE_FOR_NAME;

public class PlayerNameFormatter implements NameFormatter<Player> {

    @Override
    public String nameFormat(Player player) {
        String name = player.getName();
        int spaceForBlank = SPACE_FOR_NAME - name.length();

        return IntStream.rangeClosed(0, spaceForBlank)
                .mapToObj((integer) -> BLANK_TO_FILL_THE_NAME_SPACE)
                .collect(Collectors.joining())
                .concat(name);
    }
}

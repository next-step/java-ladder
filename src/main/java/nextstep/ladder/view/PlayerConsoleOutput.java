package nextstep.ladder.view;

import nextstep.ladder.dto.PlayerDto;
import nextstep.ladder.dto.PlayersDto;

import java.text.MessageFormat;

import static java.util.stream.Collectors.joining;

public class PlayerConsoleOutput {

    private static final String DELIMITER = " ";
    private static final String NEXT_LINE = "\n";
    private static final String NONE = "";

    public static void print(final PlayersDto playersDto) {
        System.out.println(playersDto.getPlayers()
                .stream()
                .map(PlayerConsoleOutput::toName)
                .collect(joining(DELIMITER, NEXT_LINE, NONE)));
    }

    private static String toName(final PlayerDto playerDto) {
        String format = MessageFormat.format("%{0}s", playerDto.getMaxLength());
        return String.format(format, playerDto.getName());
    }
}

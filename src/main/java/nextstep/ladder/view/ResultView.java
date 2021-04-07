package nextstep.ladder.view;

import nextstep.ladder.dto.Connections;
import nextstep.ladder.dto.LadderDto;
import nextstep.ladder.dto.PlayerDto;

import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.util.StringUtils.padToLeft;
import static nextstep.ladder.util.StringUtils.repeat;

public class ResultView {

    private static final int STRING_ELEMENT_SIZE = 5;
    private static final String POINT = "|";
    private static final String WHITE_SPACE = " ";
    private static final String HYPHEN = "-";

    public void printPlayers(List<PlayerDto> players) {
        List<String> paddedNameList = players.stream()
                                             .map(player -> padToLeft(player.getName(), STRING_ELEMENT_SIZE))
                                             .collect(Collectors.toList());

        System.out.println(String.join(WHITE_SPACE, paddedNameList));
    }

    public void printLadder(LadderDto ladder) {
        ladder.getConnectionsList()
              .stream()
              .map(this::depictConnections)
              .forEach(System.out::println);
    }

    private String depictConnections(Connections connections) {
        StringBuilder stringBuilder = new StringBuilder(repeat(WHITE_SPACE, STRING_ELEMENT_SIZE - 1) + POINT);

        connections.getConnectionList()
                   .forEach(connected -> {
                       stringBuilder.append(repeat(selectSymbol(connected), STRING_ELEMENT_SIZE));
                       stringBuilder.append(POINT);
                   });

        return stringBuilder.toString();
    }

    private String selectSymbol(boolean connected) {
        return connected ? HYPHEN : WHITE_SPACE;
    }

}

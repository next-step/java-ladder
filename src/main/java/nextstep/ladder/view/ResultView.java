package nextstep.ladder.view;

import nextstep.ladder.dto.*;

import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.util.StringUtils.*;

public class ResultView {

    private static final int STRING_ELEMENT_SIZE = 5;
    private static final String POINT = "|";
    private static final String WHITE_SPACE = " ";
    private static final String HYPHEN = "-";

    public void printPlayers(PlayerNamesDto dto) {
        List<String> paddedNameList = dto.getPlayerNames()
                                         .stream()
                                         .map(playerName -> padToLeft(playerName, STRING_ELEMENT_SIZE))
                                         .collect(Collectors.toList());

        System.out.println(String.join(WHITE_SPACE, paddedNameList));
    }

    public void printLadderBoard(LadderBoardDto ladderBoardDto) {
        printLadder(ladderBoardDto.getLadderDto());
        printRewards(ladderBoardDto.getRewardsDto());
    }

    private void printLadder(LadderDto ladder) {
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

    private void printRewards(RewardsDto rewardsDto) {
        List<String> paddedRewards = rewardsDto.getRewards()
                                               .stream()
                                               .map(reward -> padToRight(reward, STRING_ELEMENT_SIZE))
                                               .collect(Collectors.toList());

        System.out.println(String.join(WHITE_SPACE, paddedRewards));
    }

    public void printLadderGameReport(LadderGameReport report) {
        List<PlayerDto> playerDtoList = report.getPlayerDtoList();

        System.out.println("실행 결과");
        if (playerDtoList.size() == 1) {
            System.out.println(playerDtoList.get(0).getReward());
        } else {
            playerDtoList.forEach(playerDto -> System.out.println(playerDto.getName() + " : " + playerDto.getReward()));
        }
    }

}

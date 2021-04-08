package nextstep.ladder.view;

import nextstep.ladder.dto.*;
import nextstep.ladder.util.Pair;

import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.util.StringUtils.*;

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
            .map(reward -> padToRight(reward.getRewardString(), STRING_ELEMENT_SIZE))
            .collect(Collectors.toList());

        System.out.println(String.join(WHITE_SPACE, paddedRewards));
    }

    public void printLadderGameReport(LadderGameReport report) {
        List<Pair<PlayerDto, RewardDto>> results = report.getResults();

        System.out.println("실행 결과");
        if (results.size() == 1) {
            Pair<PlayerDto, RewardDto> pair = results.get(0);
            System.out.println(pair.getSecond()
                .getRewardString());
        } else {
            results.forEach(pair -> {
                String name = pair.getFirst()
                    .getName();
                String reward = pair.getSecond()
                    .getRewardString();

                System.out.println(name + " : " + reward);
            });
        }
    }

}

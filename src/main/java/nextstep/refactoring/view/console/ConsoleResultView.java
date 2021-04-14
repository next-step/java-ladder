package nextstep.refactoring.view.console;

import nextstep.refactoring.ladder.engine.dto.LadderDto;
import nextstep.refactoring.ladder.engine.dto.LineDto;
import nextstep.refactoring.laddergame.engine.player.PlayersDto;
import nextstep.refactoring.laddergame.engine.reward.RewardsDto;
import nextstep.refactoring.view.interfaces.ResultView;

import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.util.StringUtils.*;

public class ConsoleResultView implements ResultView {

    private static final int STRING_ELEMENT_SIZE = 5;
    private static final String POINT = "|";
    private static final String WHITE_SPACE = " ";
    private static final String HYPHEN = "-";


    @Override
    public void printPlayers(PlayersDto playersDto) {
        List<String> paddedNameList = playersDto.nameList()
                                                .stream()
                                                .map(name -> padToLeft(name, STRING_ELEMENT_SIZE))
                                                .collect(Collectors.toList());

        System.out.println(String.join(WHITE_SPACE, paddedNameList));
    }

    @Override
    public void printRewards(RewardsDto rewardsDto) {
        List<String> paddedRewards = rewardsDto.rewards()
                                               .stream()
                                               .map(reward -> padToRight(reward, STRING_ELEMENT_SIZE))
                                               .collect(Collectors.toList());

        System.out.println(String.join(WHITE_SPACE, paddedRewards));
    }

    @Override
    public void printLadder(LadderDto ladderDto) {
        ladderDto.lineDtoList()
                 .stream().map(LineDto::connectionList)
                 .map(this::depictConnections)
                 .forEach(System.out::println);
    }

    private String depictConnections(List<Boolean> connections) {
        StringBuilder stringBuilder =  new StringBuilder(repeat(WHITE_SPACE, STRING_ELEMENT_SIZE - 1) + POINT);

        connections.stream()
                   .map(connection -> repeat(selectSymbol(connection), STRING_ELEMENT_SIZE) + POINT)
                   .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    private String selectSymbol(boolean connection) {
        return connection ? HYPHEN : WHITE_SPACE;
    }

}

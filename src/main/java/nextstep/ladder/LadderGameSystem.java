package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.edge.*;
import nextstep.ladder.domain.line.Dimension;
import nextstep.ladder.dto.LadderDto;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameSystem {

    public static void main(String[] args) {
        List<String> names = List.of(InputView.showNamesInput().split(","));
        LadderUsers ladderUsers = new LadderUsers(IntStream.range(0, names.size())
            .mapToObj(i -> new LadderUser(names.get(i), new Position(i))).collect(Collectors.toList())
        );

        List<String> prizes = List.of(InputView.showResultsInput().split(","));
        LadderPrizes ladderPrizes = new LadderPrizes(prizes.stream()
            .map(LadderPrize::new).collect(Collectors.toList())
        );

        LadderConfig ladderConfig = new LadderConfig(ladderUsers, ladderPrizes);
        Dimension dimension = new Dimension(InputView.showLadderHeightInput());
        LadderDto ladderDto = new Ladder(ladderConfig, dimension).toLadderDto();

        OutputView.showLadderResult(ladderDto);
        OutputView.showLadderUserResult(ladderDto);
    }
}

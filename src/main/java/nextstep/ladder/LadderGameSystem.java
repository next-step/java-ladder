package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.line.Dimension;
import nextstep.ladder.domain.prize.LadderPrize;
import nextstep.ladder.domain.prize.LadderPrizes;
import nextstep.ladder.domain.user.LadderUser;
import nextstep.ladder.domain.user.LadderUsers;
import nextstep.ladder.domain.user.Position;
import nextstep.ladder.dto.LadderDto;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameSystem {

    public static void main(String[] args) {
        List<String> names = InputView.showNamesInput();
        LadderUsers ladderUsers = new LadderUsers(IntStream.range(0, names.size())
            .mapToObj(i -> new LadderUser(names.get(i), new Position(i))).collect(Collectors.toList())
        );

        List<String> prizes = InputView.showResultsInput();
        LadderPrizes ladderPrizes = new LadderPrizes(prizes.stream()
            .map(LadderPrize::new).collect(Collectors.toList())
        );

        Dimension dimension = new Dimension(InputView.showLadderHeightInput());
        LadderDto ladderDto = new Ladder(ladderUsers, ladderPrizes, dimension).toLadderDto();

        OutputView.showLadderResult(ladderDto);
        OutputView.showLadderUserResult(ladderDto);
    }
}

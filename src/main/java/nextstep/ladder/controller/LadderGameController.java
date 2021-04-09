package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.User;
import nextstep.ladder.generator.DefaultLineGenerator;
import nextstep.ladder.generator.LineGenerator;
import nextstep.ladder.service.Ladder;
import nextstep.ladder.service.LadderResult;
import nextstep.ladder.service.LadderRewards;
import nextstep.ladder.service.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import static nextstep.ladder.controller.LadderParameterHelper.parseArgumentResolver;

public class LadderGameController {

    public static final String GUIDE_LADDER_END_SIGNATURE = "all";
    private final LadderParameterProcessor processor;
    private final ResultView resultView;
    private final LineGenerator generator = new DefaultLineGenerator();

    public LadderGameController(final InputView inputView, final ResultView resultView) {
        this(new LadderParameterProcessor(inputView), resultView);
    }

    public LadderGameController(final LadderParameterProcessor processor, final ResultView resultView) {
        this.processor = processor;
        this.resultView = resultView;
    }

    public void start() {
        Participants participants = parseArgumentResolver(processor::processUsers);
        LadderRewards rewards =
                parseArgumentResolver(() -> processor.processLadderRewards(participants.size()));
        Height height = parseArgumentResolver(processor::processHeight);

        Ladder ladder = Ladder.valueOf(participants, height, generator);
        LadderResult ladderResult = LadderResult.rideLadder(participants, ladder, rewards);

        resultView.printResult(ladder, participants, rewards);

        String user;
        do {
            user = parseArgumentResolver(processor::inputUserResult);
        } while (!isOneOrAll(ladderResult, user));
    }

    private boolean isOneOrAll(final LadderResult ladderResult, final String user) {
        if(user.equals(GUIDE_LADDER_END_SIGNATURE)) {
            resultView.printUserResult(ladderResult.findAll());
            return true;
        }
        User findUser = User.valueOf(user);
        resultView.printUserResult(ladderResult.findOf(findUser));
        return false;
    }
}

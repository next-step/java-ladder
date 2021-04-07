package nextstep.ladder.controller;

import nextstep.ladder.generator.DefaultLineGenerator;
import nextstep.ladder.generator.LineGenerator;
import nextstep.ladder.service.LadderFactory;
import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.wrapper.*;

import static nextstep.ladder.controller.LadderParameterHelper.parseArgumentResolver;

public class LadderGameController {

    public static final String GUIDE_LADDER_END_SIGNATURE = "all";
    private final LadderParameterProcessor processor;
    private final ResultView resultView;
    private final LineGenerator generator;

    public LadderGameController(final InputView inputView, final ResultView resultView) {
        this(new LadderParameterProcessor(inputView), resultView, new DefaultLineGenerator());
    }

    public LadderGameController(final LadderParameterProcessor processor, final ResultView resultView, final LineGenerator generator) {
        this.processor = processor;
        this.resultView = resultView;
        this.generator = generator;
    }

    public void start() {
        Participants participants = parseArgumentResolver(processor::processUsers);
        LadderRewards rewards =
                parseArgumentResolver(() -> processor.processLadderRewards(participants.size()));
        Height height = parseArgumentResolver(processor::processHeight);

        Ladder ladder = LadderFactory.valueOf(participants, height, generator);
        LadderResult ladderResult = LadderFactory.rideLadder(participants, ladder, rewards);

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

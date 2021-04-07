package nextstep.ladder.controller;

import nextstep.ladder.service.LadderService;
import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.wrapper.Ladder;
import nextstep.ladder.wrapper.LadderResult;
import nextstep.ladder.wrapper.LadderRewards;
import nextstep.ladder.wrapper.Participants;

import static nextstep.ladder.controller.LadderParameterHandler.parseArgumentResolver;

public class LadderGameController {

    public static final String GUIDE_LADDER_END_SIGNATURE = "all";
    private final LadderParameterProcessor processor;
    private final ResultView resultView;

    public LadderGameController(InputView inputView, ResultView resultView) {
        this(new LadderParameterProcessor(inputView), resultView);
    }

    public LadderGameController(LadderParameterProcessor processor, ResultView resultView) {
        this.processor = processor;
        this.resultView = resultView;
    }

    public void start() {

        Participants participants = parseArgumentResolver(processor::processUsers);
        LadderRewards rewards =
                parseArgumentResolver(() -> processor.processLadderRewards(participants.size()));
        Height height = parseArgumentResolver(processor::processHeight);
        Ladder ladder = Ladder.valueOf(participants, height);

        LadderResult rewardResult = LadderService.rideLadder(participants, ladder, rewards);
        resultView.printResult(ladder, participants, rewards);

        String user;
        do {
            user = parseArgumentResolver(processor::inputUserResult);
        } while (!isOneOrAll(rewardResult, user));
    }

    private boolean isOneOrAll(LadderResult rewardResult, String user) {
        if(user.equals(GUIDE_LADDER_END_SIGNATURE)) {
            resultView.printUserResult(rewardResult.findAll());
            return true;
        }
        User findUser = User.valueOf(user);
        resultView.printUserResult(rewardResult.findOf(findUser));
        return false;
    }


}

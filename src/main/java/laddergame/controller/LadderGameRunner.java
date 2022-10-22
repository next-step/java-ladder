package laddergame.controller;

import laddergame.component.LadderFactory;
import laddergame.domain.*;
import laddergame.dto.LadderGameResult;
import laddergame.dto.LadderGameRunRequest;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameRunner {

    private final LadderFactory ladderFactory;

    public LadderGameRunner(LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public LadderGameResult run(LadderGameRunRequest request) {
        ParticipantNames participantNames = ParticipantNames.from(request.getParticipantNames());
        LadderGameRewards rewards = LadderGameRewards.from(request.getRewards());
        Ladder ladder = ladderFactory.createLadder(participantNames.size(), request.getHeight());
        return LadderGameResult.of(ladder, calculateRewardByParticipantName(participantNames, rewards, ladder));
    }

    private Map<ParticipantName, LadderGameReward> calculateRewardByParticipantName(ParticipantNames participantNames, LadderGameRewards rewards, Ladder ladder) {
        return IntStream.range(0, participantNames.size())
                .boxed()
                .collect(Collectors.toMap(
                        participantNames::get,
                        i -> rewards.get(ladder.moveToLastLine(i))
                ));
    }

}

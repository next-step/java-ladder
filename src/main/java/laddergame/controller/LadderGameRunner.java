package laddergame.controller;

import laddergame.component.LadderFactory;
import laddergame.domain.Ladder;
import laddergame.domain.LadderGame;
import laddergame.domain.LadderGameReward;
import laddergame.domain.ParticipantNames;
import laddergame.dto.LadderGameResult;
import laddergame.dto.LadderGameRunRequest;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameRunner {

    private final LadderFactory ladderFactory;

    public LadderGameRunner(LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public LadderGameResult run(LadderGameRunRequest request) {
        ParticipantNames participantNames = ParticipantNames.from(request.getParticipantNames());
        List<LadderGameReward> rewards = parseLadderGameRewards(request.getRewards());
        Ladder ladder = ladderFactory.createLadder(participantNames.size(), request.getHeight());
        LadderGame ladderGame = new LadderGame(participantNames, rewards, ladder);
        return LadderGameResult.from(ladderGame);
    }

    private List<LadderGameReward> parseLadderGameRewards(List<String> rewards) {
        return rewards.stream()
                .map(LadderGameReward::new)
                .collect(Collectors.toList());
    }

}

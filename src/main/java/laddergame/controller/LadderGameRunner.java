package laddergame.controller;

import laddergame.component.LadderFactory;
import laddergame.domain.Ladder;
import laddergame.domain.LadderGameReward;
import laddergame.domain.ParticipantName;
import laddergame.domain.ParticipantNames;
import laddergame.dto.LadderGameResult;
import laddergame.dto.LadderGameRunRequest;

import java.util.List;
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
        List<LadderGameReward> rewards = parseLadderGameRewards(request.getRewards());
        Ladder ladder = ladderFactory.createLadder(participantNames.size(), request.getHeight());
        return LadderGameResult.of(ladder, calculateRewardByParticipantName(participantNames, rewards, ladder));
    }

    private List<LadderGameReward> parseLadderGameRewards(List<String> rewards) {
        return rewards.stream()
                .map(LadderGameReward::new)
                .collect(Collectors.toList());
    }

    private Map<ParticipantName, LadderGameReward> calculateRewardByParticipantName(ParticipantNames participantNames, List<LadderGameReward> rewards, Ladder ladder) {
        return IntStream.range(0, participantNames.size())
                .boxed()
                .collect(Collectors.toMap(
                        participantNames::get,
                        i -> rewards.get(ladder.moveToLastLine(i))
                ));
    }

}

package laddergame.domain;

import laddergame.component.LadderFactory;
import laddergame.dto.LadderGameResult;
import laddergame.dto.LadderGameRunRequest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private final LadderFactory ladderFactory;

    public LadderGame(LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public LadderGameResult run(LadderGameRunRequest request) {
        List<ParticipantName> participantNames = parseParticipantNames(request.getParticipantNames());
        List<LadderGameReward> rewards = parseLadderGameRewards(request.getRewards());
        Ladder ladder = ladderFactory.createLadder(participantNames.size(), request.getHeight());
        Map<ParticipantName, LadderGameReward> rewardByName = IntStream.range(0, participantNames.size())
                .boxed()
                .collect(Collectors.toMap(
                        participantNames::get,
                        i -> rewards.get(ladder.moveToLastLine(i))
                ));
        return LadderGameResult.of(participantNames, rewards, ladder, rewardByName);
    }

    private List<ParticipantName> parseParticipantNames(List<String> participantNames) {
        return participantNames.stream()
                .map(ParticipantName::new)
                .collect(Collectors.toList());
    }

    private List<LadderGameReward> parseLadderGameRewards(List<String> rewards) {
        return rewards.stream()
                .map(LadderGameReward::new)
                .collect(Collectors.toList());
    }

}

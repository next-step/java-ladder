package laddergame.dto;

import laddergame.domain.LadderGame;
import laddergame.domain.LadderGameReward;
import laddergame.domain.ParticipantName;
import laddergame.domain.ParticipantNames;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LadderGameResult {

    private final LadderGameDto ladderGame;
    private final Map<String, String> rewardByName;

    public LadderGameResult(LadderGameDto ladderGame, Map<String, String> rewardByName) {
        this.ladderGame = ladderGame;
        this.rewardByName = rewardByName;
    }

    public static LadderGameResult from(LadderGame ladderGame) {
        LadderGameDto ladderGameDto = LadderGameDto.from(ladderGame);
        Map<ParticipantName, LadderGameReward> rewardByName = ladderGame.calculateRewardByParticipantName();
        Map<String, String> rewardByNameDto = new HashMap<>();
        ParticipantNames participantNames = ladderGame.getParticipantNames();
        IntStream.range(0, participantNames.size())
                .mapToObj(participantNames::get)
                .forEach(participantName -> rewardByNameDto.put(
                        participantName.toString(),
                        rewardByName.get(participantName).toString())
                );
        return new LadderGameResult(ladderGameDto, rewardByNameDto);
    }

    public LadderGameDto getLadderGame() {
        return ladderGame;
    }

    public Map<String, String> getRewardByName() {
        return rewardByName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGameResult that = (LadderGameResult) o;
        return Objects.equals(ladderGame, that.ladderGame) && Objects.equals(rewardByName, that.rewardByName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderGame, rewardByName);
    }

    @Override
    public String toString() {
        return "LadderGameResult{" +
                "ladderGame=" + ladderGame +
                ", rewardByName=" + rewardByName +
                '}';
    }

}

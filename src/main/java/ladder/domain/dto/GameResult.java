package ladder.domain.dto;

import ladder.domain.participant.Participant;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameResult {

    private static final String ALL_KEYWORD = "all";
    private Map<String, String> gameResult;

    public GameResult(List<Participant> participants, Reward reward) {
        this.gameResult = participants.stream()
                             .collect(Collectors.toMap(Participant::getUserName,
                                      participant -> reward.findRewardByPosition(participant.getPosition())));
    }


    public String search(String keyword) {
        return Optional.ofNullable(gameResult.get(keyword))
                        .orElseThrow(IllegalArgumentException::new);
    }

    public Map<String, String> searchAll(String keyword){
        if(!keyword.equals(ALL_KEYWORD)){
            throw new IllegalArgumentException();
        }
        return Collections.unmodifiableMap(gameResult);
    }
}

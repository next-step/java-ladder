package laddergame.domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static laddergame.ApplicationLauncher.ALL;

public class LadderGameResult {
    private static final String COLON = ":";

    private final Map<EndPoint, EndPoint> rewardsForParticipants;

    public LadderGameResult(EndPoints participants, LadderLines ladderLines, EndPoints rewards) {
        rewardsForParticipants = getRewardsForParticipants(participants, ladderLines, rewards);
    }

    LadderGameResult(Map<EndPoint, EndPoint> rewardsForParticipants) {
        this.rewardsForParticipants = rewardsForParticipants;
    }

    private Map<EndPoint, EndPoint> getRewardsForParticipants(EndPoints participants, LadderLines ladderLines, EndPoints rewards) {
        return participants.getEndPoints()
                .stream()
                .collect(toMap(
                        entry -> entry,
                        entry -> rewards.getEndPoint(ladderLines.move(entry.getIndex())),
                        (v1, v2) -> v1,
                        LinkedHashMap::new)
                );
    }

    public List<String> getRewardResultStrings(String name) {
        if(ALL.equals(name)) {
            return getAllRewardResultStrings();
        }

        return getOneRewardResultString(name);
    }

    private List<String> getAllRewardResultStrings() {
        return rewardsForParticipants
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + " " + COLON + " " + entry.getValue())
                .collect(Collectors.toList());
    }

    private List<String> getOneRewardResultString(String name) {
        return new ArrayList<>(
                Collections.singleton(
                        Optional.ofNullable(rewardsForParticipants.get(name))
                                .map(EndPoint::getName)
                                .orElse("없음")
                )
        );
    }
}
package laddergame.domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static laddergame.ApplicationLauncher.ALL;

public class Result {
    private static final String COLON = ":";

    private final Map<String, String> rewardsForParticipants;
    private final List<String> ladderLineStrings;

    public Result(EndPoints participants, LadderLines ladderLines, EndPoints rewards) {
        rewardsForParticipants = getRewardsForParticipants(participants, ladderLines, rewards);
        ladderLineStrings = getLadderLineStrings(participants, ladderLines, rewards);
    }

    private List<String> getLadderLineStrings(EndPoints participants, LadderLines ladderLines, EndPoints rewards) {
        List<String> ladderLineStrings = new ArrayList<>();
        ladderLineStrings.add(participants.toString());
        ladderLineStrings.add(ladderLines.toString());
        ladderLineStrings.add(rewards.toString());
        return ladderLineStrings;
    }

    private Map<String, String> getRewardsForParticipants(EndPoints participants, LadderLines ladderLines, EndPoints rewards) {
        return participants.getEndPoints()
                .stream()
                .collect(toMap(
                    EndPoint::getName,
                    entry -> rewards.getEndPoint(ladderLines.move(entry.getIndex())).getName(),
                    (v1, v2) -> v1,
                    LinkedHashMap::new)
                );
    }

    public List<String> getLadderLineStrings() {
        return ladderLineStrings;
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
                        .orElse("없음")
            )
        );
    }
}
package laddergame.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class LadderGame {

    public static Result play(EndPoints participants, LadderLines ladderLines, EndPoints rewards) {
        return new Result(
                getLineResult(participants, ladderLines, rewards),
                getGameResult(participants, ladderLines, rewards)
        );
    }

    private static List<String> getLineResult(EndPoints participants, LadderLines ladderLines, EndPoints rewards) {
        List<String> ladderLineStrings = new ArrayList<>();
        ladderLineStrings.add(participants.toString());
        ladderLineStrings.add(ladderLines.toString());
        ladderLineStrings.add(rewards.toString());
        return ladderLineStrings;
    }

    private static Map<EndPoint, EndPoint> getGameResult(EndPoints participants, LadderLines ladderLines, EndPoints rewards) {
        return participants.getEndPoints()
                .stream()
                .collect(toMap(
                        entry -> entry,
                        entry -> rewards.getEndPoint(ladderLines.move(entry.getIndex())),
                        (v1, v2) -> v1,
                        LinkedHashMap::new)
                );
    }
}

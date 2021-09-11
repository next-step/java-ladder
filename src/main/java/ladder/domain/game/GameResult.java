package ladder.domain.game;

import ladder.domain.ladder.LadderSize;
import ladder.domain.participant.Participant;
import ladder.domain.participant.Participants;
import ladder.domain.position.Position;
import ladder.exception.InvalidForGameResult;
import ladder.exception.NoMatchOfPrizeException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {
    private final List<LadderPrize> ladderPrizes;
    private final Map<String, String> result;

    GameResult(Participants participants, List<LadderPrize> ladderPrizes, LadderSize ladderSize) {
        validate(ladderPrizes.size(), ladderSize.getCountOfParticipants());
        this.ladderPrizes = ladderPrizes;
        this.result = getResult(participants.getPaticipants());
    }

    public GameResult(Participants participants, String[] prizeNames, LadderSize ladderSize) {
        this(participants,
                IntStream.range(0, prizeNames.length)
                .mapToObj((i) -> new LadderPrize(prizeNames[i], new Position(i, ladderSize)))
                .collect(Collectors.toList()),
                ladderSize);
    }

    private void validate(int ladderPrizesSize, int countOfParticipants) {
        if (ladderPrizesSize != countOfParticipants) {
            throw new InvalidForGameResult(ladderPrizesSize, countOfParticipants);
        }
    }

    private String getResultOfParticipant(Participant participant) {
        return ladderPrizes.stream()
                .filter((n) -> n.matchPrize(participant))
                .map(LadderPrize::getName)
                .findFirst()
                .orElseThrow(() -> new NoMatchOfPrizeException(participant.getName()));
    }

    private Map<String, String> getResult(final List<Participant> participantsList) {
        Map<String, String> resultMap = new HashMap<>(participantsList.size());

        for (Participant participant : participantsList) {
            resultMap.put(participant.getName(), getResultOfParticipant(participant));
        }

        return resultMap;
    }

    public String findResult(final String nameOfParticipant) {
        return result.get(nameOfParticipant);
    }
}

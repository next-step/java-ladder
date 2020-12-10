package ladder.domain.game;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created By mand2 on 2020-12-09.
 */
public class LadderResult {

    public static final String MESSAGE_NAME_NOT_MATCH_PARTICIPANT_LIST = "입력한 이름과 일치하는 참가자가 없습니다.";
    private final Map<Name, Name> resultOfLadder;


    private LadderResult(Map<Name, Name> resultOfLadder) {
        this.resultOfLadder = resultOfLadder;
    }

    public static LadderResult of(Names participants, List<Name> moveResults) {
        return new LadderResult(createLadderResult(participants, moveResults));
    }

    private static Map<Name, Name> createLadderResult(Names participants, List<Name> moveResults) {
        return IntStream.range(0, participants.getParticipantNum())
                .boxed()
                .collect(Collectors.toMap(
                        participants::getParticipantName,
                        moveResults::get,
                        (u1, u2) -> u1,
                        HashMap::new
                ));
    }

    public Name getResultOfOneParticipant(Name participant) {
        checkParticipant(participant);
        return this.resultOfLadder.get(participant);
    }

    private void checkParticipant(Name participant) {
        if (!this.resultOfLadder.keySet().contains(participant)) {
            throw new IllegalArgumentException(MESSAGE_NAME_NOT_MATCH_PARTICIPANT_LIST);
        }
    }

    public Map<Name, Name> getResultOfAll() {
        return Collections.unmodifiableMap(this.resultOfLadder);
    }

}

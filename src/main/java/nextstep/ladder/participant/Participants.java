package nextstep.ladder.participant;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Participants {
    private List<Participant> participants;
    private static final String DELIMITER = ",";

    private Participants(String... names) {
        validation(names);
        AtomicInteger initPosition = new AtomicInteger();
        this.participants = Arrays.stream(names)
                .map(Participant::new)
                .collect(Collectors.toList());
        participants.stream()
                .forEach(vo -> vo.setStartPosition(initPosition.getAndIncrement(), participants.size()));
    }

    public static Participants of(String... names) {
        return new Participants(names);
    }

    public static Participants of(String nameStr) {
        String[] names = nameStr.split(DELIMITER);
        return new Participants(names);
    }

    private void validation(String[] names) {
        if(names.length < 2){
            throw new IllegalArgumentException("참여자는 2명 이상이여야 합니다.");
        }
    }

    public int size() {
        return this.participants.size();
    }

    public List<String> getNames() {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }
}

package ladder.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Participants {

    private final List<Participant> participants;

    public Participants(List<String> names) {
        validateDuplicate(names);
        this.participants = names.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    private void validateDuplicate(List<String> names) {
        Set<String> set = new HashSet<>(names);
        if (set.size() != names.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public int size() {
        return participants.size();
    }
}

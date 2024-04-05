package nextstep.step2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Entries {

    private final List<Participant> entries;

    public Entries(String names) {
        validation(names);
        this.entries = Arrays.stream(names.split(","))
                .map(String::trim)
                .map(Participant::new)
                .collect(Collectors.toList());
        validateDuplicate(entries);
    }

    private void validation(String names) {
        if (names == null || names.trim().isEmpty()) {
            throw new IllegalArgumentException("이름에는 null과 공백이 올 수 없습니다.");
        }
    }

    private void validateDuplicate(List<Participant> participants) {
        Set<String> uniqueNames = participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toSet());

        if (uniqueNames.size() != participants.size()) {
            throw new IllegalArgumentException("동명이인이 존재합니다");
        }
    }

    public List<Participant> getParticipantList() {
        return Collections.unmodifiableList(entries);
    }

    public int getParticipantListSize() {
        return entries.size();
    }
}

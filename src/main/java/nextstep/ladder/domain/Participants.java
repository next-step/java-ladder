package nextstep.ladder.domain;

import java.util.Iterator;
import java.util.List;

public class Participants implements Iterable<String> {
    public static final double MAX_NAME_LENGTH = 5;
    private static final int MIN_WIDTH = 2;
    private final List<String> participants;

    public Participants(List<String> names) {
        validateInput(names);
        this.participants = List.copyOf(names);
    }

    private void validateInput(List<String> names) {
        validateNameLength(names);
        validateParticipantNum(names);
    }

    private void validateNameLength(List<String> names) {
        names.stream()
                .filter(name -> name.length() > MAX_NAME_LENGTH)
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException(name + "는 입력할 수 없습니다.");
                });
    }

    private void validateParticipantNum(List<String> names) {
        if (names.size() < MIN_WIDTH) {
            throw new IllegalArgumentException("2명 이상의 인원이 존재해야 합니다.");
        }
    }

    public int number() {
        return participants.size();
    }

    @Override
    public Iterator<String> iterator() {
        return participants.iterator();
    }

    public boolean isNotSameNum(int length) {
        return participants.size() != length;
    }

    public int indexOf(String name) {
        return participants.indexOf(name);
    }

    public int maxIndex() {
        return participants.size() - 1;
    }

    public void validateResultInput(String input) {
        if (participants.contains(input) || Code.contains(input)) {
            return;
        }
        throw new IllegalArgumentException("Input은 코드나 참여자에 포함되어야 합니다.");
    }
}

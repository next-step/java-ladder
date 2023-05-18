package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Participants implements Iterable<String> {

    public static final String DELIMITER = ",";
    public static final double MAX_NAME_LENGTH = 5;
    private static final int MIN_WIDTH = 2;
    private final List<String> participants;

    public Participants(String nameList) {
        String[] splitName = nameList.split(DELIMITER);
        validateInput(splitName);
        this.participants = Arrays.stream(splitName)
                .collect(Collectors.toList());
    }

    private void validateInput(String[] split) {
        validateNameLength(split);
        validateParticipantNum(split);
    }

    private void validateParticipantNum(String[] split) {
        if (split.length < MIN_WIDTH) {
            throw new IllegalArgumentException("2명 이상의 인원이 존재해야 합니다.");
        }
    }

    private static void validateNameLength(String[] split) {
        Arrays.stream(split)
                .filter(name -> name.length() > MAX_NAME_LENGTH)
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException(name + "는 입력할 수 없습니다.");
                });
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

    public void contains(String name) {
        if (!participants.contains(name)) {
            throw new IllegalArgumentException("일치하는 참여자가 없습니다.");
        }
    }

    public int indexOf(String name) {
        return participants.indexOf(name);
    }

    public int maxIndex() {
        return participants.size() - 1;
    }
}

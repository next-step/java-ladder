package ladder.domain;

public class Participant {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private String name;

    public Participant(String name) {

        validateName(name);
        this.name = name;
    }

    public String getName() {

        return name;
    }

    private void validateName(String name) {

        if (name == null) {
            throw new IllegalArgumentException("참여자명이 null 입니다.");
        }

        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("참여자명 길이는 %d~%d자 여야 합니다.", MIN_NAME_LENGTH, MAX_NAME_LENGTH));
        }
    }
}

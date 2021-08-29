package step2.domain;

import java.util.Arrays;
import java.util.List;

public class Name {
    private static final int NAME_MAX_SIZE=5;
    private static final int NAME_MIN_SIZE=1;
    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름은 최소 1글자 최대 5글자까지 부여할 수 있습니다.";

    private static final String delimiter = ",";
    private List<String> participantNameList;
    private int countOfPerson;

    public Name(String stringName) {
        BuildName(stringName);
        participantNameList.stream()
                .forEach(this::CheckValidName);
    }

    private void BuildName(String stringName) {
        this.participantNameList = Arrays.asList(stringName.split(delimiter));
        this.countOfPerson = participantNameList.size();
    }

    private void CheckValidName(String name) {
        if (name.length() > NAME_MAX_SIZE || name.length() < NAME_MIN_SIZE) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public List<String> getParticipantNameList() {
        return participantNameList;
    }

    public int getCountOfPerson() {
        return countOfPerson;
    }
}

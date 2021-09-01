package step2.domain;

import step2.view.InputView;

import java.util.Arrays;
import java.util.List;

public class Name {
    private static final int NAME_MAX_SIZE = 5;
    private static final int NAME_MIN_SIZE = 1;
    private static final String delimiter = ",";
    private List<String> participantNames;
    private int countOfPerson;

    public Name(String stringName) {
        buildName(stringName);
        this.countOfPerson = participantNames.size();
    }

    private void buildName(String stringName) {
        this.participantNames = Arrays.asList(stringName.split(delimiter));
        participantNames.stream()
                .forEach(this::checkValidName);
    }

    private void checkValidName(String name) {
        if (name.length() > NAME_MAX_SIZE || name.length() < NAME_MIN_SIZE) {
            InputView.printNameLengthErrorMessage();
            InputView.requireNameOfParticipant();
        }
    }

    public List<String> getParticipantNames() {
        return participantNames;
    }

    public int getCountOfPerson() {
        return countOfPerson;
    }
}
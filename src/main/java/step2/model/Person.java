package step2.model;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final static String MAXIMUM_PERSON_NAME_LENGTH_EXCEPTION = "참여 인원의 이름은 5자를 초과하면 안됩니다.";
    private final static int MAXIMUM_PERSON_NAME_LENGTH = 5;

    private List<String> names = new ArrayList<>();

    private Person(String[] personArr) {
        for(String name : personArr) {
            confirmPersonNameLength(name);
            names.add(name);
        }
    }

    public static Person createPerson(String[] personArr) {
        return new Person(personArr);
    }

    public List<String> getNames() {
        return names;
    }

    //참여하는 인원 이름길이를 체크한다.
    private void confirmPersonNameLength(String person) {
        if (person.length() > MAXIMUM_PERSON_NAME_LENGTH) {
            throw new IllegalArgumentException(MAXIMUM_PERSON_NAME_LENGTH_EXCEPTION);
        }
    }
}

package step2.model;

public class Name {

    private final static String MAXIMUM_PERSON_NAME_LENGTH_EXCEPTION = "참여 인원의 이름은 5자를 초과하면 안됩니다.";
    private final static int MAXIMUM_PERSON_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        confirmPersonNameLength(name);
        this.name = name;
    }

    public static Name createName(String name) {
        return new Name(name);
    }

    public boolean checkName(String name) {
        return this.name.equals(name);
    }

    //참여하는 인원 이름길이를 체크한다.
    private void confirmPersonNameLength(String person) {
        if (person.length() > MAXIMUM_PERSON_NAME_LENGTH) {
            throw new IllegalArgumentException(MAXIMUM_PERSON_NAME_LENGTH_EXCEPTION);
        }
    }

    public String getName() {
        return name;
    }
}

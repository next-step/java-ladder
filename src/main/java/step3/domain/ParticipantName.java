package step3.domain;


import step3.exception.EmptyNameException;
import step3.exception.LengthNameException;
import step3.utils.StringUtil;

public class ParticipantName {
    private static final Integer MAX_LENGTH = 5;

    private String name;

    private ParticipantName(String name) {
        this.name = name;
    }

    public static ParticipantName of(String name) {
        validate(name);
        return new ParticipantName(name);
    }

    private static void validate(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new LengthNameException();
        }

        if (StringUtil.isEmpty(name)) {
            throw new EmptyNameException();
        }
    }

    public String getName() {
        return this.name;
    }
}

package ladder.dto.response;

public class PersonDto {

    private final int standardLength;
    private final String name;

    public PersonDto(int standardLength, String name) {
        this.standardLength = standardLength;
        this.name = name;
    }

    public int getStandardLength() {
        return standardLength;
    }

    public String getName() {
        return name;
    }
}

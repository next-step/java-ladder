package nextstep.dto;

import nextstep.entity.Entry;

public class EntryDTO implements DTO {

    private final String name;

    public EntryDTO(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) throws IllegalArgumentException {
        int length = name.length();
        if (length < 1 || length > 5) {
            throw new IllegalArgumentException("이름은 최소 1 글자, 최대 5 글자 까지 부여할 수 있어요.");
        }
    }

    public String getName(){
        return name;
    }

    public static Entry of(EntryDTO entryDTO) {
        return new Entry(entryDTO.name);
    }
}

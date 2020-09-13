package nextstep.dto;

import java.util.Objects;

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

    public static EntryDTO duplicate(EntryDTO entryDTO) {
        return new EntryDTO(entryDTO.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntryDTO entryDTO = (EntryDTO) o;

        return Objects.equals(name, entryDTO.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

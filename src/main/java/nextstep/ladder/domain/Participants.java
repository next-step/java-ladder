package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Participants {
    public static final String NULL_OR_EMPTY_ERROR_MESSAGE = "이름은 null 이거나 빈 문자열일 수 없습니다";
    public static final String TOO_LENGTH_ERROR_MESSAGE = "이름은 1자 이상 5자 이하로 입력해야 합니다";
    public static final String TOO_FEW_PARTICIPANTS_MESSAGE = "참여자는 2명 이상이어야 합니다.";
    private final List<String> names;

    public Participants(String[] names) {
        this(List.of(names));
    }

    public Participants(List<String> names) {
        this.valid(names);
        this.names = Collections.unmodifiableList(names);
    }

    private void valid(List<String> names) {
        if (names == null || names.size() < 2) {
            throw new IllegalArgumentException(TOO_FEW_PARTICIPANTS_MESSAGE);
        }

        names.forEach(name -> {
            if (name.isBlank()) {
                throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR_MESSAGE);
            }

            if (name.length() > 5) {
                throw new IllegalArgumentException(TOO_LENGTH_ERROR_MESSAGE + " - " + name);
            }
        });
    }

    public List<String> getNames() {
        return this.names;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(names);
    }
}

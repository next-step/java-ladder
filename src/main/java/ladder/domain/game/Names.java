package ladder.domain.game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * Created By mand2 on 2020-12-03.
 */
public class Names {

    public static final String MESSAGE_PARTICIPANTS_LIST_NON_NULL = "최소 한명 이상이 참여해야 합니다.";
    private static final String tokenizer = ",";

    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    private Names(String[] names) {
        this(toNameList(names));
    }

    public static Names from(String inputNames) {
        checkNull(inputNames);
        return new Names(nameSplitter(inputNames));
    }

    private static List<Name> toNameList(String[] inputNames) {
        return Arrays.stream(inputNames)
                .map(Name::from)
                .collect(Collectors.collectingAndThen(toList(), Collections::unmodifiableList));
    }

    private static String[] nameSplitter(String inputNames) {
        return inputNames.split(tokenizer);
    }

    private static void checkNull(String inputNames) {
        if (Objects.isNull(inputNames) || inputNames.isEmpty()) {
            throw new IllegalArgumentException(MESSAGE_PARTICIPANTS_LIST_NON_NULL);
        }
    }

    public List<Name> getNames() {
        return this.names;
    }

    public int getSize() {
        return this.names.size();
    }

    public int getIndexByName(Name participant) {
        return this.names.indexOf(participant);
    }

    public Name getNameByIndex(int index) {
        return this.names.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Names names1 = (Names) o;
        return Objects.equals(names, names1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}

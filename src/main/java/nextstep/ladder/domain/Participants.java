package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Participants {
    public static final String DUPLICATE_NAME_EXIST_ERR_MSG = "중복된 이름은 사용 할 수 없습니다.";
    private final List<Name> names;
    private final NumberOfParticipants numberOfParticipants;

    private Participants(List<String> inputNames) {
        names = getNames(inputNames);
        numberOfParticipants = NumberOfParticipants.valueOf(inputNames.size());
        validateDuplication(inputNames);
    }

    private List<Name> getNames(List<String> inputNames) {
        return inputNames.stream()
                .map(Name::valueOf)
                .distinct()
                .collect(Collectors.toList());
    }

    private void validateDuplication(List<String> inputNames) {
        if (names.size() != inputNames.size()) {
            throw new IllegalStateException(DUPLICATE_NAME_EXIST_ERR_MSG);
        }
    }

    public static Participants from(List<String> names) {
        return new Participants(names);
    }

    public static Participants of(String... inputNames) {
        return new Participants(Arrays.asList(inputNames));
    }

    public NumberOfParticipants getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void namesValueForEach(Consumer<String> consumer) {
        names.stream()
                .map(Name::getValue)
                .forEach(consumer);
    }

    public Name get(int index) {
        return names.get(index);
    }
}

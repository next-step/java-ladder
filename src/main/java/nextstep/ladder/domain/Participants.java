package nextstep.ladder.domain;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Participants {
    public static final String DUPLICATE_NAME_EXIST_ERR_MSG = "중복된 이름은 사용 할 수 없습니다.";
    private final Set<Name> names;
    private final NumberOfParticipants numberOfParticipants;

    private Participants(List<String> inputNames) {
        names = getNames(inputNames);
        numberOfParticipants = NumberOfParticipants.valueOf(inputNames.size());
        validateDuplication(inputNames);
    }

    private Set<Name> getNames(List<String> inputNames) {
        return inputNames.stream()
                .map(Name::valueOf)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private void validateDuplication(List<String> inputNames) {
        if (names.size() != inputNames.size()) {
            throw new IllegalStateException(DUPLICATE_NAME_EXIST_ERR_MSG);
        }
    }

    public static Participants from(List<String> names) {
        return new Participants(names);
    }

    public NumberOfParticipants getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void namesValueForEach(Consumer<String> consumer) {
        names.stream()
                .map(Name::getValue)
                .forEach(consumer);
    }
}

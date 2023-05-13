package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    public static final int MINIMUM_OF_PARTICIPANT = 1;

    private static final String USER_NAME_DELIMITER = ",";

    private final List<UserName> userNames;

    public Participants(String names) {
        List<UserName> participantNames = splitNames(names);
        validateParticipantNumber(participantNames);
        this.userNames = participantNames;
    }

    private List<UserName> splitNames(String names) {
        validateDelimiter(names);
        String[] participantNames = names.split(USER_NAME_DELIMITER);
        return Arrays.stream(participantNames)
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .map(UserName::new)
                .collect(Collectors.toList());
    }

    private void validateDelimiter(String names) {
        if (!names.contains(USER_NAME_DELIMITER)) {
            throw new IllegalArgumentException("유효한 구분자가 포함되어 있지 않습니다");
        }
    }

    private void validateParticipantNumber(List<UserName> participantUserNames) {
        if (participantUserNames.size() < MINIMUM_OF_PARTICIPANT) {
            throw new IllegalArgumentException(String.format("참여 인원은 %d명 보다 많아야 합니다", MINIMUM_OF_PARTICIPANT));
        }
    }

    public List<UserName> fetchNames() {
        return Collections.unmodifiableList(userNames);
    }

    public int countParticipantPerson() {
        return userNames.size();
    }

    public String centerAlignedParticipantNames(int maxOutputNameLength) {
        return userNames.stream()
                .map(userName -> userName.centerAlignName(maxOutputNameLength))
                .collect(Collectors.joining(UserName.EMPTY_SPACE));
    }
}

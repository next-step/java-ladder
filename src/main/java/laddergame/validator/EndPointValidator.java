package laddergame.validator;

import laddergame.util.StringUtils;

import java.util.Optional;

public class EndPointValidator implements Validatable<String> {

    public static final int PARTICIPANT_MAXIMUM_NAME_LENGTH = 5;

    @Override
    public boolean isValid(String target) {
        return Optional.ofNullable(target)
                .filter(StringUtils::isNotEmpty)
                .filter(name -> name.length() <= PARTICIPANT_MAXIMUM_NAME_LENGTH)
                .isPresent();
    }

    @Override
    public String getInvalidMessage() {
        return "잘못된 이름입니다.";
    }

}
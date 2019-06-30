package ladder.domain.content.user;

import ladder.domain.constant.ErrorMessages;
import ladder.util.StringUtils;

public class Name {
    private static final String VALIDATION_REGEX = "^[A-Za-z0-9+]{1,5}$";
    private final String name;
    
    private Name(final String name) {
        this.name = name;    
    }
    public static Name newEnglishNumericOf(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_INPUT.message());
        }
        
        name = name.trim();
        if (!name.matches(VALIDATION_REGEX)) {
            throw new IllegalArgumentException(ErrorMessages.REQUIRE_NOT_KOREAN.message());
        }
        
        return new Name(name);
    }
}

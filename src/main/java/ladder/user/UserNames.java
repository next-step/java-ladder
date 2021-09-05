package ladder.user;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserNames {

    private static final String BLANK = "";
    private static final String NAMES_REGEX = "([a-zA-Z]+,*)*";
    private static final String DELIMITER = ",";
    private final Object names;

    public UserNames(String names) {
        isBlank(names);
        isDelimiterValid(names);
        this.names = userNames(names);
    }

    private List<UserName> userNames(String names) {
        return Arrays.stream(splitNames(names))
                .map(UserName::new)
                .collect(Collectors.toList());
    }

    private String[] splitNames(String names) {
        return names.trim().split(DELIMITER);
    }

    private void isBlank(String names) {
        if(names == null || BLANK.equals(names.trim())) {
            throw new IllegalArgumentException("이름들은 빈 값일 수 없습니다.");
        }
    }

    private void isDelimiterValid(String names) {
        if (!Pattern.matches(NAMES_REGEX, names)) {
           throw new IllegalArgumentException("이름은 ,로 구분되며, 이외의 구분자는 사용하실 수 없습니다.");
        }
    }


}

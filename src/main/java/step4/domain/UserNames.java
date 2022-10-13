package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserNames {

    private final List<UserName> userNames = new ArrayList<>();

    public UserNames(List<UserName> userNames) {
        validateUserNames(userNames);
        this.userNames.addAll(userNames);
    }

    private void validateUserNames(List<UserName> userNames) {
        validateIsEmpty(userNames);
        validateDuplicated(userNames);
    }

    private static void validateIsEmpty(List<UserName> userNames) {
        if (userNames == null || userNames.isEmpty()) {
            throw new IllegalArgumentException("userNames는 비어있을 수 없습니다.");
        }
    }

    private static void validateDuplicated(List<UserName> userNames) {
        if (userNames.stream().distinct().count() != userNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 존재할 수 없습니다.");
        }
    }

    public static UserNames from(List<String> userNames) {
        return new UserNames(userNames.stream()
            .map(UserName::new)
            .collect(Collectors.toList()));
    }

    public List<UserName> getUserNames() {
        return Collections.unmodifiableList(userNames);
    }

    public int size() {
        return userNames.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserNames)) {
            return false;
        }

        UserNames userNames1 = (UserNames) o;

        return userNames.equals(userNames1.userNames);
    }

    @Override
    public int hashCode() {
        return userNames.hashCode();
    }
}

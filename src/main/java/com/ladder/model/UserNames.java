package com.ladder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class UserNames {

    private static final String SEPARATOR_OF_USERNAME = ",";

    private List<UserName> userNames;

    private UserNames(List<UserName> userNames) {
        this.userNames = new ArrayList<>(userNames);
    }

    public static UserNames of(String names) {
        return Arrays.stream(names.split(SEPARATOR_OF_USERNAME))
                .map(UserName::of)
                .collect(collectingAndThen(toList(), UserNames::new));
    }

    List<UserName> getUserNames() {
        return Collections.unmodifiableList(userNames);
    }
}

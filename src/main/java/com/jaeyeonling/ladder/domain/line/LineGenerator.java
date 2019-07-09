package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.user.CountOfUsers;

@FunctionalInterface
public interface LineGenerator {

    Line generate(final CountOfUsers countOfUsers);
}

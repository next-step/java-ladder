package nextstep.ladder.entity;

import static nextstep.ladder.exception.UserExceptionMesssage.*;
import static nextstep.ladder.utils.StringUtils.*;

import nextstep.ladder.exception.UserException;

public class Prize {
	private final String name;

	public Prize(String name) {
		validatePrize(name);
		this.name = name;
	}

	private void validatePrize(String name){
		if (!(isNumeric(name) || "꽝".equals(name))) {
			throw new UserException(NOT_NUMERIC_OR_FALSY);
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "    " + this.name;
	}
}

package nextstep.ladder.model;

import nextstep.ladder.exceptions.MemberValidException;

public class Member {

	private static final int NAME_MAXIMUM_LENGTH = 5;
	private String name;

	public Member(String name) {
		validate(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void validate(String name) {
		if (name.length() > NAME_MAXIMUM_LENGTH) {
			throw new MemberValidException("참여자 이름은 " + NAME_MAXIMUM_LENGTH + "글자를 넘길수 없습니다.");
		}
	}
}

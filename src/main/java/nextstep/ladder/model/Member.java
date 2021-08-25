package nextstep.ladder.model;

import nextstep.ladder.exceptions.MemberValidException;

public class Member {

	private String name;

	public Member(String name) {
		validate(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void validate(String name) {
		if (name.length() > 5) {
			throw new MemberValidException("참여자 이름은 5글자를 넘길수 없습니다.");
		}
	}
}

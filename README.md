# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 요구사항 체크리스트
- [x] 참여할 사람 이름을 입력한다.
  - 이름은 ,로 구분한다.
  - 최대 5글자까지 부여할 수 있다. 6자 이상 입력 시, IllegalArgumentException 발생
- [x] 사다리 높이를 입력한다.
  - 높이는 양의 정수로 입력받는다. 그렇지 않으면, IllegalArgumentException 발생
- [x] 사람 이름을 출력한다.
  - 사람 이름의 `입력 가능 최대 글자 수 + 1`을 채울만큼 앞에 공백을 만들어 출력한다. (만약 사람 이름이 4면 앞의 공백 2개를 추가, 5이면 앞의 공백 1을 추가)
- [x] 사다리를 출력한다.
  - 높이는 '|', 가로 라인은 '-'로 표현한다.
  - 높이는 입력받은 수만큼 각 라인을 출력한다.
  - 가로라인 '-'은 이름의 최대 글자수 만큼 출력한다.
  - 이름의 최대 길이인 5자 만큼 공백을 출력한 이후에 각 라인을 출력한다.
- [x] 라인 한줄을 채운다. 
  - 랜덤으로 채우되 가로라인이 인접하게 채울수는 없다.
  - 라인 내, 가로라인의 개수는 `참가할 사람의 수 - 1`과 일치한다.
  - boolean 값이 들어갈 수 있으며 true는 가로 라인을 채운다는 의미이고 false는 채우지 않는다는 의미이다.
- [x] 높이를 채운다.
  - 총 라인의 수는 `입력받은 최대 사다리 높이`와 일치한다.
  - 참여할 사람이 1보다 작으면 IllegalArgumentException 발생
  - 사다리 최대 높이가 1보다 작으면 IllegalArgumentException 발생

### 추가 요구사항 체크리스트
- [x] 실행 결과를 입력한다.
  - 결과는 ,로 구분한다.
  - 빈값 입력 시 IllegalArgumentException 발생
  - 입력할 수 있는 문자는 `꽝`과 `숫자`로 제한한다. 그외 문자 입력 시 IllegalArgumentException 발생
  - 참여자 수와 실행결과 목록 수가 일치하지 않을 경우 IllegalArgumentException 발생
- [x] 결과를 보고 싶은 사람을 입력한다.
  - 없는 사람 입력 시 IllegalArgumentException 발생
  - 빈값 입력 시 IllegalArgumentException 발생
  - 개인 또는 all로만 입력 가능하다. (두명은 입력할 수 없다.)
- [x] `사다리 결과` 문자열을 출력한다.
- [x] 참여할 사람 이름 입력 시, 사람 이름은 "all"로 입력할 수 없도록 막는다.
- [x] 참여할 사람 이름 입력 시, 동명이인 안된다.
- [x] 실행 결과를 만든다.
- [x] 실행 결과를 출력한다.


## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)
  
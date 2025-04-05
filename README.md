# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 요구 사항
### 람다, 스트림, Optional
- 람다
  - [x] 람다 실습 1 - 익명 클래스를 람다로 전환
  - [x] 람다 실습 2 - 람다를 활용해 중복 제거
- 스트림
  - [x] StreamStudy 클래스의 sumOverThreeAndDouble 구현
  - [x] StreamStudy 클래스의 printLongestWordTop100 구현
- Optional
  - [x] 요구사항 1 - Optional을 활용해 조건에 따른 반환
  - [x] 요구사항 2 - Optional에서 값을 반환
  - [x] 요구사항 3 - Optional에서 exception 처리
  - [x] 요구사항 3 - Optional에서 exception 처리
- 리뷰
  - [x] 전체 테스트 코드 통과

### 사다리(생성)
- [x] 라인 길이를 전달받아 사다리 라인을 생성한다.
- [x] 각 사다리 라인은 이웃한 곳과 이어져있을 수 있다. 
- [x] 각 사다리 라인은 겹치지 않게 이어져 있어야 한다.
- ~~[x] 라인의 각 포인트는 왼쪽/오른쪽 연결 유무를 갖는다.~~
- [x] 라인의 각 포인트는 오른쪽 연결 유무만 갖는다.
- [x] 사다리 높이와 라인 길이를 전달받아 사다리를 생성한다.
- [x] 사람 이름은 최대 5글자까지만 가능하다.

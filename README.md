# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## Step1. 자바8 스트림, 람다, 옵셔널
### 실습1 - 람다
- [X] 익명 클래스를 람다로 전환하기
- [X] 람다를 활용해서 중복 제거하기
    - [X] 변경되는 부분을 인터페이스로 추출한다.
    - [X] 익명 클래스로 구현해본다.
    - [X] lambda로 바꿔본다.

### 실습2 - Stream
- [X] StreamStudy의 sumOverThreeAndDouble을 구현한다.
    - [X] 3을 넘는 숫자만 골라내도록 구현한다. (filter)
    - [X] 골라낸 숫자에 모두 2를 곱하도록 구현한다. (map)
    - [X] 골라낸 숫자에 2가 곱해진 값을 모두 더한다. (reduce)
- [X] printLongestWordTop100을 구현한다.
    - [X] 단어의 길이가 12자를 초과하는 단어만 추출한다.
    - [X] 긴 순서로 100개만 추려낸다.
    - [X] 추려낸 단어는 중복 없이 100개 단어여야 한다.
    - [X] 추려낸 단어를 모두 소문자로 바꾼 뒤 출력한다.

### 실습3 - Optional
- [X] ageIsInRange2를 optional, stream을 사용해서 UserTest를 모두 통과하도록 구현한다.
- [X] getUser 메서드를 stream, optional을 활용해 구현한다.
- [X] ExpressionTest가 통과하도록 stream을 이용해서 Expression의 of 메서드를 구현한다. 

### 피드백 반영
- [X] Lambda를 메서드당 들여쓰기 한 번으로 줄이도록 개선한다.
- [X] lambda limit 메서드를 통해 리스트 자르기를 대체한다.
- [X] 에러 발생 시 좀 더 정확한 메시지를 던지도록 개선한다.
- [ ] getter 대신 객체에게 메시지를 던질 수 있도록 개선한다.

# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

# STEP 1
* [X] 람다 실습 1 : 익명 클래스를 람다로 전환
* [X] 람다 실습 2 : 람다를 활용해 중복제거
* [X] Map, Reduce, Filter 실습 1 : 리스트 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합 구하기
* [X] Map, Reduce, Filter 실습 2 : printLongestWordTop100() 메서드를 구현
  * [X] 요구사항 1 : 단어의 길이가 12자를 초과하는 단어를 추출한다.
    * filter() 적용
  * [X] 요구사항 2 : 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
    * sorted() 적용 -> limit()으로 100개 추출
  * [X] 요구사항 3 : 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
    * distinct() 사용
  * [X] 요구사항 4 : 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한
    * map(String::toLowerCase) 적용 -> forEach(System.out::println) 으로 출
* [X] Optional 실습 1 : Optional을 활용해 조건에 따른 반환
* [X] Optional 실습 2 : Optional에서 값을 반환
* [X] Optional 실습 3 : Optional에서 exception 처리

# STEP 2
* [X] 참여할 사람 명단 입력받기
  * [X] 쉼표 구분자를 파싱하기
* [X] 최대 사다리 높이 입력받기
* [ ] 실행결과 출력하기
* [X] 사다리 만들기
  * [X] 사다리 한 줄(Line) 만들기
  * [X] 사다리 다리 구성하기 (Bridge)
    * [X] 캐시 전략 사용하기
  * [X] 사다리 다리 리스트 구성하기
# 사다리 게임

## 진행 방법

- 사다리 게임 게임 요구사항을 파악한다.
- 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
- 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
- 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

- [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

# TODO

## 람다

- 익명 클래스를 람다로 전환
- 람다를 활용해 중복 제거

## 스트림

- StreamStudyTest.sumOverThreeAndDouble()
- printLongestWordTop100() 메서드를 구현

## Optional

- Optional을 활용해 조건에 따른 반환
- Optional에서 값을 반환
- Optional에서 exception 처리

## 사다리 게임 기능 목록

1. 사용자 입력 처리
- [x] 참여자 이름 입력 받기 (쉼표로 구분)
- [x] 이름 유효성 검사 (최대 5글자)
- [x] 사다리 높이 입력 받기 (숫자)
2. 사다리 생성
- [x] 사다리 높이만큼 행 생성
- [x] 참여자 수에 맞게 열 생성
- [x] 랜덤으로 가로 연결선 생성
- [ ] 가로 연결선 겹치면 안됨
3. 사다리 출력
- [x] 참여자 이름 출력 (5자 기준 정렬)
- [x] 사다리 모양 출력 ("|", "-" 사용)


# 학습정리

### Collections.emptyList() vs new ArrayList()
https://velog.io/@ychxexn/Collections.emptyList-vs-new-ArrayList

5번 문제에서 미리 작성되어있던 Collections.emptyList()를 사용할때,
answer.add() 를 하면 오류가 난다.
이유는 Collections.emptyList() 는 final 타입 (상수) 이므로 변경이 불가능하기 때문이다.

그래서 객체의 값을 변경해야할 일이 있을 경우 new ArrayList()로 사용해야 한다.

### List.of() vs asList()

6번 문제에 List.of()가 사용된다.
List.of와 asList는 다음과 같이 사용 가능하다.

```java
List<String> list1 = Arrays.asList("a", "b", "c");
-> [a, b, c]
List<String> list2 = List.of("a", "b", "c");
-> [a, b, c]
```

- **Arrays.asList()** 의 리턴값은 ArraysList 인데,
    우리가 알고 있는 java.util.ArrayList 이 아니라 Arrays 클래스 내부의 ArrayList 이다.
    삽입, 삭제 등 구조적인 수정은 허용하지 않고 내부 값 수정만 허용한다.
- **List.of()** 는 List 형식을 반환하는데, 이는 AbstractImmutableList 추상클래스를 상속받아서,
    불변한 속성을 가지고 있어서 add, remove, set, replace, 모두 호출시 예외를 발생한다.

# int vs Integer

[벨로그 링크](https://velog.io/@hadoyaji/int%EC%99%80-Integer%EB%8A%94-%EB%AC%B4%EC%97%87%EC%9D%B4-%EB%8B%A4%EB%A5%B8%EA%B0%80)

![이미지](https://velog.velcdn.com/images%2Fhadoyaji%2Fpost%2F39b6ba49-ecc4-4886-a810-3923a0d07ebe%2F23233.jpg)
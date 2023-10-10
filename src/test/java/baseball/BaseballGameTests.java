package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

public class BaseballGameTests {
    @Test
    @DisplayName("컴퓨터가 랜덤으로 생성하는 숫자가 옳은지 검사하는 함수")
    void checkComputerNumber() {
        BaseballGame b = new BaseballGame();
        List<Integer> result = b.initComputerNumber();
        List<Integer> correctNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        assertThat(correctNumbers).containsAll(result);
        assertThat(result.size()).isEqualTo(3);
    }
}

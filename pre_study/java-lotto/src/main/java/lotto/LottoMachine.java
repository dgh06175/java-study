package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public ArrayList<Lotto> generateLotto(int lottoCount) {
        ArrayList<Lotto> lottoArray = new ArrayList<>(lottoCount);
        for(int i = 0; i<lottoCount; i++) {
            lottoArray.add(generateSingleLotto());
        }
        return lottoArray;
    }

    private Lotto generateSingleLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public void printLotto(ArrayList<Lotto> lottoArray) {
        for (Lotto lotto : lottoArray) {
            System.out.println(lotto.getNumbers());
        }
    }
}

package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validate2(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validate2(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contain(int num) {
        return numbers.contains(num);
    }

    public ArrayList<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public LottoRank match(Lotto matchLotto, int bonusNumber) {
        boolean isBonusMatch = matchLotto.contain(bonusNumber);
        int matchCount = 0;
        for (int num : matchLotto.getNumbers()) {
            if (numbers.contains(num)) matchCount++;
        }
        if (matchCount == 3) return LottoRank.FIFTH;
        if (matchCount == 4) return LottoRank.FORTH;
        if (matchCount == 5) {
            if (isBonusMatch) return LottoRank.SECOND;
            return LottoRank.THRID;
        }
        if (matchCount == 6) return LottoRank.FIRST;
        return LottoRank.NONE;
    }
}

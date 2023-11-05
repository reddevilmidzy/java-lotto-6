package lotto.model;

import java.util.List;

public enum LottoPrize {

    FIFTH_PLACE(3, false, 5_000, "3개 일치 (5,000원) - %s개%s"),
    FOURTH_PLACE(4, false, 50_000, "4개 일치 (50,000원) - %s개%s"),
    THIRD_PLACE(5, false, 1_500_000, "5개 일치 (1,500,000원) - %s개%s"),
    SECOND_PLACE(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %s개%s"),
    FIRST_PLACE(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - %s개%s");

    private final Integer match;
    private final Boolean isSameBonus;
    private final Integer prize;
    private final String message;

    LottoPrize(Integer match, Boolean isSameBonus, Integer prize, String message) {
        this.match = match;
        this.isSameBonus = isSameBonus;
        this.prize = prize;
        this.message = message;
    }

    public static LottoPrize from(Integer match, Boolean isSameBonus) {
        if (SECOND_PLACE.match.equals(match) && SECOND_PLACE.isSameBonus.equals(isSameBonus)) {
            return SECOND_PLACE;
        }
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize.match.equals(match)) {
                return prize;
            }
        }
        return null;
    }

    public static Long sum(List<LottoPrize> lottoPrizes) {
        return lottoPrizes.stream()
                .mapToLong(lotto -> lotto.prize)
                .sum();
    }

    public String getMessage() {
        return message;
    }
}

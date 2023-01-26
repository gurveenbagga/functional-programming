import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class TotalValuesExample {

    public static void main(String[] args) {

        final List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"),
                new BigDecimal("17"), new BigDecimal("20"),
                new BigDecimal("15"), new BigDecimal("18"),
                new BigDecimal("45"), new BigDecimal("12"));


        /* Imperative Style */
        /*BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;
        for (BigDecimal price: prices) {
            if(price.compareTo(BigDecimal.valueOf(20)) > 0) {
                totalOfDiscountedPrices = totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
            }
        }
        System.out.println(totalOfDiscountedPrices);*/

        /* Declarative Style */
        BigDecimal totalOfDiscountedPrices = prices.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(totalOfDiscountedPrices);

        /*
        1. Nicely composed, not cluttered
        2. Free of low-level operations
        3. Easier to enhance or change the logic
        4. Iteration controlled by a library of methods
        5. Efficient; lazy evaluation of loops
        6. Easier to parallelize where desired
        */
     }

}

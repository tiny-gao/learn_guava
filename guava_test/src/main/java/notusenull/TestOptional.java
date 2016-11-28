package notusenull;

import java.util.Optional;

/**
 * Created by gsd on 2016/11/28.
 */
public class TestOptional {
    public static void main(String[] args) {
        Optional<Integer> possible = Optional.of(4);
        possible.isPresent();
        possible.get();
    }
}

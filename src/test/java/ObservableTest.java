import io.reactivex.Observable;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ObservableTest {

  @Test
  void testArray(){

    List<String> results = new ArrayList<String>();
    Observable.just("howdy").subscribe(results::add);

    assertTrue(results.contains("howdy"));
    for (String s : results) {
      System.out.println(s);
    }
  }

  @Test
  void testList(){

    List<String> words = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog"
    );

    Observable.just(words).subscribe(System.out::println);
  }
}

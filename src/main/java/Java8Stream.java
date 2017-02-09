import java.util.Arrays;
import java.util.List;

/**
 * Created by nohsunghyun on 2017. 2. 9..
 */
public class Java8Stream
{

    public static void main(String[] args) {

        final List<String> names = Arrays.asList("Java", "C", "C++", "PHP", "Go");

        names.stream().filter(language -> language.contains("C")).forEach(System.out::println);

    }

}

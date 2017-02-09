import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class RxJava {

    public static void main(String[] args) {

        final List<String> list = Arrays.asList("Java", "C", "C++", "PHP", "Go");

        Observable.from(list)
                  .filter(s -> s.contains("C"))
                  .doOnNext(s -> System.out.println("doOnNext"))
                  .doOnRequest(s -> System.out.println("doOnRequest"))
                  .subscribe(System.out::println, System.out::println, ()->System.out.println("We are done!"));


    }

}

import rx.Observable;

public class RxJavaSample9 {

    public static void main(String[] args) {

        Observable.just("Hello, world!")
        .map(s-> s + "- Dan")
        .map(s-> s.hashCode())
        .map(s->Integer.toString(s))
        .subscribe(i -> System.out.println(i));

    }

}

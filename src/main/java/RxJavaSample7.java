import rx.Observable;
import rx.functions.Func1;

public class RxJavaSample7 {

    public static void main(String[] args) {

        Observable.just(("Hello, world!"))
        .map(s-> s.hashCode())
        .subscribe(i -> System.out.println(Integer.toString(i)));

    }

}

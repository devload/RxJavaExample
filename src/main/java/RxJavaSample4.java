import rx.Observable;
import rx.functions.Func1;

public class RxJavaSample4 {

    public static void main(String[] args) {

        Observable.just("Hello, world!")
        .map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s + " -Dan";
            }
        }).subscribe(s -> System.out.println(s));

    }

}

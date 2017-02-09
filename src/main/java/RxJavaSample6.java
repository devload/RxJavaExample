import rx.Observable;
import rx.functions.Func1;

public class RxJavaSample6 {

    public static void main(String[] args) {

        Observable.just(("Hello, world!"))
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return s.hashCode();
                    }
                })
                .subscribe(i -> System.out.println(Integer.toString(i)));

    }

}

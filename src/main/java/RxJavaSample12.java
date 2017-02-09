import rx.Observable;
import rx.functions.Func1;

import java.util.Arrays;
import java.util.List;

public class RxJavaSample12 {

    public static void main(String[] args) {

        query("Hello, world!")
                .flatMap(new Func1<List<String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(List<String> urls) {
                        return Observable.from(urls);
                    }
                })
                .subscribe(url -> System.out.println(url));

    }

    // Returns a List of website URLs based on a text search
    public static Observable<List<String>> query(String text) {
        return Observable.just(Arrays.asList("www.naver.com", "www.google.com", "www.kakao.com"));
    }

}

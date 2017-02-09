import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;

import java.util.Arrays;
import java.util.List;

public class RxJavaSample10 {

    public static void main(String[] args) {

        query("Hello, world!")
                .subscribe(urls -> {
                    for (String url : urls) {
                        System.out.println(url);
                    }
                });

    }

    // Returns a List of website URLs based on a text search
    public static Observable<List<String>> query(String text) {
        return Observable.just(Arrays.asList("www.naver.com", "www.google.com", "www.kakao.com"));
    }

}

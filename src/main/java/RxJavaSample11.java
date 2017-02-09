import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class RxJavaSample11 {

    public static void main(String[] args) {

        query("Hello, world!")
                .subscribe(urls -> {
                    Observable.from(urls)
                            .subscribe(url -> System.out.println(url));
                });

    }

    // Returns a List of website URLs based on a text search
    public static Observable<List<String>> query(String text) {
        return Observable.just(Arrays.asList("www.naver.com", "www.google.com", "www.kakao.com"));
    }

}

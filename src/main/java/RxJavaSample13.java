import rx.Observable;
import rx.functions.Func1;

import java.util.Arrays;
import java.util.List;

import static java.awt.SystemColor.text;

public class RxJavaSample13 {

    public static void main(String[] args) {

        query("Hello, world!")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String url) {
                        return getTitle(url);
                    }
                })
                .subscribe(title -> System.out.println(title));

    }

    // Returns a List of website URLs based on a text search
    public static Observable<List<String>> query(String text) {
        return Observable.just(Arrays.asList("www.naver.com", "www.google.com", "www.kakao.com"));
    }

    // Returns the title of a website, or null if 404
    public static Observable<String> getTitle(String URL) {
        return Observable.just("title");
    }

}

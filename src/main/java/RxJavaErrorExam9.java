import rx.Observable;
import rx.functions.Func1;

import java.util.concurrent.TimeUnit;

public class RxJavaErrorExam9 {

    public static void main(String[] args) {
        Observable
                .create((Observable.OnSubscribe<String>) subscriber -> {
                    log("subscribe");
                    subscriber.onNext("emit 1");
                    subscriber.onNext("emit 2");
                    subscriber.onError(new Throwable());
                })
                .retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
                    @Override
                    public Observable<?> call(final Observable<? extends Throwable> observable) {
                        return observable.flatMap(new Func1<Throwable, Observable<?>>() {
                            @Override
                            public Observable<?> call(Throwable throwable) {
                                return Observable.error(throwable);
                            }
                        });
                    }
                })
                .subscribe(
                        s -> log("on next: " + s),
                        throwable -> log("error:" + throwable),
                        () -> log("completed")
                );
    }

    public static void log(String message) {
        System.out.println(message);
    }
}

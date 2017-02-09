import rx.Observable;
import rx.functions.Func1;

public class RxJavaErrorExam3 {

    public static void main(String[] args) {
        Observable
                .create((Observable.OnSubscribe<String>) subscriber -> {
                    log("subscribe");
                    subscriber.onNext("emit 1");
                    subscriber.onNext("emit 2");
                    subscriber.onError(new Throwable());
                })
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends String>>() {
                    @Override
                    public Observable<? extends String> call(Throwable throwable) {
                        return Observable.from(new String[]{ "resume 1", "resume 2"});
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

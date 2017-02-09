import rx.Observable;

public class RxJavaErrorExam6 {

    public static void main(String[] args) {
        Observable
                .create((Observable.OnSubscribe<String>) subscriber -> {
                    log("subscribe");
                    subscriber.onNext("emit 1");
                    subscriber.onNext("emit 2");
                    subscriber.onError(new Throwable());
                })
                .retry(3)    //실행될때까지 재시도 , 재시도 카운트
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

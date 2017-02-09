import rx.Observable;
import rx.functions.Func2;

public class RxJavaErrorExam7 {

    public static void main(String[] args) {
        Observable
                .create((Observable.OnSubscribe<String>) subscriber -> {
                    log("subscribe");
                    subscriber.onNext("emit 1");
                    subscriber.onNext("emit 2");
                    subscriber.onError(new Throwable());
                })
                .retry(new Func2<Integer, Throwable, Boolean>() {
                    @Override
                    public Boolean call(Integer count, Throwable throwable) {
                        // 2번까지 무조건 retry 한다
                        if(count < 3){
                            return true;
                        }
                        // 그 이후는 IllegalStateException 의 경우일 때만 retry 한다
                        return throwable instanceof IllegalStateException;
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

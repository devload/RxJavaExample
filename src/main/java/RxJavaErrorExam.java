import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class RxJavaErrorExam {

    public static void main(String[] args) {
        Observable
                .create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        log("subscribe");
                        subscriber.onNext("emit 1");
                        subscriber.onNext("emit 2");
                        subscriber.onError(new Throwable());
                    }
                })
                .onErrorReturn(new Func1<Throwable, String>() {
                    @Override
                    public String call(Throwable throwable) {
                        return "return";
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        log("completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        log("error:" + e);
                    }

                    @Override
                    public void onNext(String s) {
                        log("on next: " + s);
                    }
                });
    }

    public static void log(String message) {
        System.out.println(message);
    }
}

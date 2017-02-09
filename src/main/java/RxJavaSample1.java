import rx.Observable;
import rx.Subscriber;

public class RxJavaSample1 {

    public static void main(String[] args) {

        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("Hello, world!");
                        sub.onCompleted();
                    }
                }
        );

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            public void onNext(String s) { System.out.println(s); }
            public void onCompleted() { }
            public void onError(Throwable e) { }
        };

        myObservable.subscribe(mySubscriber);


    }

}

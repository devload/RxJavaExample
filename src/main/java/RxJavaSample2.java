import rx.Observable;
import rx.Subscriber;

public class RxJavaSample2 {

    public static void main(String[] args) {

        Observable<String> myObservable = Observable.just("Hello World");

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            public void onNext(String s) { System.out.println(s); }
            public void onCompleted() { }
            public void onError(Throwable e) { }
        };

        myObservable.subscribe(mySubscriber);


    }

}

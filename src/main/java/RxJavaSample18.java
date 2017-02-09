import rx.Observable;
import rx.Subscriber;

import java.util.Arrays;
import java.util.List;

public class RxJavaSample18 {

    public static void main(String[] args) {

        Observable.just("Hello, world!")
                .map(s -> potentialException(s))
                .map(s -> anotherPotentialException(s))
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onNext(String s) { System.out.println(s); }

                    @Override
                    public void onCompleted() { System.out.println("Completed!"); }

                    @Override
                    public void onError(Throwable e) { System.out.println("Ouch!"); }
                });

    }

    private static String potentialException(String s) {
        return "potentialException - " + s;
    }

    private static String anotherPotentialException(String s) {
        return "anotherPotentialException - " + s;
    }
}

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Arrays;
import java.util.Stack;

public class ReactiveStreamSample {

    public static void main(String[] args) {

        Publisher publisher = new Publisher() {

            Stack stack;

            public void subscribe(final Subscriber subscriber) {

                stack = new Stack();

                for(int i = 0; i < 10 ; i++){
                    stack.push(i);
                }

                subscriber.onSubscribe(new Subscription() {
                    public void request(long l) {
                        System.out.println("request " + l);

                        if(l < 0) {
                            subscriber.onError(new Exception("  0 이상의 숫자를 넣어야 합니다"));
                            return;
                        }

                        for(int i = 1 ; i <= l ; i++) {

                            if(stack.empty()) {
                                subscriber.onComplete();
                                return;
                            }

                            subscriber.onNext(stack.pop());
                        }
                    }
                    public void cancel() {

                    }
                });
            }
        };

        Subscriber subscriber = new Subscriber() {

            Subscription subscription;

            public void onSubscribe(Subscription subscription) {

                this.subscription = subscription;

                subscription.request(1);

            }

            public void onNext(Object o) {
                System.out.println("    onNext - " + o);

                subscription.request(1);

            }

            public void onError(Throwable throwable) {
                System.out.println("    onError -" + throwable.getMessage());
            }

            public void onComplete() {
                System.out.println("    onComplete");
            }
        };

        publisher.subscribe(subscriber);


    }

}

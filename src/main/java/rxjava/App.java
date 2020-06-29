/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class App {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);

        Observer<Integer> observer = new Observer<Integer>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Started observing");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error: " + e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed observing");
            }
        };

        observable.subscribe(observer);
    }
}

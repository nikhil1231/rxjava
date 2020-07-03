/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package rxjava;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {

        PriceOracle oracle = new PriceOracle();

        // Fetch the latest price every second
        Observable<Double> prices = oracle.getPrices().getObservable().sample(1000, TimeUnit.MILLISECONDS);

        // Connect first observer
        Disposable d1 = prices.subscribe(System.out::println);

        pause(5000);

        d1.dispose();
        oracle.kill();
    }

    private static void pause(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

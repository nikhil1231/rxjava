package rxjava;

import java.util.*;

// Responsible for getting and storing price information
public class PriceOracle {
    private final int FETCH_DELAY = 100;

    private Timer timer;

    private ObservableList<Double> prices;
    private double price = 1000d;

    public PriceOracle() {

        prices = new ObservableList<>();

        // Set up timer to fetch new price every given interval
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getNextPrice();
            }
        }, 0, FETCH_DELAY);
    }

    public ObservableList<Double> getPrices() {
        return prices;
    }

    public void kill() {
        timer.cancel();
    }

    private void getNextPrice() {
        Random r = new Random();
        // Random price movement with slight uptrend
        price += r.nextInt(10) - 4;
        prices.add(price);
    }
}

package my.sample.jackson;

import java.util.List;

/**
 * Created by ltian on 6/3/2017.
 */
public class MyObjectContainer {
    private List<MyObject> myApps;

    public List<MyObject> getMyApps() {
        return myApps;
    }

    public void setMyApps(List<MyObject> myApps) {
        this.myApps = myApps;
    }
}

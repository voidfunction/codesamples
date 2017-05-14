import my.sample.httpcore.HttpCoreSample;

/**
 * Created by ltian on 5/14/2017.
 */
public class SampleMain {
    
    public static void main(String[] args) throws Exception {
        HttpCoreSample.MyHttpServerThread thread = new HttpCoreSample.MyHttpServerThread(8081);
        thread.setDaemon(false);
        thread.start();
    }
}

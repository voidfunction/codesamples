package my.sample.rxjava;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by ltian on 5/20/2017.
 */
public class RxOperation {
    // data sender
    private static Observable<String> sender = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hi，Weavey！");  //发送数据"Hi，Weavey！"
        }
    });

    // data receiver
    private static Observer<String> receiver = new Observer<String>() {
        @Override
        public void onCompleted() {
            //数据接收完成时调用
            int a = 1;
        }

        @Override
        public void onError(Throwable e) {
            //发生错误调用
            int a = 1;
        }

        @Override
        public void onNext(String s) {
            //正常接收数据调用
            System.out.print(s);  //将接收到来自sender的问候"Hi，Weavey！"
        }
    };

    public static void main(String[] args) {
        sender.subscribe(receiver);
    }
}

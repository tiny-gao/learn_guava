package concurrency;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static javafx.scene.input.KeyCode.V;

/**
 * Created by gsd on 2016/11/28.
 * 传统的future需要代码去等待返回，不断自己去get或者阻塞get
 * 其实我们更想要一个future执行完之后立马能够执行某操作
 */
public class TestListenableFuture {
    public void test() {
        ListenableFuture f = null;
        FutureCallback c=null;
        f.addListener(()->{

        }, Executors.newSingleThreadExecutor());

        /*FutureCallback
        onSuccess(V),在Future成功的时候执行
        onFailure(Throwable), 在Future失败的时候执行
        由Executors.newSingleThreadExecutor()线程来执行
        */
        //两个版本
        Futures.addCallback(f, c, Executors.newSingleThreadExecutor());
        //默认使用MoreExecutors.sameThreadExecutor()线程池
        Futures.addCallback(f, c);
    }

    //对比future
    public void compareFuture() {
        ExecutorService es = Executors.newCachedThreadPool();
        Future future =  es.submit(()->{});

        //装饰者模式
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture explosion = service.submit(()->{
        });

        Futures.addCallback(explosion, new FutureCallback() {
            @Override
            public void onSuccess(Object o) {
                //future成功了干
            }

            @Override
            public void onFailure(Throwable throwable) {
                //future失败了干
            }
        });
        }

    //你还可以查看其他方法哦
}

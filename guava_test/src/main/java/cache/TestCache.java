package cache;

import com.google.common.cache.CacheBuilder;

/**
 * Created by gsd on 2016/11/28.
 */
public class TestCache {
    public static void main(String[] args) {
       // CacheLoader通常只需要简单地实现V load(K key) throws Exception方法
       /* CacheBuilder.newBuilder().maximumSize(1000).build(
                new CacheLoader<Key, Graph>() {
                    public Graph load(Key key) throws Exception {
                        return createExpensiveGraph(key);
                    }
                }
        );*/
    }
    //提供了get方法，里面有key和callable
    //在整个加载方法完成前，缓存项相关的可观察状态都不会更改。
    // 这个方法简便地实现了模式"如果有缓存则返回；否则运算、缓存、然后返回"。
   /* public void test() {
        Cache<Key, Value> cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .build(); // look Ma, no CacheLoader
...
        try {
            // If the key wasn't in the "easy to compute" group, we need to
            // do things the hard way.
            cache.get(key, new Callable<Value>() {
                @Override
                public Value call() throws AnyException {
                    return doThingsTheHardWay(key);
                }
            });
        } catch (ExecutionException e) {
            throw new OtherException(e.getCause());
        }
    }*/

   //回收
   public void toHome() {

       //权重函数的实现 weigher里头
       //指定最大的权重值100000
      /* LoadingCache<Key, Graph> graphs = CacheBuilder.newBuilder()
               .maximumWeight(100000)
               .weigher(new Weigher<Key, Graph>() {
                   public int weigh(Key k, Graph g) {
                       return g.vertices().size();
                   }
               })
               .build(
                       new CacheLoader<Key, Graph>() {
                           public Graph load(Key key) { // no checked exception
                               return createExpensiveGraph(key);
                           }
                       });*/
   }
}

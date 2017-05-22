package my.sample.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import my.sample.common.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.ExecutionException;

public class LocalCache<K, V> {
    private LoadingCache<K, V> loadingCache = CacheBuilder.newBuilder()
            .initialCapacity(10)
            .maximumSize(30)
            .build(new CacheLoader<K, V>() {
                @Override
                @ParametersAreNonnullByDefault
                public V load(K key) throws Exception {
                    return null;
                }
            });

    public V getValue(@NotNull K key) throws ExecutionException {
        return loadingCache.get(key);
    }
}

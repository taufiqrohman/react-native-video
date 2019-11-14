package com.brentvatne.exoplayer;

import com.danikula.videocache.CacheListener;
import com.danikula.videocache.HttpProxyCacheServer;
import com.danikula.videocache.file.Md5FileNameGenerator;
import android.content.Context;

public class CacheManager {

    private Context context;
    private HttpProxyCacheServer proxyCacheServer;

    public CacheManager(Context context) {
        this.context = context;
    }

    private void createInstance() {
        proxyCacheServer = new HttpProxyCacheServer.Builder( context )
            .build();
    }

    public HttpProxyCacheServer getInstance() {
        if ( null == proxyCacheServer ) {
            createInstance();
        }

        return proxyCacheServer;
    }

    public String cache(String url) {
        String proxyUrl = getInstance().getProxy( url );
        return proxyUrl;
    }

}

package com.github.catvod.net;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class OkProxySelector extends ProxySelector {
    private Proxy proxy;

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public List<Proxy> select(URI uri) {
        List<Proxy> proxies = new ArrayList<>();
        if (proxy != null) {
            proxies.add(proxy);
        } else {
            proxies.add(Proxy.NO_PROXY);
        }
        return proxies;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
    }
}
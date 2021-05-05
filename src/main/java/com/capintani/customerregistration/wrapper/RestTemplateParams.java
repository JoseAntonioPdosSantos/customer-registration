package com.capintani.customerregistration.wrapper;

import java.util.Map;

public abstract class RestTemplateParams {

    private String scheme;
    private String host;
    private String path;
    private Map<String,Object> queryParam;

    public RestTemplateParams(String scheme, String host, String path) {
        this.scheme = scheme;
        this.host = host;
        this.path = path;
    }

    public RestTemplateParams(String scheme, String host, String path, Map<String,Object> queryParam) {
        this.scheme = scheme;
        this.host = host;
        this.path = path;
        this.queryParam = queryParam;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, Object> getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(Map<String, Object> queryParam) {
        this.queryParam = queryParam;
    }
}

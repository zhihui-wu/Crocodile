package com.wzh.crocodile.ex03_connector.connector;

import java.io.OutputStream;

/**
 * @Description: TODO
 * @Author: 吴智慧
 * @Date: 2019/11/9 10:47
 */
public class HttpRequest {

    private String requestUri;

    public HttpRequest(OutputStream output) {

    }

    public String getRequestUri() {
        return this.requestUri;
    }
}

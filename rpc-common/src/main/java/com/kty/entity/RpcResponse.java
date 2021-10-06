package com.kty.entity;

import lombok.Data;

/**
 * 封装 RPC 响应
 *
 * @author kty
 * @date 2021/9/17 12:31
 */
@Data
public class RpcResponse {

    /**
     * 标识对该 requestId 的请求进行响应
     */

    private String requestId;

    /**
     * 出错信息
     */
    private Exception exception;

    /**
     * 返回的结果
     */
    private Object result;

    public boolean hasException() {
        return exception != null;
    }

}

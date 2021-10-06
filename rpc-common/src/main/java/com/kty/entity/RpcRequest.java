package com.kty.entity;

import lombok.Data;

/**
 * 封装 RPC 请求
 *
 * @author kty
 * @date 2021/9/17 12:31
 */
@Data
public class RpcRequest {

    // 请求的 Id， 唯一标识该请求
    private String requestId;

    // 接口名称
    private String interfaceName;

    // 版本
    private String serviceVersion;

    // 方法名称
    private String methodName;

    // 参数类型
    private Class<?>[] parameterTypes;

    // 具体参数
    private Object[] parameters;
}

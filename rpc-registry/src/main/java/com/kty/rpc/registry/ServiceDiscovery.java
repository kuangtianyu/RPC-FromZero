package com.kty.rpc.registry;

/**
 * 服务发现接口
 * @author kty
 * @date 2021/9/17 14:50
 */
public interface ServiceDiscovery {

    /**
     * 根据服务名称查找服务地址
     * @param serviceName
     * @return
     */
    String discovery(String serviceName);
}

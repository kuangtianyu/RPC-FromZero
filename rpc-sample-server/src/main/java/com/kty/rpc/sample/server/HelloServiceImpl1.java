package com.kty.rpc.sample.server;

import com.kty.rpc.sample.api.HelloService;
import com.kty.rpc.server.RpcService;

/**
 * @author kty
 * @date 2021/9/18 8:50
 */
@RpcService(interfaceName =  HelloService.class)
public class HelloServiceImpl1 implements HelloService {

    @Override
    public String hello(String name) {
        return name + " Hello from " + "HelloServiceImpl1";
    }
}

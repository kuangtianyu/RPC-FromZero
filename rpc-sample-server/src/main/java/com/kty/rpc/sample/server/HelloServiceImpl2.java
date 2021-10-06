package com.kty.rpc.sample.server;

import com.kty.rpc.sample.api.HelloService;
import com.kty.rpc.server.RpcService;

/**
 * @author kty
 * @date 2021/9/18 8:50
 */
@RpcService(interfaceName = HelloService.class, serviceVersion = "helloServiceImpl2")
public class HelloServiceImpl2 implements HelloService {

    @Override
    public String hello(String name) {
        return name + " GoodBye from " + "HelloServiceImpl2" ;
    }
}
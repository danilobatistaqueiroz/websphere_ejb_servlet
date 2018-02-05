package com.labs;

import javax.ejb.Remote;

@Remote
public interface HelloWorldRemote {
    public String sayHello(String name);
}


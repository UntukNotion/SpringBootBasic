package com.dyonestrankers.springbasic.data;

public class FooBar {

    private Foo foo;

    private Bar bar;

    public FooBar(Foo foo, Bar bar) {
        this.foo = foo;
        this.bar = bar;
    }

    public Foo getFoo() {
        return this.foo;
    }

    public Bar getBar() {
        return this.bar;
    }
}

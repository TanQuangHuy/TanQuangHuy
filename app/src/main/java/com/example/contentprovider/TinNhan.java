package com.example.contentprovider;

import java.io.Serializable;

public class TinNhan implements Serializable {
    private String address;
    private String body;

    public TinNhan(String address, String body) {
        this.address = address;
        this.body = body;
    }

    public String address() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String body() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return
                "From='" + address + '\'' +
                ", Mess='" + body + '\''  ;

    }
}

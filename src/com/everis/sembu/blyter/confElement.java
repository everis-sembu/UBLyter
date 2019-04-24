package com.everis.sembu.blyter;


import java.util.HashMap;

class sym {

    private String
            key = null,
            value = null,
            description = null,
            symbol = null,
            type = null;

}

public class confElement {

    protected HashMap<String, sym>
            distribution = null,
            variables    = null,
            input        = null,
            output       = null;
}

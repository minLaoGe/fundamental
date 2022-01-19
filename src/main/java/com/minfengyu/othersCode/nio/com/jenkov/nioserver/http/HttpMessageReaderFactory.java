package com.minfengyu.othersCode.nio.com.jenkov.nioserver.http;

import com.minfengyu.othersCode.nio.com.jenkov.nioserver.IMessageReader;
import com.minfengyu.othersCode.nio.com.jenkov.nioserver.IMessageReaderFactory;

/**
 * Created by jjenkov on 18-10-2015.
 */
public class HttpMessageReaderFactory implements IMessageReaderFactory {

    public HttpMessageReaderFactory() {
    }

    @Override
    public IMessageReader createMessageReader() {
        return new HttpMessageReader();
    }
}

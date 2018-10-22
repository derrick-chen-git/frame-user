package com.frame.dev.web.message.channel.input;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface TestInput{
    String TEST1_INPUT = "test1-input";

    @Input("test1-input")
    SubscribableChannel test1Input();
}

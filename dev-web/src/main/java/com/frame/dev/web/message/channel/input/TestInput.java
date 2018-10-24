package com.frame.dev.web.message.channel.input;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface TestInput{
    String TEST1_INPUT = "test1-input";
    String TEST2_INPUT = "test2-input";

    //String TEST1_INPUT_DLQ = "test2-input-dlq";

    @Input("test1-input")
    SubscribableChannel test1Input();
    @Input("test2-input")
    SubscribableChannel test2Input();
   /* @Input(TEST1_INPUT_DLQ)
    SubscribableChannel test2InputDlq();*/
}

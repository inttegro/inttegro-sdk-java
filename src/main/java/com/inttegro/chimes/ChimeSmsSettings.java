package com.inttegro.chimes;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class ChimeSmsSettings {
    @JsonProperty("default_sender")
    public String defaultSender;
    @JsonProperty("min_sender_char_len")
    public int minSenderCharLen;
    @JsonProperty("max_sender_char_len")
    public int maxSenderCharLen;
}

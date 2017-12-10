package com.gordeev.datastructures.loganalyzer;

import java.time.LocalDateTime;
import java.util.Date;

public class LogToken {
    //LocalDateTime
    Date time;
    HttpMethod method;
    String message;
}

enum HttpMethod { GET, POST }

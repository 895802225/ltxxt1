package com.test.service;

import com.test.common.ServerReponse;
import com.test.pojo.Print;

public interface IPrintService {
    ServerReponse insert(Print print);
}

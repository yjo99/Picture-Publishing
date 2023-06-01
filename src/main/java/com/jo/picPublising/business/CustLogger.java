package com.jo.picPublising.business;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;

@Log4j2
@Data
public class CustLogger {
    public static final org.slf4j.Logger loog = LoggerFactory.getLogger(CustLogger.class);
}

package com.netcracker.sd4.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public enum Company {
        EBAY(30), PAYPAL(10), GOOGLE(15), YAHOO(20), ATT(25);
        private int value;

        Company(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args){
        LOGGER.info("Hello world!");
        LOGGER.info(String.valueOf(Company.EBAY));
        LOGGER.info(String.valueOf(Company.ATT.value));
    }
}

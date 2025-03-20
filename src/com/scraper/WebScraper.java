package com.scraper;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class WebScraper {
    protected String url;

    public WebScraper(String url) {
        this.url = url;
    }

    public abstract void scrape();
}
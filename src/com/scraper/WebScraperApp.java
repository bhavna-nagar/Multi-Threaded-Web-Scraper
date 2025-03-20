package com.scraper;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebScraperApp {
    public static void main(String[] args) {
        String[] urls = {
            "https://www.example.com",
            "https://www.wikipedia.org",
            "https://www.github.com"
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (String url : urls) {
            executor.execute(new MultiThreadedScraper(url));
        }
        executor.shutdown();
    }
}
package com.scraper;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MultiThreadedScraper extends WebScraper implements Runnable {
    public MultiThreadedScraper(String url) {
        super(url);
    }

    @Override
    public void scrape() {
        try {
            URL website = new URL(url);
            Scanner scanner = new Scanner(website.openStream());
            StringBuilder content = new StringBuilder();
            while (scanner.hasNext()) {
                content.append(scanner.nextLine());
            }
            scanner.close();

            // Extract title using regex
            Pattern pattern = Pattern.compile("<title>(.*?)</title>");
            Matcher matcher = pattern.matcher(content.toString());
            if (matcher.find()) {
                System.out.println("Page Title from " + url + " : " + matcher.group(1));
            } else {
                System.out.println("Title not found for " + url);
            }
        } catch (IOException e) {
            System.out.println("Error scraping " + url + " : " + e.getMessage());
        }
    }

    @Override
    public void run() {
        scrape();
    }
}

package service;

import model.WebLogAnalyzerModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebService {
    private static final Logger log = Logger.getLogger(WebLogAnalyzerExam.class.getName());
    private static final Pattern PATTERN_IP_ADDRESS = Pattern.compile("\\d\\.\\d\\.\\d\\.\\d");
    private static final Pattern PATTERN_USERNAME = Pattern.compile(".+");
    private static final Pattern PATTERN_REQUEST_TIME = Pattern.compile("\\[\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}]");
    private static final Pattern PATTERN_URL_HTTP = Pattern.compile("\\[[A-Z]*/[a-z]*/[a-z]*\\s\\d{3}");

    static {
        try {
            FileHandler handler = new FileHandler("errors/error.txt");
            handler.setLevel(Level.ALL);
            log.addHandler(handler);
        } catch (IOException e) {
            log.severe(e.getMessage());
        }
    }

    private WebLogAnalyzerModel webLog;
    public List<WebLogAnalyzerModel> getWeb (String filePath){
        List<WebLogAnalyzerModel> web = new ArrayList<>();
        BufferedReader bf;

        try {
            bf = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line= bf.readLine())!=null){
                Matcher matcher1 = PATTERN_USERNAME.matcher(line);
                Matcher matcher2 = PATTERN_IP_ADDRESS.matcher(line);
                Matcher matcher3 = PATTERN_REQUEST_TIME.matcher(line);
                Matcher matcher4 = PATTERN_URL_HTTP.matcher(line);
                if (matcher1.find() && matcher2.find() && matcher3.find() && matcher3.find()){
                    web.add(new WebLogAnalyzerModel(matcher1.group(), matcher2.group(), matcher3.group(), matcher4.group()));
                }else {
                    log.severe("Error line");
                }
            }
        } catch (IOException e) {
            log.severe(e.getMessage());
        }
        return web;

    }


}

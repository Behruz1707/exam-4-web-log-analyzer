package service;

import model.WebLogAnalyzerModel;

import java.io.IOException;
import java.util.List;

public class WebLogAnalyzerExam {
    public static void main(String[] args){
        WebService webService = new WebService();
        List<WebLogAnalyzerModel> list = webService.getWeb("veb-server/access.txt");
        for (WebLogAnalyzerModel webLogAnalyzerModel : list) {
            System.out.println(webLogAnalyzerModel);
        }
    }
}
package model;

public class WebLogAnalyzerModel {
    private String user;
    private String ipAddress;
    private String requestTime;
    private String urlHttp;

    public WebLogAnalyzerModel(String user, String ipAddress, String requestTime, String urlHttp) {
        this.user = user;
        this.ipAddress = ipAddress;
        this.requestTime = requestTime;
        this.urlHttp = urlHttp;
    }

    @Override
    public String toString() {
        return "WebLogAnalyzerModel{" +
                "user='" + user + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", requestTime='" + requestTime + '\'' +
                ", urlHttp='" + urlHttp + '\'' +
                '}';
    }
}

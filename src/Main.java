public class Main {

    public static void main(String[] args) {
        GoEuroApiClient apiClient = new GoEuroApiClient();
        System.out.println(apiClient.getApiUrl());
        apiClient = new GoEuroApiClient("www.google.de");
        System.out.println(apiClient.getApiUrl());
    }
}

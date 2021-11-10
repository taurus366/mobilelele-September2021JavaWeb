package bg.softuni.mobilelele.data.model.view;

public class StatsView {
    private int authRequests;
    private int anonymousRequests;

    public StatsView(int authRequests, int anonymousRequests) {
        this.authRequests = authRequests;
        this.anonymousRequests = anonymousRequests;
    }

    public int getTotalRequests() {
        return getAnonymousRequests() + getAuthRequests();
    }

    public int getAuthRequests() {
        return authRequests;
    }

    public StatsView setAuthRequests(int authRequests) {
        this.authRequests = authRequests;
        return this;
    }

    public int getAnonymousRequests() {
        return anonymousRequests;
    }

    public StatsView setAnonymousRequests(int anonymousRequests) {
        this.anonymousRequests = anonymousRequests;
        return this;
    }
}

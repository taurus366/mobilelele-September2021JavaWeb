package bg.softuni.mobilelele.data.service;

import bg.softuni.mobilelele.data.model.view.StatsView;

public interface StatsService {
    void onRequest();
    StatsView getStats();
}

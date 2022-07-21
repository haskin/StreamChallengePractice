package org.example;

import org.example.io.StatisticsOutputService;
import org.example.io.TextInputService;
import org.example.statistics.TextStatisticsService;
import org.example.statistics.model.TextStatistics;

public class Processor {
    private TextInputService textInputService;
    private StatisticsOutputService statisticsOutputService;
    private TextStatisticsService textStatisticsService;

    public Processor(TextInputService textInputService, StatisticsOutputService statisticsOutputService,
            TextStatisticsService textStatisticsService) {
        this.textInputService = textInputService;
        this.statisticsOutputService = statisticsOutputService;
        this.textStatisticsService = textStatisticsService;
    }

    /**
     * This should just read in text
     * Get the statistics
     * Output the statistics
     */
    public void process() {
        // TODO
        String text = textInputService.getText();
        TextStatistics textStatistics = textStatisticsService.getStatistics(text);
        statisticsOutputService.save(textStatistics);
    }
}

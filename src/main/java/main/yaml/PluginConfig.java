package main.yaml;

public final class PluginConfig
        extends PluginYamlObject {

    public final static String DEATH_TITLE_PATH = "DeadTitle";
    public final static String DEATH_SUBTITLE_PATH = "DeadSubTitle";
    public final static String SCORE_MESSAGE = "ScoreMessage";
    public final static String RELOAD_MESSAGE = "ReloadMessage";

    public PluginConfig() {
        super("Config.yml");
    }

    public String getDeadTitleMessage() {
        final String titleMessage = this.configuration.getString(PluginConfig.DEATH_TITLE_PATH);

        if (titleMessage != null)
            return titleMessage;
        return "ERROR";
    }

    public String getDeadSubTitle() {
        final String subTitleMessage = this.configuration.getString(PluginConfig.DEATH_SUBTITLE_PATH);

        if (subTitleMessage != null)
            return subTitleMessage;

        return "ERROR";
    }

    public String getScoreMessage() {
        final String scoreMessage = this.configuration.getString(PluginConfig.SCORE_MESSAGE);

        if (scoreMessage != null)
            return scoreMessage;

        return "ERROR";
    }

    public String getReloadMessage() {
        final String reloadMessage = this.configuration.getString(PluginConfig.RELOAD_MESSAGE);

        if (reloadMessage != null)
            return reloadMessage;

        return "ERROR";
    }

    public int getScore() {
        return this.configuration.getInt("Source");
    }

}

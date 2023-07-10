package ru.sonyabeldy.dictionary.dictionarywebapp.models;

public class SprintTask {

    private String originText;
    private String translatedText;
    private boolean isRight;

    private int id;

    public SprintTask(int id, String originText, String translatedText, boolean isRight) {
        this.originText = originText;
        this.translatedText = translatedText;
        this.isRight = isRight;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginText() {
        return originText;
    }

    public void setOriginText(String originText) {
        this.originText = originText;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    @Override
    public String toString() {
        return "SprintTask{" +
                "originText='" + originText + '\'' +
                ", translatedText='" + translatedText + '\'' +
                ", isRight=" + isRight +
                ", id=" + id +
                '}';
    }
}

package fr.caensup.sio.demo.models;

public class AppMessage {
    private int code;
    private String title;
    private String description;
    private String icon;
    private String color;

    public AppMessage(String title, String description, String icon, String color) {
        this.code = hashCode();
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.color = color;
    }

    public AppMessage(){
        this("Titre...", "Description...", "info", "blue");
    }

    public int getCode(){
        return code;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}

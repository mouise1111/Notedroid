package be.ehb.notedroid.data;

import java.util.Date;

public class Note {

    private static volatile Note instance;
    private String title, content;
    private Date date, modifiedDate;

    public Note(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.modifiedDate = date;
    }

    private static Note getInstance(String title, String content, Date date){
        Note result = instance;
        if(result ==null){
            synchronized (Note.class){
                result = instance;
                if (result==null){
                    instance = result = new Note(title, content,date);
                }
            }
        }
        return result;
    }

    //region getters and setters
    public static Note getInstance() {
        return instance;
    }

    public static void setInstance(Note instance) {
        Note.instance = instance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    //endregion
}

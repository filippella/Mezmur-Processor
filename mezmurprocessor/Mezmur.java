/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mezmurprocessor;

/**
 *
 * @author Filippo
 */
public class Mezmur {
    
    private String mid;
    private String title;
    private String text;
    private String lmodified;
    private String modifiedby;
    private String active;
    private String uploadby;
    private String source;
    private String note;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLmodified() {
        return lmodified;
    }

    public void setLmodified(String lmodified) {
        this.lmodified = lmodified;
    }

    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getUploadby() {
        return uploadby;
    }

    public void setUploadby(String uploadby) {
        this.uploadby = uploadby;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

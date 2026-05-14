package com.fongmi.android.tv.bean;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "keep")
public class Keep {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String pic;
    private String url;
    private String siteId;
    private long time;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPic() { return pic; }
    public void setPic(String pic) { this.pic = pic; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getSiteId() { return siteId; }
    public void setSiteId(String siteId) { this.siteId = siteId; }
    public long getTime() { return time; }
    public void setTime(long time) { this.time = time; }
}
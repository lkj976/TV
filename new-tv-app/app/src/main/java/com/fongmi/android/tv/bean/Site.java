package com.fongmi.android.tv.bean;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "site")
public class Site {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String url;
    private String ext;
    private String key;
    private int sort;
    private boolean enabled;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getExt() { return ext; }
    public void setExt(String ext) { this.ext = ext; }
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }
    public int getSort() { return sort; }
    public void setSort(int sort) { this.sort = sort; }
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
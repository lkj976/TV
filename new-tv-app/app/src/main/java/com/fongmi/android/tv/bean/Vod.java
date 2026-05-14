package com.fongmi.android.tv.bean;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "vod")
public class Vod {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String pic;
    private String url;
    private String remark;
    private String siteId;
    private String typeId;
    private int duration;
    private long updateTime;
    @Ignore
    private List<Episode> episodes;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPic() { return pic; }
    public void setPic(String pic) { this.pic = pic; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public String getSiteId() { return siteId; }
    public void setSiteId(String siteId) { this.siteId = siteId; }
    public String getTypeId() { return typeId; }
    public void setTypeId(String typeId) { this.typeId = typeId; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public long getUpdateTime() { return updateTime; }
    public void setUpdateTime(long updateTime) { this.updateTime = updateTime; }
    public List<Episode> getEpisodes() { return episodes; }
    public void setEpisodes(List<Episode> episodes) { this.episodes = episodes; }
}
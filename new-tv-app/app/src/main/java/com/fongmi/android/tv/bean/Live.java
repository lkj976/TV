package com.fongmi.android.tv.bean;

public class Live {
    private String id;
    private String name;
    private String pic;
    private String url;
    private String groupId;
    private boolean live;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPic() { return pic; }
    public void setPic(String pic) { this.pic = pic; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getGroupId() { return groupId; }
    public void setGroupId(String groupId) { this.groupId = groupId; }
    public boolean isLive() { return live; }
    public void setLive(boolean live) { this.live = live; }
}
package com.example.day01_c;

public class Userinfo {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getHitokoto() {
        return hitokoto;
    }

    public void setHitokoto(String hitokoto) {
        this.hitokoto = hitokoto;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom_who() {
        return from_who;
    }

    public void setFrom_who(String from_who) {
        this.from_who = from_who;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreator_uid() {
        return creator_uid;
    }

    public void setCreator_uid(String creator_uid) {
        this.creator_uid = creator_uid;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getCommit_from() {
        return commit_from;
    }

    public void setCommit_from(String commit_from) {
        this.commit_from = commit_from;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Userinfo(){
        super();
    }

    private String id,uuid,hitokoto,type,from,from_who,creator,creator_uid,reviewer,commit_from,created_at,length;
}

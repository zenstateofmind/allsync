package com.jonikhilshi.allsync;

import com.google.gson.annotations.SerializedName;

public class TwitterListInfo {

    @SerializedName("id")
    public final Long id;

    @SerializedName("name")
    public final String name;

    @SerializedName("slug")
    public final String slug;

    @SerializedName("uri")
    public final String uri;

    public TwitterListInfo(Long id, String name, String slug, String uri) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.uri = uri;
    }

}

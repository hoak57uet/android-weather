
package com.gem.weather.rest.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CloudsDTO {

    @SerializedName("all")
    @Expose
    private Integer all;

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    public CloudsDTO withAll(Integer all) {
        this.all = all;
        return this;
    }

}

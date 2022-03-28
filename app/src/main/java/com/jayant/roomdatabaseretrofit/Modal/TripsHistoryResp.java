package com.jayant.roomdatabaseretrofit.Modal;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "trip_history", indices = @Index(value = {"id"},unique = true))
public class TripsHistoryResp
{
    @PrimaryKey(autoGenerate = true)
    private int tripsId;
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    private Long id;
    @ColumnInfo(name = "start_time")
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @ColumnInfo(name = "end_time")
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("status")
    @Expose
    private String status;
    @ColumnInfo(name = "service_type")
    @SerializedName("serviceType")
    @Expose
    private String serviceType;
    @ColumnInfo(name = "start_location_city")
    @SerializedName("startLocationCity")
    @Expose
    private String startLocationCity;
    @ColumnInfo(name = "end_location_city")
    @SerializedName("endlocationCity")
    @Expose
    private String endlocationCity;
    @SerializedName("scheduleId")
    @Expose
    private Long scheduleId;
    @ColumnInfo(name = "estimated_price")
    @SerializedName("estimatedPrice")
    @Expose
    private Double estimatedPrice;



    //public TripsHistoryResp

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTripsId() {
        return tripsId;
    }

    public void setTripsId(int tripsId) {
        this.tripsId = tripsId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getStartLocationCity() {
        return startLocationCity;
    }

    public void setStartLocationCity(String startLocationCity) {
        this.startLocationCity = startLocationCity;
    }

    public String getEndlocationCity() {
        return endlocationCity;
    }

    public void setEndlocationCity(String endlocationCity) {
        this.endlocationCity = endlocationCity;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Double getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(Double estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    @Override
    public String toString() {
        return "TripsHistoryResp{" +
                "tripsId=" + tripsId +
                ", id=" + id +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", status='" + status + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", startLocationCity='" + startLocationCity + '\'' +
                ", endlocationCity='" + endlocationCity + '\'' +
                ", scheduleId=" + scheduleId +
                ", estimatedPrice=" + estimatedPrice +
                '}';
    }

    public TripsHistoryResp(Long id, String startTime, String endTime, String status) {
        this.tripsId = tripsId;
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.serviceType = serviceType;
        this.startLocationCity = startLocationCity;
        this.endlocationCity = endlocationCity;
        this.scheduleId = scheduleId;
        this.estimatedPrice = estimatedPrice;
    }
}

package com.myadream.app.qiYang.entity.dto;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "qy_member_authorize_record", schema = "qiyang", catalog = "")
public class QyMemberAuthorizeRecordEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "member_id", nullable = false)
    private int memberId;
    @Basic
    @Column(name = "channel", nullable = false, length = 32)
    private String channel;
    @Basic
    @Column(name = "device", nullable = false, length = 32)
    private String device;
    @Basic
    @Column(name = "device_detail", nullable = false, length = 32)
    private String deviceDetail;
    @Basic
    @Column(name = "ipv4", nullable = false, length = 64)
    private String ipv4;
    @Basic
    @Column(name = "ipv6", nullable = false, length = 128)
    private String ipv6;
    @Basic
    @Column(name = "snapshot", nullable = true, length = 256)
    private String snapshot;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDeviceDetail() {
        return deviceDetail;
    }

    public void setDeviceDetail(String deviceDetail) {
        this.deviceDetail = deviceDetail;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public String getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}

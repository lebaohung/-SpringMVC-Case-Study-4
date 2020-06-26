package com.codegym.cms.model.admin;

import org.springframework.web.multipart.MultipartFile;


public class AvatarUpload {
    private Long id;
    private MultipartFile avatar;
    public AvatarUpload() {
    }

    public AvatarUpload(Long id, MultipartFile avatar) {
        this.id = id;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}

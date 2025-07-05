package com.kma.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;

@Data
public class answerRequestDTO {

    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd")  // Định dạng ngày tháng năm
    private Date createAt;
    private String userId;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}

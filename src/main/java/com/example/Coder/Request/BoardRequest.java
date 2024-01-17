package com.example.Coder.Request;

import lombok.Data;

@Data
public class BoardRequest {
    private String title;
    private String description;
    private Boolean favorite;
    private Boolean archive;

}

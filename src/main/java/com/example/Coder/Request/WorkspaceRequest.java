package com.example.Coder.Request;

import lombok.Data;

@Data
public class WorkspaceRequest {
    private String title;
    private String description;
    private Boolean isPrivate;

}

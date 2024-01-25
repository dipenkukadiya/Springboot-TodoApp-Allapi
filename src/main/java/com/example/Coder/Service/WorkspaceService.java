package com.example.Coder.Service;

import java.util.List;

import com.example.Coder.DTO.WorkspaceDTO;
// import com.example.Coder.Entity.Board;
// import com.example.Coder.Entity.Workspace;
// import com.example.Coder.Request.BoardRequest;
import com.example.Coder.Request.WorkspaceRequest;

public interface WorkspaceService {

       List<WorkspaceDTO> getAllWorkspaces();

       void addWorkspace(WorkspaceRequest workspaceRequest);

       WorkspaceDTO getWorkspace(Long workspaceId);

       void updateWorkspace(WorkspaceRequest workspaceRequest, Long workspaceId);

       void removeWorkspace(Long workspaceId);

       void toggleIsprivacy(Long workspaceId);

}

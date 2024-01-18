package com.example.Coder.Service;

import java.util.List;

// import com.example.Coder.Entity.Board;
import com.example.Coder.Entity.Workspace;
// import com.example.Coder.Request.BoardRequest;
import com.example.Coder.Request.WorkspaceRequest;

public interface WorkspaceService {

       

       List<Workspace> getAllWorkspaces();

       void addWorkspace(WorkspaceRequest workspaceRequest);

       Workspace getWorkspace(Long workspace_id);

       void updateWorkspace(WorkspaceRequest workspaceRequest, Long workspace_id);

       void removeWorkspace(Long workspace_id);

       void toggleIsprivacy(Long workspace_id);

}  


       


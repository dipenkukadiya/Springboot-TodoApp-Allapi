package com.example.Coder.Service;



import java.util.List;

import com.example.Coder.Entity.Workspace;


public interface WorkspaceService {
    
       List<Workspace> getAllWorkspaces();
       void addWorkspace(Workspace workspace);
       Workspace getWorkspace(Long workspace_id);
       void updateWorkspace(Workspace workspace, Long workspace_id);
       void removeWorkspace(Long workspace_id);
       void toggleIsprivacy(Long workspace_id);



}

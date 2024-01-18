package com.example.Coder.Service.impl;

// import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.example.Coder.Entity.Board;
import com.example.Coder.Entity.Workspace;
// import com.example.Coder.Repository.BoardRepo;
import com.example.Coder.Repository.WorkspaceRepo;
// import com.example.Coder.Request.BoardRequest;
import com.example.Coder.Request.WorkspaceRequest;
import com.example.Coder.Service.WorkspaceService;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {

    @Autowired
    private WorkspaceRepo workspaceRepo;

    // @Autowired
    // private BoardRepo boardRepo;

    @Override
    public List<Workspace> getAllWorkspaces() {
        return workspaceRepo.findAll();
    }

    @Override
    public void addWorkspace(WorkspaceRequest workspaceRequest) {
        Workspace workspace = new Workspace();
        workspace.setTitle(workspaceRequest.getTitle());
        workspace.setDescription(workspaceRequest.getDescription());
        workspace.setIsPrivate(workspaceRequest.getIsPrivate());
        workspaceRepo.save(workspace);
    }

    @Override
    public Workspace getWorkspace(Long workspace_id) {

        return workspaceRepo.findById(workspace_id).get();
    }

    @Override
    public void updateWorkspace(WorkspaceRequest workspaceRequest, Long workspace_id) {
        Workspace workspace = workspaceRepo.findById(workspace_id).orElse(null);
        if (workspace != null) {
            workspace.setTitle(workspaceRequest.getTitle());
            workspace.setDescription(workspaceRequest.getDescription());
            workspace.setIsPrivate(workspaceRequest.getIsPrivate());
            workspaceRepo.save(workspace);
        }
    }

    @Override
    public void removeWorkspace(Long workspace_id) {
        workspaceRepo.deleteById(workspace_id);
    }

    @Override
    public void toggleIsprivacy(Long workspace_id) {
        Workspace workspace = workspaceRepo.findById(workspace_id).orElse(null);
        if (workspace != null) {
            workspace.setIsPrivate(!workspace.getIsPrivate());
            workspaceRepo.save(workspace);
        }
    }
}


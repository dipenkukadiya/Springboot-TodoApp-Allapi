package com.example.Coder.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Coder.Entity.Workspace;
import com.example.Coder.Repository.WorkspaceRepo;
import com.example.Coder.Service.WorkspaceService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {
    @Autowired
    WorkspaceRepo workspaceRepo;

    @Override
    public List<Workspace> getAllWorkspaces() {
        return workspaceRepo.findAll();
    }

    @Override
    public void addWorkspace(Workspace workspace) {
        workspaceRepo.save(workspace);
    }

    @Override
    public Workspace getWorkspace(Long workspace_id) {
        return workspaceRepo.findById(workspace_id).get();
    }

    @Override
    public void updateWorkspace(Workspace workspace, Long workspaceId) {
        Workspace existingWorkspace = workspaceRepo.findById(workspaceId)
                .orElseThrow(() -> new EntityNotFoundException("Workspace not found with id: " + workspaceId));

        existingWorkspace.setTitle(workspace.getTitle());
        existingWorkspace.setDescription(workspace.getDescription());
        existingWorkspace.setIsPrivate(workspace.getIsPrivate());

        workspaceRepo.save(existingWorkspace);

    }

    @Override
    public void removeWorkspace(Long workspaceId) {
        workspaceRepo.deleteById(workspaceId);
    }

    @Override
    public void toggleIsprivacy(Long workspace_id) {
        Workspace workspace = workspaceRepo.findById(workspace_id)
                .orElseThrow(() -> new EntityNotFoundException("Workspace not found with id: " + workspace_id));

        workspace.setIsPrivate(!workspace.getIsPrivate());

        workspaceRepo.save(workspace);
    }

}

package com.example.Coder.Service.impl;

// import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Coder.DTO.WorkspaceDTO;
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

 

     @Override
    public List<WorkspaceDTO> getAllWorkspaces() {
        List<Workspace> workspaces = workspaceRepo.findAll();
        return workspaces.stream()
                .map(this::convertWorkspaceToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public WorkspaceDTO getWorkspace(Long workspaceId) {
        Workspace workspace = workspaceRepo.findById(workspaceId).orElse(null);
        if (workspace != null) {
            return convertWorkspaceToDTO(workspace);
        }
        return null;
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
    private WorkspaceDTO convertWorkspaceToDTO(Workspace workspace) {
        WorkspaceDTO workspaceDTO = new WorkspaceDTO();
        workspaceDTO.setId(workspace.getId());
        workspaceDTO.setTitle(workspace.getTitle());
        workspaceDTO.setDescription(workspace.getDescription());
        workspaceDTO.setPrivate(workspace.getIsPrivate());
        

        return workspaceDTO;
    }
}


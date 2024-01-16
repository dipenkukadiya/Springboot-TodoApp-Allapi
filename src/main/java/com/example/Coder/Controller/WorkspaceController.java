package com.example.Coder.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Coder.Entity.Workspace;
import com.example.Coder.Service.WorkspaceService;


@RestController
@RequestMapping("/api/v1/workspaces")
public class WorkspaceController {
    @Autowired
    WorkspaceService workspaceService;

    @PostMapping
    public ResponseEntity<Void> addWorkspace(@RequestBody Workspace workspace) {
        workspaceService.addWorkspace(workspace);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Workspace> getWorkspaces() {
        return workspaceService.getAllWorkspaces();
    }

    @GetMapping("/{workspace_id}")
    public Workspace getWorkspace(@PathVariable Long workspace_id) {
        return workspaceService.getWorkspace(workspace_id);
    }

    @PutMapping("/{workspace_id}")
    public ResponseEntity<Void> updateWorkspace(@RequestBody Workspace workspace, @PathVariable Long workspace_id) {
        workspaceService.updateWorkspace(workspace, workspace_id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{workspace_id}")
    public ResponseEntity<Void> removeWorkspace(@PathVariable Long workspace_id) {
        workspaceService.removeWorkspace(workspace_id);
        return ResponseEntity.ok().build();
    }
     @PatchMapping("/togglePrivacy/{workspace_id}")
    public ResponseEntity<Void> togglePrivacy(@PathVariable Long workspace_id) {
        workspaceService.toggleIsprivacy(workspace_id);
        return ResponseEntity.ok().build();
    }
    
}


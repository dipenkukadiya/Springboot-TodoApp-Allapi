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

import com.example.Coder.DTO.WorkspaceDTO;
// import com.example.Coder.Entity.Board;
// import com.example.Coder.Entity.Workspace;
// import com.example.Coder.Request.BoardRequest;
import com.example.Coder.Request.WorkspaceRequest;
import com.example.Coder.Service.WorkspaceService;

@RestController
@RequestMapping("/api/v1/workspaces")
public class WorkspaceController {

    @Autowired
    private WorkspaceService workspaceService;

    @PostMapping
    public ResponseEntity<Void> createWorkspace(@RequestBody WorkspaceRequest workspaceRequest) {
        workspaceService.addWorkspace(workspaceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<WorkspaceDTO>> getAllWorkspaces() {
        List<WorkspaceDTO> workspaces = workspaceService.getAllWorkspaces();
        return ResponseEntity.ok(workspaces);
    }

    @GetMapping("/{workspaceId}")
    public ResponseEntity<WorkspaceDTO> getWorkspace(@PathVariable Long workspaceId) {
        System.out.println("hello world");
        WorkspaceDTO workspace = workspaceService.getWorkspace(workspaceId);
        return ResponseEntity.ok(workspace);
    }

    @PutMapping("/{workspaceId}")
    public ResponseEntity<Void> updateWorkspace(@RequestBody WorkspaceRequest workspaceRequest,
            @PathVariable Long workspaceId) {
        workspaceService.updateWorkspace(workspaceRequest, workspaceId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{workspaceId}")
    public ResponseEntity<Void> removeWorkspace(@PathVariable Long workspaceId) {
        workspaceService.removeWorkspace(workspaceId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{workspaceId}/togglePrivacy")
    public ResponseEntity<Void> togglePrivacy(@PathVariable Long workspaceId) {
        workspaceService.toggleIsprivacy(workspaceId);
        return ResponseEntity.ok().build();
    }
}

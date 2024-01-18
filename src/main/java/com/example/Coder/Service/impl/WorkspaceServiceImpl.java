package com.example.Coder.Service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Coder.Entity.Board;
import com.example.Coder.Entity.Workspace;
import com.example.Coder.Repository.BoardRepo;
import com.example.Coder.Repository.WorkspaceRepo;
import com.example.Coder.Request.BoardRequest;
import com.example.Coder.Request.WorkspaceRequest;
import com.example.Coder.Service.WorkspaceService;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {

    @Autowired
    private WorkspaceRepo workspaceRepo;

    @Autowired
    private BoardRepo boardRepo;

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
        System.out.println("hello world ,,,,,,,,,,,,,,,,,,,,");

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

    @Override
    public List<Board> getAllBoards(Long workspace_id) {
        
        Workspace workspace = workspaceRepo.findById(workspace_id).orElse(null);
        if (workspace != null) {
            return workspace.getBoards();
        }
        return Collections.emptyList();
    }

    @Override
    public Board getBoard(Long workspace_id, Long board_id) {
        Workspace workspace = workspaceRepo.findById(workspace_id).orElse(null);
        if (workspace != null) {
            return boardRepo.findByIdAndWorkspace(board_id, workspace);
        }
        return null;
    }

    @Override
    public void addBoard(Long workspaceId, BoardRequest boardRequest) {
        Workspace workspace = workspaceRepo.findById(workspaceId).orElse(null);
        if (workspace != null) {
            Board board = new Board();
            board.setTitle(boardRequest.getTitle());
            board.setDescription(boardRequest.getDescription());
            board.setArchive(boardRequest.getArchive());
            board.setFavorite(boardRequest.getFavorite());

            board.setWorkspace(workspace);
            workspace.getBoards().add(board);

            workspaceRepo.save(workspace);
        }
    }

    @Override
    public void updateBoard(Long workspaceId, Long boardId, BoardRequest boardRequest) {
        Workspace workspace = workspaceRepo.findById(workspaceId).orElse(null);
        if (workspace != null) {
            Board board = boardRepo.findByIdAndWorkspace(boardId, workspace);
            if (board != null) {
                board.setTitle(boardRequest.getTitle());
                board.setDescription(boardRequest.getDescription());
                board.setArchive(boardRequest.getArchive());
                board.setFavorite(boardRequest.getFavorite());
                boardRepo.save(board);
            }
        }
    }

    @Override
    public void removeBoard(Long workspaceId, Long boardId) {
        Workspace workspace = workspaceRepo.findById(workspaceId).orElse(null);
        if (workspace != null) {
            Board board = boardRepo.findById(boardId).orElse(null);
            if (board != null) {
                workspace.getBoards().remove(board);
                workspaceRepo.save(workspace);
            }
        }
    }

    @Override
    public void toggleBoardIsArchive(Long workspaceId, Long boardId) {
        Workspace workspace = workspaceRepo.findById(workspaceId).orElse(null);
        if (workspace != null) {
            Board board = boardRepo.findByIdAndWorkspace(boardId, workspace);
            if (board != null) {
                board.setArchive(!board.getArchive());
                boardRepo.save(board);
            }
        }
    }

    @Override
    public void toggleBoardIsFavorite(Long workspaceId, Long boardId) {
        Workspace workspace = workspaceRepo.findById(workspaceId).orElse(null);
        if (workspace != null) {
            Board board = boardRepo.findByIdAndWorkspace(boardId, workspace);
            if (board != null) {
                board.setFavorite(!board.getFavorite());
                boardRepo.save(board);
            }
        }
    }
}

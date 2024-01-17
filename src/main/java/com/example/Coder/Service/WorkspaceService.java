package com.example.Coder.Service;

import java.util.List;

import com.example.Coder.Entity.Board;
import com.example.Coder.Entity.Workspace;
import com.example.Coder.Request.BoardRequest;
import com.example.Coder.Request.WorkspaceRequest;

public interface WorkspaceService {

       

       List<Workspace> getAllWorkspaces();

       void addWorkspace(WorkspaceRequest workspaceRequest);

       Workspace getWorkspace(Long workspace_id);

       void updateWorkspace(WorkspaceRequest workspaceRequest, Long workspace_id);

       void removeWorkspace(Long workspace_id);

       void toggleIsprivacy(Long workspace_id);

       


       List<Board> getAllBoards(Long workspace_id);

       Board getBoard(Long workspace_id, Long board_id);

       void addBoard(Long workspaceId, BoardRequest boardRequest);

       void updateBoard(Long workspaceId, Long boardId, BoardRequest boardRequest);

       void removeBoard(Long workspaceId, Long boardId);

       void toggleBoardIsArchive(Long workspaceId, Long boardId);

       void toggleBoardIsFavorite(Long workspaceId, Long boardId);

}

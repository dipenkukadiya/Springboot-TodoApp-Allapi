package com.example.Coder.Service;

import java.util.List;

import com.example.Coder.DTO.BoardDTO;
import com.example.Coder.Request.BoardRequest;

public interface BoardService {
    List<BoardDTO> getAllBoards();

    List<BoardDTO> getAllBoardByWorkspaceId(Long workspaceId);

    BoardDTO getBoardByWorkspaceid(Long workspaceId, Long boardId);

    void addBoard(Long workspaceId, BoardRequest boardRequest);

    void updateBoard(Long workspaceId, Long boardId, BoardRequest boardRequest);

    void removeBoard(Long workspaceId, Long boardId);

    void toggleBoardIsFavorite(Long workspaceId, Long boardId);

}

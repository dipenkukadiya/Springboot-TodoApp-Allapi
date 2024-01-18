package com.example.Coder.Service;

import java.util.List;

import com.example.Coder.DTO.BoardDTO;
import com.example.Coder.Request.BoardRequest;

public interface BoardService {

    List<BoardDTO> getAllBoardByWorkspaceId(Long workspace_id);

    BoardDTO getBoardByWorkspaceid(Long workspace_id,Long board_id);

    void addBoard(Long workspace_id, BoardRequest boardRequest);

    void updateBoard(Long workspace_id, Long board_id, BoardRequest boardRequest);

    void removeBoard(Long workspace_id,Long board_id);

    void toggleBoardIsArchive(Long workspace_id, Long board_id);

    void toggleBoardIsFavorite(Long workspace_id, Long board_id);


}
